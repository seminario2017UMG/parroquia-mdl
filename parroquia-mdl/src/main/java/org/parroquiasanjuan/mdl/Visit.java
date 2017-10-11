/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.mdl;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    , @NamedQuery(name = "Visit.findByIdVisit", query = "SELECT v FROM Visit v WHERE v.visitPK.idVisit = :idVisit")
    , @NamedQuery(name = "Visit.findByIdAppointment", query = "SELECT v FROM Visit v WHERE v.visitPK.idAppointment = :idAppointment")
    , @NamedQuery(name = "Visit.findByDiagnostic", query = "SELECT v FROM Visit v WHERE v.diagnostic = :diagnostic")
    , @NamedQuery(name = "Visit.findByPrescription", query = "SELECT v FROM Visit v WHERE v.prescription = :prescription")
    , @NamedQuery(name = "Visit.findByInsertedBy", query = "SELECT v FROM Visit v WHERE v.insertedBy = :insertedBy")
    , @NamedQuery(name = "Visit.findByInsertedOn", query = "SELECT v FROM Visit v WHERE v.insertedOn = :insertedOn")
    , @NamedQuery(name = "Visit.findByUpdatedBy", query = "SELECT v FROM Visit v WHERE v.updatedBy = :updatedBy")
    , @NamedQuery(name = "Visit.findByUpdatedOn", query = "SELECT v FROM Visit v WHERE v.updatedOn = :updatedOn")
    , @NamedQuery(name = "Visit.findByStatus", query = "SELECT v FROM Visit v WHERE v.status = :status")})
public class Visit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VisitPK visitPK;
    @Size(max = 45)
    @Column(name = "DIAGNOSTIC")
    private String diagnostic;
    @Size(max = 45)
    @Column(name = "PRESCRIPTION")
    private String prescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSERTED_BY")
    private int insertedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSERTED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertedOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPDATED_BY")
    private int updatedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPDATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private boolean status;
    @JoinColumn(name = "ID_APPOINTMENT", referencedColumnName = "ID_APPOINTMENT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Appointment appointment;

    public Visit() {
    }

    public Visit(VisitPK visitPK) {
        this.visitPK = visitPK;
    }

    public Visit(VisitPK visitPK, int insertedBy, Date insertedOn, int updatedBy, Date updatedOn, boolean status) {
        this.visitPK = visitPK;
        this.insertedBy = insertedBy;
        this.insertedOn = insertedOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.status = status;
    }

    public Visit(int idVisit, int idAppointment) {
        this.visitPK = new VisitPK(idVisit, idAppointment);
    }

    public VisitPK getVisitPK() {
        return visitPK;
    }

    public void setVisitPK(VisitPK visitPK) {
        this.visitPK = visitPK;
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

    public int getInsertedBy() {
        return insertedBy;
    }

    public void setInsertedBy(int insertedBy) {
        this.insertedBy = insertedBy;
    }

    public Date getInsertedOn() {
        return insertedOn;
    }

    public void setInsertedOn(Date insertedOn) {
        this.insertedOn = insertedOn;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitPK != null ? visitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visit)) {
            return false;
        }
        Visit other = (Visit) object;
        if ((this.visitPK == null && other.visitPK != null) || (this.visitPK != null && !this.visitPK.equals(other.visitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.Visit[ visitPK=" + visitPK + " ]";
    }
    
}
