/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.mdl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lveliz
 */
@Entity
@Table(name = "BLOOD_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BloodType.findAll", query = "SELECT b FROM BloodType b")
    , @NamedQuery(name = "BloodType.findByIdBloodType", query = "SELECT b FROM BloodType b WHERE b.idBloodType = :idBloodType")
    , @NamedQuery(name = "BloodType.findByDescription", query = "SELECT b FROM BloodType b WHERE b.description = :description")
    , @NamedQuery(name = "BloodType.findByInsertedBy", query = "SELECT b FROM BloodType b WHERE b.insertedBy = :insertedBy")
    , @NamedQuery(name = "BloodType.findByInsertedOn", query = "SELECT b FROM BloodType b WHERE b.insertedOn = :insertedOn")
    , @NamedQuery(name = "BloodType.findByUpdatedBy", query = "SELECT b FROM BloodType b WHERE b.updatedBy = :updatedBy")
    , @NamedQuery(name = "BloodType.findByUpdatedOn", query = "SELECT b FROM BloodType b WHERE b.updatedOn = :updatedOn")
    , @NamedQuery(name = "BloodType.findByStatus", query = "SELECT b FROM BloodType b WHERE b.status = :status")})
public class BloodType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_BLOOD_TYPE")
    private Integer idBloodType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "DESCRIPTION")
    private String description;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBloodType")
    private List<Patient> patientList;

    public BloodType() {
    }

    public BloodType(Integer idBloodType) {
        this.idBloodType = idBloodType;
    }

    public BloodType(Integer idBloodType, String description, int insertedBy, Date insertedOn, int updatedBy, Date updatedOn, boolean status) {
        this.idBloodType = idBloodType;
        this.description = description;
        this.insertedBy = insertedBy;
        this.insertedOn = insertedOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.status = status;
    }

    public Integer getIdBloodType() {
        return idBloodType;
    }

    public void setIdBloodType(Integer idBloodType) {
        this.idBloodType = idBloodType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @XmlTransient
    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBloodType != null ? idBloodType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BloodType)) {
            return false;
        }
        BloodType other = (BloodType) object;
        if ((this.idBloodType == null && other.idBloodType != null) || (this.idBloodType != null && !this.idBloodType.equals(other.idBloodType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.BloodType[ idBloodType=" + idBloodType + " ]";
    }
    
}
