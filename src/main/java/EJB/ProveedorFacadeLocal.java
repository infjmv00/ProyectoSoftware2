/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.Proveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jose Maria
 */
@Local
public interface ProveedorFacadeLocal {

    void create(Proveedor proveedor);

    void edit(Proveedor proveedor);

    void remove(Proveedor proveedor);

    Proveedor find(Object id);

    List<Proveedor> findAll();

    List<Proveedor> findRange(int[] range);

    int count();
    
}
