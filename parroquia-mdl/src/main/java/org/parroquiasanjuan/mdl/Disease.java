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
@Table(name = "DISEASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disease.findAll", query = "SELECT d FROM Disease d")
    , @NamedQuery(name = "Disease.findByIdDisease", query = "SELECT d FROM Disease d WHERE d.idDisease = :idDisease")
    , @NamedQuery(name = "Disease.findByDescription", query = "SELECT d FROM Disease d WHERE d.description = :description")})
public class Disease implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DISEASE")
    private Integer idDisease;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESCRIPTION")
    private String description;

    public Disease() {
    }

    public Disease(Integer idDisease) {
        this.idDisease = idDisease;
    }

    public Disease(Integer idDisease, String description) {
        this.idDisease = idDisease;
        this.description = description;
    }

    public Integer getIdDisease() {
        return idDisease;
    }

    public void setIdDisease(Integer idDisease) {
        this.idDisease = idDisease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisease != null ? idDisease.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disease)) {
            return false;
        }
        Disease other = (Disease) object;
        if ((this.idDisease == null && other.idDisease != null) || (this.idDisease != null && !this.idDisease.equals(other.idDisease))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.Disease[ idDisease=" + idDisease + " ]";
    }
    
}
