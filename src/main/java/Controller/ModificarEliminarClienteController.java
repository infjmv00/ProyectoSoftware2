/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.ClienteFacadeLocal;
import Model.Cliente;
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
public class ModificarEliminarClienteController implements Serializable {
    
    
    @Inject
    private Cliente cliente;

    private List<Cliente> listaClientes;

    @EJB
    private ClienteFacadeLocal clienteEJB;

    @PostConstruct
    public void init() {
        try {
            listaClientes = clienteEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inicialización", e.getMessage()));
            e.printStackTrace();
        }
    }

    
    public void onRowEdit(RowEditEvent<Cliente> event) {
        FacesMessage msg = new FacesMessage("Cliente Editado", String.valueOf(event.getObject().getId_Cliente()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        cliente = event.getObject();
        clienteEJB.edit(cliente);
    }

    public void onRowCancel(RowEditEvent<Cliente> event) {
        FacesMessage msg = new FacesMessage("Edición Cancelada con Id", String.valueOf(event.getObject().getId_Cliente()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
   
    public void eliminar(Cliente cliente){
        FacesMessage msg = new FacesMessage("Trabajador Eliminado", String.valueOf(cliente.getId_Cliente()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        cliente.setActivocli(false);
        clienteEJB.edit(cliente);
        
       
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ClienteFacadeLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClienteFacadeLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }
    
    
    
}
