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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "PHONE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
    , @NamedQuery(name = "Phone.findByIdPhone", query = "SELECT p FROM Phone p WHERE p.idPhone = :idPhone")
    , @NamedQuery(name = "Phone.findByPhoneNumber", query = "SELECT p FROM Phone p WHERE p.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Phone.findByInsertedBy", query = "SELECT p FROM Phone p WHERE p.insertedBy = :insertedBy")
    , @NamedQuery(name = "Phone.findByInsertedOn", query = "SELECT p FROM Phone p WHERE p.insertedOn = :insertedOn")
    , @NamedQuery(name = "Phone.findByUpdatedBy", query = "SELECT p FROM Phone p WHERE p.updatedBy = :updatedBy")
    , @NamedQuery(name = "Phone.findByUpdatedOn", query = "SELECT p FROM Phone p WHERE p.updatedOn = :updatedOn")
    , @NamedQuery(name = "Phone.findByStatus", query = "SELECT p FROM Phone p WHERE p.status = :status")})
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PHONE")
    private Integer idPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
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
    @JoinColumn(name = "ID_PERSON", referencedColumnName = "ID_PERSON")
    @ManyToOne(optional = false)
    private Person idPerson;
    @JoinColumn(name = "ID_PHONE_TYPE", referencedColumnName = "ID_PHONE_TYPE")
    @ManyToOne(optional = false)
    private PhoneType idPhoneType;

    public Phone() {
    }

    public Phone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public Phone(Integer idPhone, String phoneNumber, int insertedBy, Date insertedOn, int updatedBy, Date updatedOn, boolean status) {
        this.idPhone = idPhone;
        this.phoneNumber = phoneNumber;
        this.insertedBy = insertedBy;
        this.insertedOn = insertedOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.status = status;
    }

    public Integer getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Person getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Person idPerson) {
        this.idPerson = idPerson;
    }

    public PhoneType getIdPhoneType() {
        return idPhoneType;
    }

    public void setIdPhoneType(PhoneType idPhoneType) {
        this.idPhoneType = idPhoneType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPhone != null ? idPhone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.idPhone == null && other.idPhone != null) || (this.idPhone != null && !this.idPhone.equals(other.idPhone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.Phone[ idPhone=" + idPhone + " ]";
    }
    
}
