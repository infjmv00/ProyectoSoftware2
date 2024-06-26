/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.TrabajoEjecutado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jose Maria
 */
@Local
public interface TrabajoEjecutadoFacadeLocal {

    void create(TrabajoEjecutado trabajoEjecutado);

    void edit(TrabajoEjecutado trabajoEjecutado);

    void remove(TrabajoEjecutado trabajoEjecutado);

    TrabajoEjecutado find(Object id);

    List<TrabajoEjecutado> findAll();

    List<TrabajoEjecutado> findRange(int[] range);

    int count();
    
}
