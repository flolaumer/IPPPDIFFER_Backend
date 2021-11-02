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
 * <p>Java class for CONDITIONS complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CONDITIONS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BUILDUP-CONDITIONS" type="{}DESC" minOccurs="0"/&gt;
 *         &lt;element name="GENERAL-CONDITIONS" type="{}DESC" minOccurs="0"/&gt;
 *         &lt;element name="DEPENDENCIES" type="{}DESC" minOccurs="0"/&gt;
 *         &lt;element name="RESSOURCES" type="{}DESC" minOccurs="0"/&gt;
 *         &lt;element name="MISCELLANEOUS" type="{}DESC" minOccurs="0"/&gt;
 *         &lt;element name="MANUAL-OPERATIONS" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONDITIONS", propOrder = {
    "buildupconditions",
    "generalconditions",
    "dependencies",
    "ressources",
    "miscellaneous",
    "manualoperations"
})
public class CONDITIONS {

    @XmlElement(name = "BUILDUP-CONDITIONS")
    protected String buildupconditions;
    @XmlElement(name = "GENERAL-CONDITIONS")
    protected String generalconditions;
    @XmlElement(name = "DEPENDENCIES")
    protected String dependencies;
    @XmlElement(name = "RESSOURCES")
    protected String ressources;
    @XmlElement(name = "MISCELLANEOUS")
    protected String miscellaneous;
    @XmlElement(name = "MANUAL-OPERATIONS", defaultValue = "false")
    protected Boolean manualoperations;

    /**
     * Gets the value of the buildupconditions property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBUILDUPCONDITIONS() {
        return buildupconditions;
    }

    /**
     * Sets the value of the buildupconditions property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBUILDUPCONDITIONS(String value) {
        this.buildupconditions = value;
    }

    /**
     * Gets the value of the generalconditions property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGENERALCONDITIONS() {
        return generalconditions;
    }

    /**
     * Sets the value of the generalconditions property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGENERALCONDITIONS(String value) {
        this.generalconditions = value;
    }

    /**
     * Gets the value of the dependencies property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDEPENDENCIES() {
        return dependencies;
    }

    /**
     * Sets the value of the dependencies property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDEPENDENCIES(String value) {
        this.dependencies = value;
    }

    /**
     * Gets the value of the ressources property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRESSOURCES() {
        return ressources;
    }

    /**
     * Sets the value of the ressources property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRESSOURCES(String value) {
        this.ressources = value;
    }

    /**
     * Gets the value of the miscellaneous property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMISCELLANEOUS() {
        return miscellaneous;
    }

    /**
     * Sets the value of the miscellaneous property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMISCELLANEOUS(String value) {
        this.miscellaneous = value;
    }

    /**
     * Gets the value of the manualoperations property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isMANUALOPERATIONS() {
        return manualoperations;
    }

    /**
     * Sets the value of the manualoperations property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setMANUALOPERATIONS(Boolean value) {
        this.manualoperations = value;
    }

}
