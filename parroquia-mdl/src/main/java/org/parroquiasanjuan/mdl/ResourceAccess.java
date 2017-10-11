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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lveliz
 */
@Entity
@Table(name = "RESOURCE_ACCESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResourceAccess.findAll", query = "SELECT r FROM ResourceAccess r")
    , @NamedQuery(name = "ResourceAccess.findByIdResourceAccess", query = "SELECT r FROM ResourceAccess r WHERE r.idResourceAccess = :idResourceAccess")
    , @NamedQuery(name = "ResourceAccess.findByInsertedBy", query = "SELECT r FROM ResourceAccess r WHERE r.insertedBy = :insertedBy")
    , @NamedQuery(name = "ResourceAccess.findByInsertedOn", query = "SELECT r FROM ResourceAccess r WHERE r.insertedOn = :insertedOn")
    , @NamedQuery(name = "ResourceAccess.findByUpdatedBy", query = "SELECT r FROM ResourceAccess r WHERE r.updatedBy = :updatedBy")
    , @NamedQuery(name = "ResourceAccess.findByUpdatedOn", query = "SELECT r FROM ResourceAccess r WHERE r.updatedOn = :updatedOn")
    , @NamedQuery(name = "ResourceAccess.findByStatus", query = "SELECT r FROM ResourceAccess r WHERE r.status = :status")})
public class ResourceAccess implements Serializable {

    private static final long serialVersionUID = -7939075324006416499L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RESOURCE_ACCESS")
    private Integer idResourceAccess;
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
    @JoinColumn(name = "ID_RESOURCE", referencedColumnName = "ID_RESOURCE")
    @ManyToOne(optional = false)
    private Resource idResource;
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    @ManyToOne(optional = false)
    private Role idRole;

    public ResourceAccess() {
    }

    public ResourceAccess(Integer idResourceAccess) {
        this.idResourceAccess = idResourceAccess;
    }

    public ResourceAccess(Integer idResourceAccess, int insertedBy, Date insertedOn, int updatedBy, Date updatedOn, boolean status) {
        this.idResourceAccess = idResourceAccess;
        this.insertedBy = insertedBy;
        this.insertedOn = insertedOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.status = status;
    }

    public Integer getIdResourceAccess() {
        return idResourceAccess;
    }

    public void setIdResourceAccess(Integer idResourceAccess) {
        this.idResourceAccess = idResourceAccess;
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

    public Resource getIdResource() {
        return idResource;
    }

    public void setIdResource(Resource idResource) {
        this.idResource = idResource;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResourceAccess != null ? idResourceAccess.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourceAccess)) {
            return false;
        }
        ResourceAccess other = (ResourceAccess) object;
        if ((this.idResourceAccess == null && other.idResourceAccess != null) || (this.idResourceAccess != null && !this.idResourceAccess.equals(other.idResourceAccess))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.ResourceAccess[ idResourceAccess=" + idResourceAccess + " ]";
    }

}
