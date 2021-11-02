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
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for DIAG-PARAMETERS complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DIAG-PARAMETERS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DATA-IDENTIFIER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DIAG-PARAMETER" type="{}DIAG-PARAMETER" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DIAG-PARAMETERS", propOrder = {
    "dataidentifier",
    "diagparameter"
})
public class DIAGPARAMETERS {

    @XmlElement(name = "DATA-IDENTIFIER")
    protected String dataidentifier;
    @XmlElement(name = "DIAG-PARAMETER")
    protected List<DIAGPARAMETER> diagparameter;

    /**
     * Gets the value of the dataidentifier property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDATAIDENTIFIER() {
        return dataidentifier;
    }

    /**
     * Sets the value of the dataidentifier property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDATAIDENTIFIER(String value) {
        this.dataidentifier = value;
    }

    /**
     * Gets the value of the diagparameter property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the diagparameter property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDIAGPARAMETER().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DIAGPARAMETER }
     *
     *
     */
    public List<DIAGPARAMETER> getDIAGPARAMETER() {
        if (diagparameter == null) {
            diagparameter = new ArrayList<DIAGPARAMETER>();
        }
        return this.diagparameter;
    }

}
