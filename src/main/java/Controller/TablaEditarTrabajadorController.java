/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TrabajadorFacadeLocal;
import Model.Trabajador;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import static org.primefaces.behavior.validate.ClientValidator.PropertyKeys.event;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Jose Maria
 */

@Named
@RequestScoped
public class TablaEditarTrabajadorController implements Serializable {
    
    @Inject 
    private Trabajador trabajador;
    
    private List<Trabajador> listaTrabajadores;
    
    @EJB
    TrabajadorFacadeLocal trabajadorEJB;
    
    @PostConstruct
    
    public void init(){
        ´
        listaTrabajadores = trabajadorEJB.findAll();
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public List<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public TrabajadorFacadeLocal getTrabajadorEJB() {
        return trabajadorEJB;
    }

    public void setTrabajadorEJB(TrabajadorFacadeLocal trabajadorEJB) {
        this.trabajadorEJB = trabajadorEJB;
    }
    
    public void onRowEdit(RowEditEvent<Trabajador> event) {
        FacesMessage msg = new FacesMessage("Trabajador Edited", String.valueOf(event.getObject().getIdTrabajador()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        trabajador = event.getObject();
        trabajadorEJB.edit(trabajador);
    }
    
    
    
}
