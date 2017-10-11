/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.facade;

import java.util.List;
import javax.ejb.Local;
import org.parroquiasanjuan.mdl.PhoneType;

/**
 *
 * @author lveliz
 */
@Local
public interface PhoneTypeFacadeLocal {

    void create(PhoneType phoneType);

    void edit(PhoneType phoneType);

    void remove(PhoneType phoneType);

    PhoneType find(Object id);

    List<PhoneType> findAll();

    List<PhoneType> findRange(int[] range);

    int count();
    
}
