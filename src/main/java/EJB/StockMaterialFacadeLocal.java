/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.StockMaterial;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jose Maria
 */
@Local
public interface StockMaterialFacadeLocal {

    void create(StockMaterial stockMaterial);

    void edit(StockMaterial stockMaterial);

    void remove(StockMaterial stockMaterial);

    StockMaterial find(Object id);

    List<StockMaterial> findAll();

    List<StockMaterial> findRange(int[] range);

    int count();
    
}
