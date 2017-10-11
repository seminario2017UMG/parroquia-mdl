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
@Table(name = "PHONE_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhoneType.findAll", query = "SELECT p FROM PhoneType p")
    , @NamedQuery(name = "PhoneType.findByIdPhoneType", query = "SELECT p FROM PhoneType p WHERE p.idPhoneType = :idPhoneType")
    , @NamedQuery(name = "PhoneType.findByDescription", query = "SELECT p FROM PhoneType p WHERE p.description = :description")
    , @NamedQuery(name = "PhoneType.findByInsertedBy", query = "SELECT p FROM PhoneType p WHERE p.insertedBy = :insertedBy")
    , @NamedQuery(name = "PhoneType.findByInsertedOn", query = "SELECT p FROM PhoneType p WHERE p.insertedOn = :insertedOn")
    , @NamedQuery(name = "PhoneType.findByUpdatedBy", query = "SELECT p FROM PhoneType p WHERE p.updatedBy = :updatedBy")
    , @NamedQuery(name = "PhoneType.findByUpdatedOn", query = "SELECT p FROM PhoneType p WHERE p.updatedOn = :updatedOn")
    , @NamedQuery(name = "PhoneType.findByStatus", query = "SELECT p FROM PhoneType p WHERE p.status = :status")})
public class PhoneType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PHONE_TYPE")
    private Integer idPhoneType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPhoneType")
    private List<Phone> phoneList;

    public PhoneType() {
    }

    public PhoneType(Integer idPhoneType) {
        this.idPhoneType = idPhoneType;
    }

    public PhoneType(Integer idPhoneType, String description, int insertedBy, Date insertedOn, int updatedBy, Date updatedOn, boolean status) {
        this.idPhoneType = idPhoneType;
        this.description = description;
        this.insertedBy = insertedBy;
        this.insertedOn = insertedOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.status = status;
    }

    public Integer getIdPhoneType() {
        return idPhoneType;
    }

    public void setIdPhoneType(Integer idPhoneType) {
        this.idPhoneType = idPhoneType;
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
    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPhoneType != null ? idPhoneType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhoneType)) {
            return false;
        }
        PhoneType other = (PhoneType) object;
        if ((this.idPhoneType == null && other.idPhoneType != null) || (this.idPhoneType != null && !this.idPhoneType.equals(other.idPhoneType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.PhoneType[ idPhoneType=" + idPhoneType + " ]";
    }
    
}
