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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lveliz
 */
@Entity
@Table(name = "ACTIVITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a")
    , @NamedQuery(name = "Activity.findByIdActivity", query = "SELECT a FROM Activity a WHERE a.idActivity = :idActivity")
    , @NamedQuery(name = "Activity.findByInsertedBy", query = "SELECT a FROM Activity a WHERE a.insertedBy = :insertedBy")
    , @NamedQuery(name = "Activity.findByInsertedOn", query = "SELECT a FROM Activity a WHERE a.insertedOn = :insertedOn")
    , @NamedQuery(name = "Activity.findByUpdatedBy", query = "SELECT a FROM Activity a WHERE a.updatedBy = :updatedBy")
    , @NamedQuery(name = "Activity.findByUpdatedOn", query = "SELECT a FROM Activity a WHERE a.updatedOn = :updatedOn")
    , @NamedQuery(name = "Activity.findByStatus", query = "SELECT a FROM Activity a WHERE a.status = :status")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ACTIVITY")
    private Integer idActivity;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActivity")
    private List<Permission> permissionList;
    @JoinColumn(name = "ID_ACTION", referencedColumnName = "ID_ACTION")
    @ManyToOne(optional = false)
    private Action idAction;
    @JoinColumn(name = "ID_RESOURCE", referencedColumnName = "ID_RESOURCE")
    @ManyToOne(optional = false)
    private Resource idResource;

    public Activity() {
    }

    public Activity(Integer idActivity) {
        this.idActivity = idActivity;
    }

    public Activity(Integer idActivity, int insertedBy, Date insertedOn, int updatedBy, Date updatedOn, boolean status) {
        this.idActivity = idActivity;
        this.insertedBy = insertedBy;
        this.insertedOn = insertedOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.status = status;
    }

    public Integer getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(Integer idActivity) {
        this.idActivity = idActivity;
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
    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public Action getIdAction() {
        return idAction;
    }

    public void setIdAction(Action idAction) {
        this.idAction = idAction;
    }

    public Resource getIdResource() {
        return idResource;
    }

    public void setIdResource(Resource idResource) {
        this.idResource = idResource;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivity != null ? idActivity.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.idActivity == null && other.idActivity != null) || (this.idActivity != null && !this.idActivity.equals(other.idActivity))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.Activity[ idActivity=" + idActivity + " ]";
    }
    
}
