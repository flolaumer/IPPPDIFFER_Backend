package com.vw.ipppdiffer.service;

import com.vw.ipppdiffer.exception.UnknownException;
import com.vw.ipppdiffer.model.enums.ColourType;
import com.vw.ipppdiffer.model.response.Attribute;
import com.vw.ipppdiffer.model.response.DifferResponse;
import com.vw.ipppdiffer.model.response.Element;
import com.vw.ipppdiffer.model.xml.IB1;
import com.vw.ipppdiffer.model.xml.ObjectFactory;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

@Slf4j
@Service
@NoArgsConstructor
public class DifferServiceImpl implements DifferService {

    @Override
    public DifferResponse getDiffer(MultipartFile firstFile, MultipartFile secondFile) {
        Element firstTree = buildTreeFromFile(firstFile, ColourType.NONE);
        Element secondTree = buildTreeFromFile(secondFile, ColourType.NONE);
        compareTrees(singletonList(firstTree), singletonList(secondTree));
        return new DifferResponse(firstTree, secondTree);
    }

    @Override
    public Element getTreeStructure(MultipartFile file) {
        return buildTreeFromFile(file, ColourType.BLACK);
    }

    private void compareTrees(List<Element> firstTree, List<Element> secondTree) {
        if (CollectionUtils.isEmpty(firstTree) && CollectionUtils.isEmpty(secondTree)) {
            return;
        }
        for (Element fElement : firstTree) {
            if (!ColourType.NONE.value.equals(fElement.getColor())) {
                continue;
            }
            int indexOfFirstNode = firstTree.indexOf(fElement);
            visitBasedOnAttributes(secondTree, fElement, indexOfFirstNode);
            visitBasedOnPosition(secondTree, fElement);
        }
        setColorRecursively(secondTree, ColourType.RED);
        setColorRecursively(firstTree, ColourType.GREEN);
    }

    private void visitBasedOnPosition(List<Element> secondTree, Element fElement) {
        for (Element sElement : secondTree) {
            if (!ColourType.NONE.value.equals(sElement.getColor())) {
                continue;
            }
            if (fElement.getName().equals(sElement.getName())) {
                if (haveEqualAttributes(fElement, sElement, true) && haveEqualValue(fElement.getValue(), sElement.getValue())) {
                    fElement.setColor(ColourType.BLACK.value);
                    sElement.setColor(ColourType.BLACK.value);
                } else {
                    fElement.setColor(ColourType.ORANGE.value);
                    sElement.setColor(ColourType.ORANGE.value);
                }
                compareTrees(fElement.getChildren(), sElement.getChildren());
                break;
            }
        }
    }

    private void visitBasedOnAttributes(List<Element> secondTree, Element fElement, int indexOfFirstNode) {
        for (Element sElement : secondTree) {
            if (!ColourType.NONE.value.equals(sElement.getColor())) {
                continue;
            }
            int indexOfSecondNode = secondTree.indexOf(sElement);
            if (fElement.getName().equals(sElement.getName())
                    && haveEqualAttributes(fElement, sElement, false)
                    && haveEqualValue(fElement.getValue(), sElement.getValue())
                    && indexOfFirstNode != indexOfSecondNode) {
                fElement.setColor(ColourType.ORANGE.value);
                sElement.setColor(ColourType.ORANGE.value);
                compareTrees(fElement.getChildren(), sElement.getChildren());
                break;
            }
        }
    }

    private void setColorRecursively(List<Element> tree, ColourType colour) {
        for (Element node : tree) {
            if (ColourType.NONE.value.equals(node.getColor())) {
                node.setColor(colour.value);
            }
            if (!CollectionUtils.isEmpty(node.getChildren())) {
                setColorRecursively(node.getChildren(), colour);
            }
        }
    }

    private boolean haveEqualValue(String firstValue, String secondValue) {
        if (firstValue == null && secondValue == null) {
            return true;
        }
        return firstValue != null && firstValue.equals(secondValue);
    }

    private boolean haveEqualAttributes(Element firstElement, Element secondElement, boolean nullable) {
        if (CollectionUtils.isEmpty(firstElement.getAttributes()) && CollectionUtils.isEmpty(secondElement.getAttributes())) {
            return nullable;
        }
        return new HashSet<>(firstElement.getAttributes()).equals(new HashSet<>(secondElement.getAttributes()));
    }

