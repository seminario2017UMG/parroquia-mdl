/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.facade;

import java.util.List;
import javax.ejb.Local;
import org.parroquiasanjuan.mdl.MaritalStatus;

/**
 *
 * @author lveliz
 */
@Local
public interface MaritalStatusFacadeLocal {

    void create(MaritalStatus maritalStatus);

    void edit(MaritalStatus maritalStatus);

    void remove(MaritalStatus maritalStatus);

    MaritalStatus find(Object id);

    List<MaritalStatus> findAll();

    List<MaritalStatus> findRange(int[] range);

    int count();
    
}