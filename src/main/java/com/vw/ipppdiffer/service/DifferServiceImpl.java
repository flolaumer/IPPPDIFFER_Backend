package com.vw.ipppdiffer.service;

import com.vw.ipppdiffer.exception.DifferParseException;
import com.vw.ipppdiffer.model.enums.ColourType;
import com.vw.ipppdiffer.model.response.Attribute;
import com.vw.ipppdiffer.model.response.DifferResponse;
import com.vw.ipppdiffer.model.response.Element;
import com.vw.ipppdiffer.model.xml.IB1;
import com.vw.ipppdiffer.model.xml.ObjectFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DifferServiceImpl implements DifferService {

    private final DifferComponent differComponent;

    @Override
    public DifferResponse getDiffer(MultipartFile firstFile, MultipartFile secondFile) throws DifferParseException {
        Element firstTree = buildTreeFromFile(firstFile, ColourType.NONE);
        Element secondTree = buildTreeFromFile(secondFile, ColourType.NONE);
        differComponent.compareTrees(singletonList(firstTree), singletonList(secondTree));
        return new DifferResponse(firstTree, secondTree);
    }

    @Override
    public Element getTreeStructure(MultipartFile file) throws DifferParseException {
        return buildTreeFromFile(file, ColourType.BLACK);
    }

    @SuppressWarnings("unchecked")
    private IB1 parseXMLFile(InputStream xmlFile) throws DifferParseException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            return ((JAXBElement<IB1>) jaxbContext.createUnmarshaller().unmarshal(xmlFile)).getValue();
        } catch (JAXBException e) {
            throw new DifferParseException("Could not deserialize XML");
        }
    }

    private Element buildTreeFromFile(MultipartFile file, ColourType colour) throws DifferParseException {
        InputStream fileInputStream;
        try {
            fileInputStream = file.getInputStream();
        } catch (IOException e) {
            throw new DifferParseException("Could not read xml file");
        }
        IB1 ib1XMLModel = parseXMLFile(fileInputStream);
        Element root;
        try {
            root = buildTree(ib1XMLModel, colour);
        } catch (IllegalAccessException e) {
            log.info("Could not build XML Tree");
            throw new DifferParseException("Could not build XML Tree");
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