    @SuppressWarnings("unchecked")
    private IB1 parseXMLFile(InputStream xmlFile) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            return ((JAXBElement<IB1>) jaxbContext.createUnmarshaller().unmarshal(xmlFile)).getValue();
        } catch (JAXBException e) {
            throw new UnknownException("Could not deserialize XML");
        }
    }

    private Element buildTreeFromFile(MultipartFile file, ColourType colour) {
        InputStream fileInputStream;
        try {
            fileInputStream = file.getInputStream();
        } catch (IOException e) {
            throw new UnknownException("Could not read xml file");
        }
        IB1 ib1XMLModel = parseXMLFile(fileInputStream);
        Element root;
        try {
            root = buildTree(ib1XMLModel, colour);
        } catch (IllegalAccessException e) {
            log.info("Could not build XML Tree");
            throw new UnknownException("Could not build XML Tree");
        }
        return root;
    }

    private Element buildTree(Object object, ColourType colour) throws IllegalAccessException {
        Element element = new Element();
        List<Element> children = new ArrayList<>();
        Class<?> clazz = object.getClass();
        List<Attribute> attributes = new ArrayList<>();
        List<Field> fields = getAllInheritedFields(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            boolean isXmlElement = hasAnnotation(field, XmlElement.class) || hasAnnotation(field, XmlElements.class);
            if (hasAnnotation(field, XmlAttribute.class) && field.get(object) != null) {
                Attribute attribute = new Attribute();
                attribute.setName(field.getName());
                attribute.setValue(field.get(object).toString());
                attributes.add(attribute);
            } else if (isXmlElement && !isSimpleType(field.getType())) {
                createIntermediateNode(children, object, field, colour);
            } else if (isXmlElement && isSimpleType(field.getType())) {
                createLeafNode(children, object, field, colour);
            }
        }
        element.setAttributes(attributes);
        element.setColor(colour.value);
        element.setName(extractClassXMLName(object));
        element.setChildren(children);
        return element;
    }

    private void createIntermediateNode(List<Element> children, Object object, Field field, ColourType colour) throws IllegalAccessException {
        if (field.get(object) != null && field.getType() != List.class) {
            Element childElement = buildTree(field.get(object), colour);
            children.add(childElement);
        } else if (field.getType() == List.class && field.get(object) != null) {
            for (Object node : (ArrayList<?>) field.get(object)) {
                Element childElement = createListNode(node, field, colour);
                children.add(childElement);
            }
        }
    }

    private Element createListNode(Object object, Field field, ColourType colour) throws IllegalAccessException {
        Element childElement;
        if (isSimpleType(object.getClass())) {
            childElement = new Element();
            childElement.setName(extractPropertyXMLName(field));
            childElement.setColor(colour.value);
            childElement.setValue(object.toString());
        } else {
            childElement = buildTree(object, colour);
        }
        return childElement;
    }

    private void createLeafNode(List<Element> children, Object object, Field field, ColourType colour) throws IllegalAccessException {
        if (field.get(object) != null) {
            Element leaf = new Element();
            leaf.setName(extractPropertyXMLName(field));
            leaf.setColor(colour.value);
            leaf.setValue(field.get(object).toString());
            children.add(leaf);
        }
    }

    private String extractPropertyXMLName(Field field) {
        return hasAnnotation(field, XmlElement.class) ? field.getAnnotation(XmlElement.class).name()
                : field.getName();
    }

    private String extractClassXMLName(Object object) {
        return object.getClass().isAnnotationPresent(XmlType.class) ? object.getClass().getAnnotation(XmlType.class).name()
                : object.getClass().getSimpleName();
    }

    private boolean isSimpleType(Object object) {
        return object == String.class ||
                object == Boolean.class ||
                object == BigDecimal.class;
    }

    private boolean hasAnnotation(Field field, Class<?> annotation) {
        List<Annotation> annotations = Arrays.asList(field.getDeclaredAnnotations());
        List<? extends Class<? extends Annotation>> annotationTypes = annotations
                .stream()
                .map(Annotation::annotationType)
                .collect(Collectors.toList());
        return annotationTypes.contains(annotation);
    }

    private List<Field> getAllInheritedFields(Class<?> clazz) {
        List<Field> result = new ArrayList<>();
        Class<?> classTree = clazz;
        while (classTree != null && classTree != Object.class && !classTree.isEnum()) {
            Collections.addAll(result, classTree.getDeclaredFields());
            classTree = classTree.getSuperclass();
        }
        return result;
    }

}
