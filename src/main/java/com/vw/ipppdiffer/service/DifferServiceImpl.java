package com.vw.ipppdiffer.service;

import com.vw.ipppdiffer.exception.UnknownException;
import com.vw.ipppdiffer.model.enums.ColourType;
import com.vw.ipppdiffer.model.response.Element;
import com.vw.ipppdiffer.model.xml.IB1;
import com.vw.ipppdiffer.model.xml.ObjectFactory;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@NoArgsConstructor
public class DifferServiceImpl implements DifferService {

    @Override
    public IB1 getDiffer() {
        return new IB1();
    }

    @SuppressWarnings("unchecked")
    private IB1 parseXMLFile(InputStream xmlFile) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            IB1 documentIB1 = ((JAXBElement<IB1>) jaxbContext.createUnmarshaller().unmarshal(xmlFile)).getValue();
            return documentIB1;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return new IB1();
    }

    @Override
    public Element getTreeStructure(MultipartFile file) {
        InputStream fileInputStream;
        try {
            fileInputStream = file.getInputStream();
        } catch (IOException e) {
            throw new UnknownException("Could not read xml file");
        }
        IB1 ib1XMLModel = parseXMLFile(fileInputStream);
        Element root;
        try {
            root = buildTree(ib1XMLModel);
        } catch (IllegalAccessException e) {
            log.info("Could not build XML Tree");
            throw new UnknownException("Could not build XML Tree");
        }
        return root;
    }

    private Element buildTree(Object object) throws IllegalAccessException {
        Element element = new Element();
        String name = object.getClass().getSimpleName();
        List<Element> children = new ArrayList<>();
        Class<?> clazz = object.getClass();
        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        for (Field field : fields) {
            if (hasAnnotation(field, XmlElement.class) && !isSimpleType(field.getType())) {
                createIntermediateNode(children, object, field);
            } else if (isSimpleType(field.getType())) {
                createLeafNode(children, object, field);
            }
        }
        element.setColor(ColourType.BLACK.value);
        element.setName(name);
        element.setChildren(children);
        return element;
    }

    private void createIntermediateNode(List<Element> children, Object object, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        if (field.get(object) != null && field.getType() != List.class) {
            Element childElement = buildTree(field.get(object));
            children.add(childElement);
        } else if (field.getType() == List.class && field.get(object) != null) {
            for (Object node : (ArrayList<?>) field.get(object)) {
                Element childElement = buildTree(node);
                children.add(childElement);
            }
        }
    }

    private void createLeafNode(List<Element> children, Object object, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        if (field.get(object) != null) {
            Element leaf = new Element();
            leaf.setName(field.getName());
            leaf.setColor(ColourType.BLACK.value);
            leaf.setValue(field.get(object).toString());
            children.add(leaf);
        }
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

}
