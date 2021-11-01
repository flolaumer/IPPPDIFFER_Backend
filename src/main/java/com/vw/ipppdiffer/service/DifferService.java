package com.vw.ipppdiffer.service;

import com.vw.ipppdiffer.model.xml.IB1;
import com.vw.ipppdiffer.model.xml.ObjectFactory;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
@NoArgsConstructor
public class DifferService {

    public IB1 getDiffer() {
        IB1 ib1XMLModel = parseIB1();
        System.out.println(ib1XMLModel.toString());
        return ib1XMLModel;
    }

    private IB1 parseIB1() {
        try {
            File file = ResourceUtils.getFile("classpath:IB100FF.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            FileReader xmlFile = new FileReader(file);
            IB1 documentIB1 = ((JAXBElement<IB1>) jaxbContext.createUnmarshaller().unmarshal(xmlFile)).getValue();
            return documentIB1;
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return new IB1();
    }

}
