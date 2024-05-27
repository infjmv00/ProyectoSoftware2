/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.Sueldo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jose Maria
 */
@Local
public interface SueldoFacadeLocal {

    void create(Sueldo sueldo);

    void edit(Sueldo sueldo);

    void remove(Sueldo sueldo);

    Sueldo find(Object id);

    List<Sueldo> findAll();

    List<Sueldo> findRange(int[] range);

    int count();
    
   float calcularNomina(Sueldo sueldo);
}
