//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.29 at 04:51:57 PM EEST 
//


package com.vw.ipppdiffer.model.xml;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for IB-1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IB-1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{}IB-ELEMENT"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RELEASE-DATE" type="{}DATE" minOccurs="0"/&gt;
 *         &lt;element name="IBN-REQUIRED" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="IMAGE-REF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DOC-INFO" type="{}DOCUMENT-INFO"/&gt;
 *         &lt;element name="IB-DESCRIPTION" type="{}IB-DESCRIPTION"/&gt;
 *         &lt;element name="CUSTOMER-ADJUSTMENTS" type="{}CUSTOMER-ADJUSTMENTS" minOccurs="0"/&gt;
 *         &lt;element name="POSSIBLE-ERROR-STATES" type="{}POSSIBLE-ERROR-STATES" minOccurs="0"/&gt;
 *         &lt;element name="DIAG-INFOS" type="{}DIAGNOSTIC-INFOS" minOccurs="0"/&gt;
 *         &lt;element name="IB-OPERATIONS" type="{}IB-OPERATIONS" minOccurs="0"/&gt;
 *         &lt;element name="ENVIRONMENT" type="{}ENVIRONMENT" minOccurs="0"/&gt;
 *         &lt;element name="PROCEDURES" type="{}PROCEDURES" minOccurs="0"/&gt;
 *         &lt;element name="BZD" type="{}BZD" minOccurs="0"/&gt;
 *         &lt;element name="SECURITY-PROPERTIES" type="{}SECURITY-PROPERTIES" minOccurs="0"/&gt;
 *         &lt;element name="REFERENCES" type="{}REFERENCES" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IB-1", propOrder = {
    "releasedate",
    "ibnrequired",
    "imageref",
    "docinfo",
    "ibdescription",
    "customeradjustments",
    "possibleerrorstates",
    "diaginfos",
    "iboperations",
    "environment",
    "procedures",
    "bzd",
    "securityproperties",
    "references"
})
public class IB1
    extends IBELEMENT
{

    @XmlElement(name = "RELEASE-DATE")
    protected String releasedate;
    @XmlElement(name = "IBN-REQUIRED", defaultValue = "true")
    protected Boolean ibnrequired;
    @XmlElement(name = "IMAGE-REF")
    protected String imageref;
    @XmlElement(name = "DOC-INFO", required = true)
    protected DOCUMENTINFO docinfo;
    @XmlElement(name = "IB-DESCRIPTION", required = true)
    protected IBDESCRIPTION ibdescription;
    @XmlElement(name = "CUSTOMER-ADJUSTMENTS")
    protected CUSTOMERADJUSTMENTS customeradjustments;
    @XmlElement(name = "POSSIBLE-ERROR-STATES")
    protected POSSIBLEERRORSTATES possibleerrorstates;
    @XmlElement(name = "DIAG-INFOS")
    protected DIAGNOSTICINFOS diaginfos;
    @XmlElement(name = "IB-OPERATIONS")
    protected IBOPERATIONS iboperations;
    @XmlElement(name = "ENVIRONMENT")
    protected ENVIRONMENT environment;
    @XmlElement(name = "PROCEDURES")
    protected PROCEDURES procedures;
    @XmlElement(name = "BZD")
    protected BZD bzd;
    @XmlElement(name = "SECURITY-PROPERTIES")
    protected SECURITYPROPERTIES securityproperties;
    @XmlElement(name = "REFERENCES")
    protected REFERENCES references;
    @XmlAttribute(name = "version")
    protected String version;

    /**
     * Gets the value of the releasedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRELEASEDATE() {
        return releasedate;
    }

    /**
     * Sets the value of the releasedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRELEASEDATE(String value) {
        this.releasedate = value;
    }

    /**
     * Gets the value of the ibnrequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIBNREQUIRED() {
        return ibnrequired;
    }

    /**
     * Sets the value of the ibnrequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIBNREQUIRED(Boolean value) {
        this.ibnrequired = value;
    }

    /**
     * Gets the value of the imageref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMAGEREF() {
        return imageref;
    }

    /**
     * Sets the value of the imageref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMAGEREF(String value) {
        this.imageref = value;
    }

    /**
     * Gets the value of the docinfo property.
     * 
     * @return
     *     possible object is
     *     {@link DOCUMENTINFO }
     *     
     */
    public DOCUMENTINFO getDOCINFO() {
        return docinfo;
    }

    /**
     * Sets the value of the docinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DOCUMENTINFO }
     *     
     */
    public void setDOCINFO(DOCUMENTINFO value) {
        this.docinfo = value;
    }

    /**
     * Gets the value of the ibdescription property.
     * 
     * @return
     *     possible object is
     *     {@link IBDESCRIPTION }
     *     
     */
    public IBDESCRIPTION getIBDESCRIPTION() {
        return ibdescription;
    }

    /**
     * Sets the value of the ibdescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link IBDESCRIPTION }
     *     
     */
    public void setIBDESCRIPTION(IBDESCRIPTION value) {
        this.ibdescription = value;
    }

    /**
     * Gets the value of the customeradjustments property.
     * 
     * @return
     *     possible object is
     *     {@link CUSTOMERADJUSTMENTS }
     *     
     */
    public CUSTOMERADJUSTMENTS getCUSTOMERADJUSTMENTS() {
        return customeradjustments;
    }

    /**
     * Sets the value of the customeradjustments property.
     * 
     * @param value
     *     allowed object is
     *     {@link CUSTOMERADJUSTMENTS }
     *     
     */
    public void setCUSTOMERADJUSTMENTS(CUSTOMERADJUSTMENTS value) {
        this.customeradjustments = value;
    }

    /**
     * Gets the value of the possibleerrorstates property.
     * 
     * @return
     *     possible object is
     *     {@link POSSIBLEERRORSTATES }
     *     
     */
    public POSSIBLEERRORSTATES getPOSSIBLEERRORSTATES() {
        return possibleerrorstates;
    }

    /**
     * Sets the value of the possibleerrorstates property.
     * 
     * @param value
     *     allowed object is
     *     {@link POSSIBLEERRORSTATES }
     *     
     */
    public void setPOSSIBLEERRORSTATES(POSSIBLEERRORSTATES value) {
        this.possibleerrorstates = value;
    }

    /**
     * Gets the value of the diaginfos property.
     * 
     * @return
     *     possible object is
     *     {@link DIAGNOSTICINFOS }
     *     
     */
    public DIAGNOSTICINFOS getDIAGINFOS() {
        return diaginfos;
    }

    /**
     * Sets the value of the diaginfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link DIAGNOSTICINFOS }
     *     
     */
    public void setDIAGINFOS(DIAGNOSTICINFOS value) {
        this.diaginfos = value;
    }

    /**
     * Gets the value of the iboperations property.
     * 
     * @return
     *     possible object is
     *     {@link IBOPERATIONS }
     *     
     */
    public IBOPERATIONS getIBOPERATIONS() {
        return iboperations;
    }

    /**
     * Sets the value of the iboperations property.
     * 
     * @param value
     *     allowed object is
     *     {@link IBOPERATIONS }
     *     
     */
    public void setIBOPERATIONS(IBOPERATIONS value) {
        this.iboperations = value;
    }

    /**
     * Gets the value of the environment property.
     * 
     * @return
     *     possible object is
     *     {@link ENVIRONMENT }
     *     
     */
    public ENVIRONMENT getENVIRONMENT() {
        return environment;
    }

    /**
     * Sets the value of the environment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ENVIRONMENT }
     *     
     */
    public void setENVIRONMENT(ENVIRONMENT value) {
        this.environment = value;
    }

    /**
     * Gets the value of the procedures property.
     * 
     * @return
     *     possible object is
     *     {@link PROCEDURES }
     *     
     */
    public PROCEDURES getPROCEDURES() {
        return procedures;
    }

    /**
     * Sets the value of the procedures property.
     * 
     * @param value
     *     allowed object is
     *     {@link PROCEDURES }
     *     
     */
    public void setPROCEDURES(PROCEDURES value) {
        this.procedures = value;
    }

    /**
     * Gets the value of the bzd property.
     * 
     * @return
     *     possible object is
     *     {@link BZD }
     *     
     */
    public BZD getBZD() {
        return bzd;
    }

    /**
     * Sets the value of the bzd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BZD }
     *     
     */
    public void setBZD(BZD value) {
        this.bzd = value;
    }

    /**
     * Gets the value of the securityproperties property.
     * 
     * @return
     *     possible object is
     *     {@link SECURITYPROPERTIES }
     *     
     */
    public SECURITYPROPERTIES getSECURITYPROPERTIES() {
        return securityproperties;
    }

    /**
     * Sets the value of the securityproperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link SECURITYPROPERTIES }
     *     
     */
    public void setSECURITYPROPERTIES(SECURITYPROPERTIES value) {
        this.securityproperties = value;
    }

    /**
     * Gets the value of the references property.
     * 
     * @return
     *     possible object is
     *     {@link REFERENCES }
     *     
     */
    public REFERENCES getREFERENCES() {
        return references;
    }

    /**
     * Sets the value of the references property.
     * 
     * @param value
     *     allowed object is
     *     {@link REFERENCES }
     *     
     */
    public void setREFERENCES(REFERENCES value) {
        this.references = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
