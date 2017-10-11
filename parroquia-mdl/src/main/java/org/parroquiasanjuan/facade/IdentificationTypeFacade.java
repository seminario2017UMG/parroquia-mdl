/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.parroquiasanjuan.mdl.IdentificationType;

/**
 *
 * @author lveliz
 */
@Stateless
public class IdentificationTypeFacade extends AbstractFacade<IdentificationType> implements IdentificationTypeFacadeLocal {

    @PersistenceContext(unitName = "org.parroquiasanjuan_parroquia-web_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IdentificationTypeFacade() {
        super(IdentificationType.class);
    }
    
}
