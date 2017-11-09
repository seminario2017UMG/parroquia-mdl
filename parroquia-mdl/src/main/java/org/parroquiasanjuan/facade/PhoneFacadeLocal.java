/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.facade;

import java.util.List;
import javax.ejb.Local;
import org.parroquiasanjuan.mdl.Phone;

/**
 *
 * @author lveliz
 */
@Local
public interface PhoneFacadeLocal {

    void create(Phone phone);

    void edit(Phone phone);

    void remove(Phone phone);

    Phone find(Object id);

    List<Phone> findAll();

    List<Phone> findRange(int[] range);

    int count();
    
}
