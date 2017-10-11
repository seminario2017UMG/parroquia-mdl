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
@Table(name = "RESOURCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resource.findAll", query = "SELECT r FROM Resource r")
    , @NamedQuery(name = "Resource.findByIdResource", query = "SELECT r FROM Resource r WHERE r.idResource = :idResource")
    , @NamedQuery(name = "Resource.findByDescription", query = "SELECT r FROM Resource r WHERE r.description = :description")
    , @NamedQuery(name = "Resource.findByUrl", query = "SELECT r FROM Resource r WHERE r.url = :url")
    , @NamedQuery(name = "Resource.findByInsertedBy", query = "SELECT r FROM Resource r WHERE r.insertedBy = :insertedBy")
    , @NamedQuery(name = "Resource.findByInsertedOn", query = "SELECT r FROM Resource r WHERE r.insertedOn = :insertedOn")
    , @NamedQuery(name = "Resource.findByUpdatedBy", query = "SELECT r FROM Resource r WHERE r.updatedBy = :updatedBy")
    , @NamedQuery(name = "Resource.findByUpdatedOn", query = "SELECT r FROM Resource r WHERE r.updatedOn = :updatedOn")
    , @NamedQuery(name = "Resource.findByStatus", query = "SELECT r FROM Resource r WHERE r.status = :status")})
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RESOURCE")
    private Integer idResource;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "URL")
    private String url;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResource")
    private List<ResourceAccess> resourceAccessList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResource")
    private List<Activity> activityList;

    public Resource() {
    }

    public Resource(Integer idResource) {
        this.idResource = idResource;
    }

    public Resource(Integer idResource, String description, String url, int insertedBy, Date insertedOn, int updatedBy, Date updatedOn, boolean status) {
        this.idResource = idResource;
        this.description = description;
        this.url = url;
        this.insertedBy = insertedBy;
        this.insertedOn = insertedOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.status = status;
    }

    public Integer getIdResource() {
        return idResource;
    }

    public void setIdResource(Integer idResource) {
        this.idResource = idResource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    public List<ResourceAccess> getResourceAccessList() {
        return resourceAccessList;
    }

    public void setResourceAccessList(List<ResourceAccess> resourceAccessList) {
        this.resourceAccessList = resourceAccessList;
    }

    @XmlTransient
    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResource != null ? idResource.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resource)) {
            return false;
        }
        Resource other = (Resource) object;
        if ((this.idResource == null && other.idResource != null) || (this.idResource != null && !this.idResource.equals(other.idResource))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.Resource[ idResource=" + idResource + " ]";
    }
    
}
