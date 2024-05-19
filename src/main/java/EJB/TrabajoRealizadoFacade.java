/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.TrabajoRealizado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jose Maria
 */
@Stateless
public class TrabajoRealizadoFacade extends AbstractFacade<TrabajoRealizado> implements TrabajoRealizadoFacadeLocal {

    @PersistenceContext(unitName = "GestionEmpresarialGE")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajoRealizadoFacade() {
        super(TrabajoRealizado.class);
    }
    
}
