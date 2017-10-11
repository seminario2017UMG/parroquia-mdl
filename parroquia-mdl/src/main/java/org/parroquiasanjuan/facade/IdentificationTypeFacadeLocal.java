/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.facade;

import java.util.List;
import javax.ejb.Local;
import org.parroquiasanjuan.mdl.IdentificationType;

/**
 *
 * @author lveliz
 */
@Local
public interface IdentificationTypeFacadeLocal {

    void create(IdentificationType identificationType);

    void edit(IdentificationType identificationType);

    void remove(IdentificationType identificationType);

    IdentificationType find(Object id);

    List<IdentificationType> findAll();

    List<IdentificationType> findRange(int[] range);

    int count();
    
}
