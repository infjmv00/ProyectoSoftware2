
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class IndexController implements Serializable {
   
    @EJB
    private TrabajadorFacadeLocal trabajadorEJB;
    
    private Trabajador trabajador;
    

    @PostConstruct
    public void init(){
        
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
        String redireccion = null;
       
        try{
              trab = trabajadorEJB.iniciarSesion(trabajador);
              if(trab!=null){
                  //Almaceenar sesion en JSF
                  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("trabajador", trab);
                  redireccion ="/protegido/principal?faces-redirect=true";
              } else {
                  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso ", "Credenciales incorrectas"));
              }
              
            
        }catch(Exception e){
            // mensaje de JSF
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso ", "Error!! "));
        }
        
         return redireccion;
    }
    
}
