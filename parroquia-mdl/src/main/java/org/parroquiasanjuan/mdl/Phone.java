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
    , @NamedQuery(name = "Phone.findByPhoneNumber", query = "SELECT p FROM Phone p WHERE p.phoneNumber = :phoneNumber")})
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

    public Phone(Integer idPhone, String phoneNumber) {
        this.idPhone = idPhone;
        this.phoneNumber = phoneNumber;
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
