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
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Jose Maria
 */
@Named
@RequestScoped
public class ModificarProveedorController implements Serializable {
    
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

public void onRowEdit(RowEditEvent<Proveedor> event) {
        FacesMessage msg = new FacesMessage("Pedido Editado", String.valueOf(event.getObject().getIdProveedor()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        proveedor = event.getObject();
        proveedorEJB.edit(proveedor);
    }

    public void onRowCancel(RowEditEvent<Proveedor> event) {
        FacesMessage msg = new FacesMessage("Edición Cancelada con Id", String.valueOf(event.getObject().getIdProveedor()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public ProveedorFacadeLocal getProveedorEJB() {
        return proveedorEJB;
    }

    public void setProveedorEJB(ProveedorFacadeLocal proveedorEJB) {
        this.proveedorEJB = proveedorEJB;
    }
    
    

}
