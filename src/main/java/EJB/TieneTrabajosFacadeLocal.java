/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.TieneTrabajos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jose Maria
 */
@Local
public interface TieneTrabajosFacadeLocal {

    void create(TieneTrabajos tieneTrabajos);

    void edit(TieneTrabajos tieneTrabajos);

    void remove(TieneTrabajos tieneTrabajos);

    TieneTrabajos find(Object id);

    List<TieneTrabajos> findAll();

    List<TieneTrabajos> findRange(int[] range);

    int count();
    
}
