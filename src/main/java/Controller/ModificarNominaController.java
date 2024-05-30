/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.SueldoFacadeLocal;
import Model.Sueldo;
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
public class ModificarNominaController implements Serializable {
    
    @Inject
    private Sueldo sueldo;

    private List<Sueldo> listaSueldo;

    @EJB
    private SueldoFacadeLocal sueldoEJB;
    
    @PostConstruct
    public void init() {
        try {
            listaSueldo = sueldoEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inicialización", e.getMessage()));
            e.printStackTrace();
        }
    }

public void onRowEdit(RowEditEvent<Sueldo> event) {
        FacesMessage msg = new FacesMessage("Pedido Editado", String.valueOf(event.getObject().getIdSueldo()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        sueldo = event.getObject();
        sueldoEJB.edit(sueldo);
    }

    public void onRowCancel(RowEditEvent<Sueldo> event) {
        FacesMessage msg = new FacesMessage("Edición Cancelada con Id", String.valueOf(event.getObject().getIdSueldo()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Sueldo getSueldo() {
        return sueldo;
    }

    public void setSueldo(Sueldo sueldo) {
        this.sueldo = sueldo;
    }

    public List<Sueldo> getListaSueldo() {
        return listaSueldo;
    }

    public void setListaSueldo(List<Sueldo> listaSueldo) {
        this.listaSueldo = listaSueldo;
    }

    public SueldoFacadeLocal getSueldoEJB() {
        return sueldoEJB;
    }

    public void setSueldoEJB(SueldoFacadeLocal sueldoEJB) {
        this.sueldoEJB = sueldoEJB;
    }
    
}
