package com.vw.ipppdiffer.model.xml;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "PROCEDURES")
@XmlType(propOrder = {"procedure"})
@Getter
@ToString
public class Procedures {
    private List<Procedure> procedure;

    @XmlElement(name = "PROCEDURE")
    public void setProcedure(List<Procedure> procedure) {
        this.procedure = procedure;
    }


}
