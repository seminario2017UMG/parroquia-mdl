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
@Table(name = "IDENTIFICATION_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdentificationType.findAll", query = "SELECT i FROM IdentificationType i")
    , @NamedQuery(name = "IdentificationType.findByIdIdentificationType", query = "SELECT i FROM IdentificationType i WHERE i.idIdentificationType = :idIdentificationType")
    , @NamedQuery(name = "IdentificationType.findByDescription", query = "SELECT i FROM IdentificationType i WHERE i.description = :description")
    , @NamedQuery(name = "IdentificationType.findByInsertedBy", query = "SELECT i FROM IdentificationType i WHERE i.insertedBy = :insertedBy")
    , @NamedQuery(name = "IdentificationType.findByInsertedOn", query = "SELECT i FROM IdentificationType i WHERE i.insertedOn = :insertedOn")
    , @NamedQuery(name = "IdentificationType.findByUpdatedBy", query = "SELECT i FROM IdentificationType i WHERE i.updatedBy = :updatedBy")
    , @NamedQuery(name = "IdentificationType.findByUpdatedOn", query = "SELECT i FROM IdentificationType i WHERE i.updatedOn = :updatedOn")
    , @NamedQuery(name = "IdentificationType.findByStatus", query = "SELECT i FROM IdentificationType i WHERE i.status = :status")})
public class IdentificationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_IDENTIFICATION_TYPE")
    private Integer idIdentificationType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIdentificationType")
    private List<Person> personList;

    public IdentificationType() {
    }

    public IdentificationType(Integer idIdentificationType) {
        this.idIdentificationType = idIdentificationType;
    }

    public IdentificationType(Integer idIdentificationType, String description, int insertedBy, Date insertedOn, int updatedBy, Date updatedOn, boolean status) {
        this.idIdentificationType = idIdentificationType;
        this.description = description;
        this.insertedBy = insertedBy;
        this.insertedOn = insertedOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.status = status;
    }

    public Integer getIdIdentificationType() {
        return idIdentificationType;
    }

    public void setIdIdentificationType(Integer idIdentificationType) {
        this.idIdentificationType = idIdentificationType;
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
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIdentificationType != null ? idIdentificationType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentificationType)) {
            return false;
        }
        IdentificationType other = (IdentificationType) object;
        if ((this.idIdentificationType == null && other.idIdentificationType != null) || (this.idIdentificationType != null && !this.idIdentificationType.equals(other.idIdentificationType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.IdentificationType[ idIdentificationType=" + idIdentificationType + " ]";
    }
    
}
