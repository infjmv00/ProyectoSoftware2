/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.ClienteFacadeLocal;
import EJB.MaterialFacadeLocal;
import EJB.PresupuestoFacadeLocal;
import Model.Cliente;
import Model.Material;
import Model.Presupuesto;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jose Maria
 */
@Named
@ViewScoped
public class AltaPresupuestoController implements Serializable {
    
    @Inject
    private Presupuesto presupuesto;
    
    @Inject
    private Cliente cliente;
    
    @Inject
    private Material material;
    
    @EJB
    private PresupuestoFacadeLocal presupuestoEJB;
    
    @EJB
    private ClienteFacadeLocal clienteEJB;
    
    @EJB
    private MaterialFacadeLocal materialEJB;
    
     private List<Cliente>listaClientes;
     
     private List<Material>listaMateriales;
     
     @PostConstruct
     
     public void init(){
         presupuesto = new Presupuesto();
         cliente = new Cliente();
         material = new Material();
         listaClientes = clienteEJB.findAll();
         listaMateriales = materialEJB.findAll();
     }
     
     
     public void insertarPresupuesto(){
         
         try{
             presupuesto.setMaterial(material);
             presupuesto.setCliente(cliente);
             presupuesto.setTotal_bruto(presupuestoEJB.calcularTotalBrutoPresupuesto(presupuesto));
             presupuesto.setTotal(presupuestoEJB.calcularTotalPresupuesto(presupuesto));
             presupuestoEJB.create(presupuesto);
             System.out.println("Presupuesto  creado correctamente con id: "+presupuesto.getN_presupuesto());
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Pedido creado correctamente "+presupuesto.getN_presupuesto()));
         } catch(Exception e){
             System.out.println("Error al insertar el presupuesto: "+e.getMessage());
         }
     }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public PresupuestoFacadeLocal getPresupuestoEJB() {
        return presupuestoEJB;
    }

    public void setPresupuestoEJB(PresupuestoFacadeLocal presupuestoEJB) {
        this.presupuestoEJB = presupuestoEJB;
    }

    public ClienteFacadeLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClienteFacadeLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }

    public MaterialFacadeLocal getMaterialEJB() {
        return materialEJB;
    }

    public void setMaterialEJB(MaterialFacadeLocal materialEJB) {
        this.materialEJB = materialEJB;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Material> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(List<Material> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.presupuesto);
        hash = 37 * hash + Objects.hashCode(this.cliente);
        hash = 37 * hash + Objects.hashCode(this.material);
        hash = 37 * hash + Objects.hashCode(this.presupuestoEJB);
        hash = 37 * hash + Objects.hashCode(this.clienteEJB);
        hash = 37 * hash + Objects.hashCode(this.materialEJB);
        hash = 37 * hash + Objects.hashCode(this.listaClientes);
        hash = 37 * hash + Objects.hashCode(this.listaMateriales);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AltaPresupuestoController other = (AltaPresupuestoController) obj;
        if (!Objects.equals(this.presupuesto, other.presupuesto)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.presupuestoEJB, other.presupuestoEJB)) {
            return false;
        }
        if (!Objects.equals(this.clienteEJB, other.clienteEJB)) {
            return false;
        }
        if (!Objects.equals(this.materialEJB, other.materialEJB)) {
            return false;
        }
        if (!Objects.equals(this.listaClientes, other.listaClientes)) {
            return false;
        }
        if (!Objects.equals(this.listaMateriales, other.listaMateriales)) {
            return false;
        }
        return true;
    }

    
    
}





