/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.Presupuesto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jose Maria
 */
@Stateless
public class PresupuestoFacade extends AbstractFacade<Presupuesto> implements PresupuestoFacadeLocal {

    @PersistenceContext(unitName = "GestionEmpresarialGE")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestoFacade() {
        super(Presupuesto.class);
    }
    // total sin iva
    @Override
    public float calcularTotalBrutoPresupuesto(Presupuesto presupuesto){
     
        int unidades = presupuesto.getCantidad();
        float precio_unitario = presupuesto.getPrecio_unitario();
        float bruto_presupuesto = unidades*precio_unitario;
        return bruto_presupuesto;
    }
    
    //total con iva
    @Override
    public float calcularTotalPresupuesto(Presupuesto presupuesto){
     
        float total = (this.calcularTotalBrutoPresupuesto(presupuesto)*presupuesto.getIva_aplicado())+this.calcularTotalBrutoPresupuesto(presupuesto);
        return total;
    }
    
}
