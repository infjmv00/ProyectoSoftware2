/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TrabajadorFacade;
import EJB.TrabajadorFacadeLocal;
import Model.Trabajador;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jose Maria
 */

@Named
@ViewScoped
public class LoginController implements Serializable {
    
    
    private Trabajador trabajador;
    
    @EJB
    private TrabajadorFacadeLocal trabajadorEJB;
    
    @PostConstruct
    public void init (){
        
        trabajador = new Trabajador();
        
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    public String iniciarSesion(){
        Trabajador trab; 
        String redireccion = null ;
        try{
            trab = trabajadorEJB.iniciarSesion(trabajador);
            if(trab!=null){
                redireccion ="/protegido/principal";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "aviso", "Credenciales incorrectas"));
            }
            
            
            
        } catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "aviso", "error"));
        }
        return redireccion;
    }
    
}
