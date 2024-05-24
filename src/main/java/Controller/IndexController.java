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
    
    public String IniciarSesion(){
        
        String redireccion = null;
        
        
        
        try{
              trabajadorEJB.iniciarSesion(trabajador);
              redireccion ="/protegido/principal";
            
        }catch(Exception e){
            // mensaje de JSF
        }
        
         return redireccion;
    }
    
}
