/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.ProveedorFacadeLocal;
import Model.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jose Maria
 */
@Named
@RequestScoped
public class EliminarProveedorConrroller implements Serializable {
    
    
    @Inject
    private Proveedor proveedor;

    private List<Proveedor> listaProveedores;

    @EJB
    private ProveedorFacadeLocal proveedorEJB;
    
    @PostConstruct
    public void init() {
        try {
            listaProveedores = proveedorEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inicialización", e.getMessage()));
            e.printStackTrace();
        }
    }
    
   public void eliminar(Proveedor proveedor){
        FacesMessage msg = new FacesMessage("Proveedor Eliminada", String.valueOf(proveedor.getIdProveedor()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        proveedor.setActivoprov(false);
        proveedorEJB.edit(proveedor);
       
       
    }
}
