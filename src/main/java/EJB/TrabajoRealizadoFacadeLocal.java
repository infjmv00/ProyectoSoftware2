/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.TrabajoRealizado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jose Maria
 */
@Local
public interface TrabajoRealizadoFacadeLocal {

    void create(TrabajoRealizado trabajoRealizado);

    void edit(TrabajoRealizado trabajoRealizado);

    void remove(TrabajoRealizado trabajoRealizado);

    TrabajoRealizado find(Object id);

    List<TrabajoRealizado> findAll();

    List<TrabajoRealizado> findRange(int[] range);

    int count();
    
}
