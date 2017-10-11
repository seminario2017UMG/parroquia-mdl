/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.mdl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "PERMISSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")
    , @NamedQuery(name = "Permission.findByIdPermission", query = "SELECT p FROM Permission p WHERE p.permissionPK.idPermission = :idPermission")
    , @NamedQuery(name = "Permission.findByIdAction", query = "SELECT p FROM Permission p WHERE p.permissionPK.idAction = :idAction")
    , @NamedQuery(name = "Permission.findByIdResource", query = "SELECT p FROM Permission p WHERE p.permissionPK.idResource = :idResource")
    , @NamedQuery(name = "Permission.findByDescription", query = "SELECT p FROM Permission p WHERE p.description = :description")})
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermissionPK permissionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinTable(name = "ROLE_HAS_PERMISSION", joinColumns = {
        @JoinColumn(name = "ID_PERMISSION", referencedColumnName = "ID_PERMISSION")
        , @JoinColumn(name = "ID_ACTION", referencedColumnName = "ID_ACTION")
        , @JoinColumn(name = "ID_RESOURCE", referencedColumnName = "ID_RESOURCE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")})
    @ManyToMany
    private List<Role> roleList;
    @JoinColumn(name = "ID_ACTION", referencedColumnName = "ID_ACTION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Action action;
    @JoinColumn(name = "ID_RESOURCE", referencedColumnName = "ID_RESOURCE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resource resource;

    public Permission() {
    }

    public Permission(PermissionPK permissionPK) {
        this.permissionPK = permissionPK;
    }

    public Permission(PermissionPK permissionPK, String description) {
        this.permissionPK = permissionPK;
        this.description = description;
    }

    public Permission(int idPermission, int idAction, int idResource) {
        this.permissionPK = new PermissionPK(idPermission, idAction, idResource);
    }

    public PermissionPK getPermissionPK() {
        return permissionPK;
    }

    public void setPermissionPK(PermissionPK permissionPK) {
        this.permissionPK = permissionPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissionPK != null ? permissionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.permissionPK == null && other.permissionPK != null) || (this.permissionPK != null && !this.permissionPK.equals(other.permissionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.Permission[ permissionPK=" + permissionPK + " ]";
    }
    
}
