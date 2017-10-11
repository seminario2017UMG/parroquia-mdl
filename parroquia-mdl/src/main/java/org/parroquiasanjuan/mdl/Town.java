/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.mdl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "TOWN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Town.findAll", query = "SELECT t FROM Town t")
    , @NamedQuery(name = "Town.findByIdTown", query = "SELECT t FROM Town t WHERE t.townPK.idTown = :idTown")
    , @NamedQuery(name = "Town.findByIdState", query = "SELECT t FROM Town t WHERE t.townPK.idState = :idState")
    , @NamedQuery(name = "Town.findByDescription", query = "SELECT t FROM Town t WHERE t.description = :description")})
public class Town implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TownPK townPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "ID_STATE", referencedColumnName = "ID_STATE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private State state;

    public Town() {
    }

    public Town(TownPK townPK) {
        this.townPK = townPK;
    }

    public Town(TownPK townPK, String description) {
        this.townPK = townPK;
        this.description = description;
    }

    public Town(int idTown, int idState) {
        this.townPK = new TownPK(idTown, idState);
    }

    public TownPK getTownPK() {
        return townPK;
    }

    public void setTownPK(TownPK townPK) {
        this.townPK = townPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (townPK != null ? townPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Town)) {
            return false;
        }
        Town other = (Town) object;
        if ((this.townPK == null && other.townPK != null) || (this.townPK != null && !this.townPK.equals(other.townPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.Town[ townPK=" + townPK + " ]";
    }
    
}
