//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.29 at 04:51:57 PM EEST 
//


package com.vw.ipppdiffer.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BZD complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BZD"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="S42-ATTRIBUTES-ADDED" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="TARGET-DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IDENTS" type="{}IDENTS" minOccurs="0"/&gt;
 *         &lt;element name="ADDITIONAL-IDENTS" type="{}IDENTS" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BZD", propOrder = {
        "s42ATTRIBUTESADDED",
        "targetdate",
        "idents",
        "additionalidents"
})
public class BZD {

    @XmlElement(name = "S42-ATTRIBUTES-ADDED")
    protected Boolean s42ATTRIBUTESADDED;
    @XmlElement(name = "TARGET-DATE")
    protected String targetdate;
    @XmlElement(name = "IDENTS")
    protected IDENTS idents;
    @XmlElement(name = "ADDITIONAL-IDENTS")
    protected IDENTS additionalidents;

    /**
     * Gets the value of the s42ATTRIBUTESADDED property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isS42ATTRIBUTESADDED() {
        return s42ATTRIBUTESADDED;
    }

    /**
     * Sets the value of the s42ATTRIBUTESADDED property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setS42ATTRIBUTESADDED(Boolean value) {
        this.s42ATTRIBUTESADDED = value;
    }

    /**
     * Gets the value of the targetdate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTARGETDATE() {
        return targetdate;
    }

    /**
     * Sets the value of the targetdate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTARGETDATE(String value) {
        this.targetdate = value;
    }

    /**
     * Gets the value of the idents property.
     *
     * @return possible object is
     * {@link IDENTS }
     */
    public IDENTS getIDENTS() {
        return idents;
    }

    /**
     * Sets the value of the idents property.
     *
     * @param value allowed object is
     *              {@link IDENTS }
     */
    public void setIDENTS(IDENTS value) {
        this.idents = value;
    }

    /**
     * Gets the value of the additionalidents property.
     *
     * @return possible object is
     * {@link IDENTS }
     */
    public IDENTS getADDITIONALIDENTS() {
        return additionalidents;
    }

    /**
     * Sets the value of the additionalidents property.
     *
     * @param value allowed object is
     *              {@link IDENTS }
     */
    public void setADDITIONALIDENTS(IDENTS value) {
        this.additionalidents = value;
    }

}
