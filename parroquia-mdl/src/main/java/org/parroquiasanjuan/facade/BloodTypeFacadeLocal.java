/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.facade;

import java.util.List;
import javax.ejb.Local;
import org.parroquiasanjuan.mdl.BloodType;

/**
 *
 * @author lveliz
 */
@Local
public interface BloodTypeFacadeLocal {

    void create(BloodType bloodType);

    void edit(BloodType bloodType);

    void remove(BloodType bloodType);

    BloodType find(Object id);

    List<BloodType> findAll();

    List<BloodType> findRange(int[] range);

    int count();
    
}
