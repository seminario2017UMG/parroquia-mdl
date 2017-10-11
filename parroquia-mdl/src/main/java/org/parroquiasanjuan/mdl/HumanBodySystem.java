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
@Table(name = "HUMAN_BODY_SYSTEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HumanBodySystem.findAll", query = "SELECT h FROM HumanBodySystem h")
    , @NamedQuery(name = "HumanBodySystem.findByIdHumanBodySystem", query = "SELECT h FROM HumanBodySystem h WHERE h.idHumanBodySystem = :idHumanBodySystem")
    , @NamedQuery(name = "HumanBodySystem.findByDescription", query = "SELECT h FROM HumanBodySystem h WHERE h.description = :description")})
public class HumanBodySystem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_HUMAN_BODY_SYSTEM")
    private Integer idHumanBodySystem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESCRIPTION")
    private String description;

    public HumanBodySystem() {
    }

    public HumanBodySystem(Integer idHumanBodySystem) {
        this.idHumanBodySystem = idHumanBodySystem;
    }

    public HumanBodySystem(Integer idHumanBodySystem, String description) {
        this.idHumanBodySystem = idHumanBodySystem;
        this.description = description;
    }

    public Integer getIdHumanBodySystem() {
        return idHumanBodySystem;
    }

    public void setIdHumanBodySystem(Integer idHumanBodySystem) {
        this.idHumanBodySystem = idHumanBodySystem;
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
        hash += (idHumanBodySystem != null ? idHumanBodySystem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HumanBodySystem)) {
            return false;
        }
        HumanBodySystem other = (HumanBodySystem) object;
        if ((this.idHumanBodySystem == null && other.idHumanBodySystem != null) || (this.idHumanBodySystem != null && !this.idHumanBodySystem.equals(other.idHumanBodySystem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.HumanBodySystem[ idHumanBodySystem=" + idHumanBodySystem + " ]";
    }
    
}
