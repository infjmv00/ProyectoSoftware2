/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.PresupuestoFacadeLocal;
import Model.Presupuesto;
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

public class ModificarPresupuestoController implements Serializable{
    
    @Inject
    private Presupuesto presupuesto;

    private List<Presupuesto> listaPresupuesto;

    @EJB
    private PresupuestoFacadeLocal presupuestoEJB;
    
    @PostConstruct
    public void init() {
        try {
            listaPresupuesto = presupuestoEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inicialización", e.getMessage()));
            e.printStackTrace();
        }
    }

public void onRowEdit(RowEditEvent<Presupuesto> event) {
        FacesMessage msg = new FacesMessage("Pedido Editado", String.valueOf(event.getObject().getN_presupuesto()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        presupuesto = event.getObject();
        presupuestoEJB.edit(presupuesto);
    }

    public void onRowCancel(RowEditEvent<Presupuesto> event) {
        FacesMessage msg = new FacesMessage("Edición Cancelada con Id", String.valueOf(event.getObject().getN_presupuesto()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Presupuesto> getListaPresupuesto() {
        return listaPresupuesto;
    }

    public void setListaPresupuesto(List<Presupuesto> listaPresupuesto) {
        this.listaPresupuesto = listaPresupuesto;
    }

    public PresupuestoFacadeLocal getPresupuestoEJB() {
        return presupuestoEJB;
    }

    public void setPresupuestoEJB(PresupuestoFacadeLocal presupuestoEJB) {
        this.presupuestoEJB = presupuestoEJB;
    }
    
    
}
