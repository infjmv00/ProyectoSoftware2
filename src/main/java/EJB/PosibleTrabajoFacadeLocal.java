/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.PosibleTrabajo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jose Maria
 */
@Local
public interface PosibleTrabajoFacadeLocal {

    void create(PosibleTrabajo posibleTrabajo);

    void edit(PosibleTrabajo posibleTrabajo);

    void remove(PosibleTrabajo posibleTrabajo);

    PosibleTrabajo find(Object id);

    List<PosibleTrabajo> findAll();

    List<PosibleTrabajo> findRange(int[] range);

    int count();
    
}
