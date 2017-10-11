/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.facade;

import java.util.List;
import javax.ejb.Local;
import org.parroquiasanjuan.mdl.Town;

/**
 *
 * @author lveliz
 */
@Local
public interface TownFacadeLocal {

    void create(Town town);

    void edit(Town town);

    void remove(Town town);

    Town find(Object id);

    List<Town> findAll();

    List<Town> findRange(int[] range);

    int count();
    
}
