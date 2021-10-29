package com.vw.ipppdiffer.model.xml;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "PROCEDURE")
@XmlType(propOrder = {"name"})
@Getter
@ToString
public class Procedure {

    private String id;
    private String name;

    @XmlElement(name = "NAME")
    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }
}
