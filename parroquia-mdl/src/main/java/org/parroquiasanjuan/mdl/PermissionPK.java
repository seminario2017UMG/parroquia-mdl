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
public class PermissionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_PERMISSION")
    private int idPermission;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ACTION")
    private int idAction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RESOURCE")
    private int idResource;

    public PermissionPK() {
    }

    public PermissionPK(int idPermission, int idAction, int idResource) {
        this.idPermission = idPermission;
        this.idAction = idAction;
        this.idResource = idResource;
    }

    public int getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(int idPermission) {
        this.idPermission = idPermission;
    }

    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }

    public int getIdResource() {
        return idResource;
    }

    public void setIdResource(int idResource) {
        this.idResource = idResource;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPermission;
        hash += (int) idAction;
        hash += (int) idResource;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermissionPK)) {
            return false;
        }
        PermissionPK other = (PermissionPK) object;
        if (this.idPermission != other.idPermission) {
            return false;
        }
        if (this.idAction != other.idAction) {
            return false;
        }
        if (this.idResource != other.idResource) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.PermissionPK[ idPermission=" + idPermission + ", idAction=" + idAction + ", idResource=" + idResource + " ]";
    }
    
}
