/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.FacturaFacadeLocal;
import Model.Factura;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Jose Maria
 */
@Named
@RequestScoped
public class ModificarFacturaController implements Serializable{
     @Inject
    private Factura factura;

    private List<Factura> listaFactura;

    @EJB
    private FacturaFacadeLocal facturaEJB;
    
    @PostConstruct
    public void init() {
        try {
            listaFactura = facturaEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inicialización", e.getMessage()));
            e.printStackTrace();
        }
    }

public void onRowEdit(RowEditEvent<Factura> event) {
        FacesMessage msg = new FacesMessage("Pedido Editado", String.valueOf(event.getObject().getN_factura()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        factura = event.getObject();
        facturaEJB.edit(factura);
    }

    public void onRowCancel(RowEditEvent<Factura> event) {
        FacesMessage msg = new FacesMessage("Edición Cancelada con Id", String.valueOf(event.getObject().getN_factura()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public FacturaFacadeLocal getFacturaEJB() {
        return facturaEJB;
    }

    public void setFacturaEJB(FacturaFacadeLocal facturaEJB) {
        this.facturaEJB = facturaEJB;
    }
    
    

}
