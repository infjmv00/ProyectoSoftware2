/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.Sueldo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jose Maria
 */
@Stateless
public class SueldoFacade extends AbstractFacade<Sueldo> implements SueldoFacadeLocal {

    @PersistenceContext(unitName = "GestionEmpresarialGE")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public float calcularNomina(Sueldo sueldo){
        
        float bruto= sueldo.getEnbruto();
        float gastosIrpf = sueldo.getGastosirpf();
        float seguridadsocial = sueldo.getSeguridad_Social();
        float primas = sueldo.getPrimas();
        float neto = bruto - (bruto*gastosIrpf)-(bruto*seguridadsocial)+primas;
        return neto;
    }

    public SueldoFacade() {
        super(Sueldo.class);
    }
    
}
