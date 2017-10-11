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
public class VisitPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_VISIT")
    private int idVisit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_APPOINTMENT")
    private int idAppointment;

    public VisitPK() {
    }

    public VisitPK(int idVisit, int idAppointment) {
        this.idVisit = idVisit;
        this.idAppointment = idAppointment;
    }

    public int getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(int idVisit) {
        this.idVisit = idVisit;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVisit;
        hash += (int) idAppointment;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitPK)) {
            return false;
        }
        VisitPK other = (VisitPK) object;
        if (this.idVisit != other.idVisit) {
            return false;
        }
        if (this.idAppointment != other.idAppointment) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.VisitPK[ idVisit=" + idVisit + ", idAppointment=" + idAppointment + " ]";
    }
    
}
