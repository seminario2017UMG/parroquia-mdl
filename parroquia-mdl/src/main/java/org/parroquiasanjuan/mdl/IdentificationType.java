/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.mdl;

import java.io.Serializable;
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
    , @NamedQuery(name = "IdentificationType.findByDescription", query = "SELECT i FROM IdentificationType i WHERE i.description = :description")})
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIdentificationType")
    private List<Person> personList;

    public IdentificationType() {
    }

    public IdentificationType(Integer idIdentificationType) {
        this.idIdentificationType = idIdentificationType;
    }

    public IdentificationType(Integer idIdentificationType, String description) {
        this.idIdentificationType = idIdentificationType;
        this.description = description;
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
