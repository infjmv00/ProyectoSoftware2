/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.MaterialUsado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jose Maria
 */
@Local
public interface MaterialUsadoFacadeLocal {

    void create(MaterialUsado materialUsado);

    void edit(MaterialUsado materialUsado);

    void remove(MaterialUsado materialUsado);

    MaterialUsado find(Object id);

    List<MaterialUsado> findAll();

    List<MaterialUsado> findRange(int[] range);

    int count();
    
}
