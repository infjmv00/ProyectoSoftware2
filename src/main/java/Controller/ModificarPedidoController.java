/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.MaterialProveedorFacadeLocal;
import Model.MaterialProveedor;
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
public class ModificarPedidoController implements Serializable {
    
    
    @Inject
    private MaterialProveedor pedido;

    private List<MaterialProveedor> listaPedidos;

    @EJB
    private MaterialProveedorFacadeLocal pedidoEJB;
    
    @PostConstruct
    public void init() {
        try {
            listaPedidos = pedidoEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inicialización", e.getMessage()));
            e.printStackTrace();
        }
    }

public void onRowEdit(RowEditEvent<MaterialProveedor> event) {
        FacesMessage msg = new FacesMessage("Pedido Editado", String.valueOf(event.getObject().getIdPedido()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        pedido = event.getObject();
        pedidoEJB.edit(pedido);
    }

    public void onRowCancel(RowEditEvent<MaterialProveedor> event) {
        FacesMessage msg = new FacesMessage("Edición Cancelada con Id", String.valueOf(event.getObject().getIdPedido()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public MaterialProveedor getPedido() {
        return pedido;
    }

    public void setPedido(MaterialProveedor pedido) {
        this.pedido = pedido;
    }

    public List<MaterialProveedor> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<MaterialProveedor> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public MaterialProveedorFacadeLocal getPedidoEJB() {
        return pedidoEJB;
    }

    public void setPedidoEJB(MaterialProveedorFacadeLocal pedidoEJB) {
        this.pedidoEJB = pedidoEJB;
    }
    
    
}
