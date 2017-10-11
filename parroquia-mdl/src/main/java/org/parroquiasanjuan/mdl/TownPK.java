/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.mdl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lveliz
 */
@Embeddable
public class TownPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_TOWN")
    private int idTown;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_STATE")
    private int idState;

    public TownPK() {
    }

    public TownPK(int idTown, int idState) {
        this.idTown = idTown;
        this.idState = idState;
    }

    public int getIdTown() {
        return idTown;
    }

    public void setIdTown(int idTown) {
        this.idTown = idTown;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTown;
        hash += (int) idState;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TownPK)) {
            return false;
        }
        TownPK other = (TownPK) object;
        if (this.idTown != other.idTown) {
            return false;
        }
        if (this.idState != other.idState) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.TownPK[ idTown=" + idTown + ", idState=" + idState + " ]";
    }
    
}
