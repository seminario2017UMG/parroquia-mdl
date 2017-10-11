/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.parroquiasanjuan.mdl.Action;

/**
 *
 * @author lveliz
 */
@Stateless
public class ActionFacade extends AbstractFacade<Action> implements ActionFacadeLocal {

    @PersistenceContext(unitName = "org.parroquiasanjuan_parroquia-web_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActionFacade() {
        super(Action.class);
    }
    
}
