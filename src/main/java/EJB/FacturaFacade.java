/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.Factura;
import Model.Factura;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jose Maria
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> implements FacturaFacadeLocal {

    @PersistenceContext(unitName = "GestionEmpresarialGE")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }
    
    @Override
    public float calcularTotalBrutoFactura(Factura factura){
     
        int unidades = factura.getCantidad();
        float precio_unitario = factura.getPrecio_unitario();
        float bruto_factura = unidades*precio_unitario;
        return bruto_factura;
    }
    
    //total con iva
    @Override
    public float calcularTotalFactura(Factura factura){
     
        float total = (this.calcularTotalBrutoFactura(factura)*factura.getIva_aplicado())+this.calcularTotalBrutoFactura(factura);
        return total;
    }
    
}
