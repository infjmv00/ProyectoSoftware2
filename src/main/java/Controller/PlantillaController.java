/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Trabajador;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jose Maria
 */
@Named
@ViewScoped
public class PlantillaController implements Serializable {
    
    public void verificarSesion(){
        
        try{
           FacesContext context =  FacesContext.getCurrentInstance();
                   
           Trabajador trab =  (Trabajador) context.getExternalContext().getSessionMap().get("trabajador");
           
           if(trab==null){
               context.getExternalContext().redirect("./../permisos.xhtml");
           }
        }catch(Exception e){
            // log para error
        }
    }
}
