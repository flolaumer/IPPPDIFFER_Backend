package com.vw.ipppdiffer.model.xml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "IB-1")
@XmlType(propOrder = {"name", "releaseDate", "ibnRequired", "procedures"})
@Getter
@ToString
@EqualsAndHashCode
public class IB1 {
    private String name;
    private String releaseDate;
    private boolean ibnRequired;
    private Procedures procedures;

    @XmlElement(name = "NAME")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "RELEASE-DATE")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @XmlElement(name = "IBN-REQUIRED")
    public void setIbnRequired(boolean ibnRequired) {
        this.ibnRequired = ibnRequired;
    }

    @XmlElement(name = "PROCEDURES")
    public void setProcedures(Procedures procedures) {
        this.procedures = procedures;
    }
}
