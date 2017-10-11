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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TOWN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Town.findAll", query = "SELECT t FROM Town t")
    , @NamedQuery(name = "Town.findByIdTown", query = "SELECT t FROM Town t WHERE t.townPK.idTown = :idTown")
    , @NamedQuery(name = "Town.findByIdState", query = "SELECT t FROM Town t WHERE t.townPK.idState = :idState")
    , @NamedQuery(name = "Town.findByDescription", query = "SELECT t FROM Town t WHERE t.description = :description")
    , @NamedQuery(name = "Town.findByInsertedBy", query = "SELECT t FROM Town t WHERE t.insertedBy = :insertedBy")
    , @NamedQuery(name = "Town.findByInsertedOn", query = "SELECT t FROM Town t WHERE t.insertedOn = :insertedOn")
    , @NamedQuery(name = "Town.findByUpdatedBy", query = "SELECT t FROM Town t WHERE t.updatedBy = :updatedBy")
    , @NamedQuery(name = "Town.findByUpdatedOn", query = "SELECT t FROM Town t WHERE t.updatedOn = :updatedOn")
    , @NamedQuery(name = "Town.findByStatus", query = "SELECT t FROM Town t WHERE t.status = :status")})
public class Town implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TownPK townPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
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
    @JoinColumn(name = "ID_STATE", referencedColumnName = "ID_STATE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private State state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "town")
    private List<Address> addressList;

    public Town() {
    }

    public Town(TownPK townPK) {
        this.townPK = townPK;
    }

    public Town(TownPK townPK, String description, int insertedBy, Date insertedOn, int updatedBy, Date updatedOn, boolean status) {
        this.townPK = townPK;
        this.description = description;
        this.insertedBy = insertedBy;
        this.insertedOn = insertedOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.status = status;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
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
