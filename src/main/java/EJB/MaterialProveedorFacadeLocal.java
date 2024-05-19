/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.MaterialProveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jose Maria
 */
@Local
public interface MaterialProveedorFacadeLocal {

    void create(MaterialProveedor materialProveedor);

    void edit(MaterialProveedor materialProveedor);

    void remove(MaterialProveedor materialProveedor);

    MaterialProveedor find(Object id);

    List<MaterialProveedor> findAll();

    List<MaterialProveedor> findRange(int[] range);

    int count();
    
}
