//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.4 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package com.example.soap.ws.loaneligibility;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="isEligible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="approvedAmount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="CriteriaMismatch" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isEligible",
    "approvedAmount",
    "criteriaMismatch"
})
@XmlRootElement(name = "Acknowledgement")
public class Acknowledgement {

    protected boolean isEligible;
    protected long approvedAmount;
    @XmlElement(name = "CriteriaMismatch", required = true)
    protected List<String> criteriaMismatch;

    /**
     * Obtient la valeur de la propriété isEligible.
     * 
     */
    public boolean isIsEligible() {
        return isEligible;
    }

    /**
     * Définit la valeur de la propriété isEligible.
     * 
     */
    public void setIsEligible(boolean value) {
        this.isEligible = value;
    }

    /**
     * Obtient la valeur de la propriété approvedAmount.
     * 
     */
    public long getApprovedAmount() {
        return approvedAmount;
    }

    /**
     * Définit la valeur de la propriété approvedAmount.
     * 
     */
    public void setApprovedAmount(long value) {
        this.approvedAmount = value;
    }

    /**
     * Gets the value of the criteriaMismatch property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the criteriaMismatch property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getCriteriaMismatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * </p>
     * 
     * 
     * @return
     *     The value of the criteriaMismatch property.
     */
    public List<String> getCriteriaMismatch() {
        if (criteriaMismatch == null) {
            criteriaMismatch = new ArrayList<>();
        }
        return this.criteriaMismatch;
    }

}
