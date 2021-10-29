package com.vw.ipppdiffer.service;

import com.vw.ipppdiffer.model.xml.IB1;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
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
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(IB1.class);
            FileReader xmlFile = new FileReader("src/main/resources/IB1_00FF_DemoEcu_V0_1.xml");
            IB1 xmlModel = (IB1) context.createUnmarshaller()
                    .unmarshal(xmlFile);
            return xmlModel;
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return new IB1();
    }

}
