/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.mdl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lveliz
 */
@Entity
@Table(name = "VISIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v")
    , @NamedQuery(name = "Visit.findByIdVisit", query = "SELECT v FROM Visit v WHERE v.idVisit = :idVisit")
    , @NamedQuery(name = "Visit.findByDiagnostic", query = "SELECT v FROM Visit v WHERE v.diagnostic = :diagnostic")
    , @NamedQuery(name = "Visit.findByPrescription", query = "SELECT v FROM Visit v WHERE v.prescription = :prescription")})
public class Visit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VISIT")
    private Integer idVisit;
    @Size(max = 45)
    @Column(name = "DIAGNOSTIC")
    private String diagnostic;
    @Size(max = 45)
    @Column(name = "PRESCRIPTION")
    private String prescription;
    @JoinColumn(name = "ID_APPOINTMENT", referencedColumnName = "ID_APPOINTMENT")
    @ManyToOne(optional = false)
    private Appointment idAppointment;

    public Visit() {
    }

    public Visit(Integer idVisit) {
        this.idVisit = idVisit;
    }

    public Integer getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(Integer idVisit) {
        this.idVisit = idVisit;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Appointment getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(Appointment idAppointment) {
        this.idAppointment = idAppointment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisit != null ? idVisit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visit)) {
            return false;
        }
        Visit other = (Visit) object;
        if ((this.idVisit == null && other.idVisit != null) || (this.idVisit != null && !this.idVisit.equals(other.idVisit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.Visit[ idVisit=" + idVisit + " ]";
    }
    
}
