/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.MaterialFacadeLocal;
import EJB.MaterialProveedorFacadeLocal;
import EJB.ProveedorFacadeLocal;
import Model.Material;
import Model.MaterialProveedor;
import Model.Proveedor;
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
public class AltaPedidoController implements Serializable {
    
    @Inject
    private Proveedor proveedor;
    
    @Inject
    private Material material;
    
      @Inject
    private MaterialProveedor pedido;
    @EJB
    private ProveedorFacadeLocal proveedorEJB;
    
    @EJB
    private MaterialFacadeLocal materialEJB;
    
    @EJB
    private MaterialProveedorFacadeLocal pedidoEJB;
    
    private List<Material> listaMateriales;
    private List<Proveedor> listaProveedores;
    
    
    @PostConstruct
    public void init(){
        
        proveedor = new Proveedor();
        material = new Material();
        
        listaMateriales = materialEJB.findAll();
        listaProveedores = proveedorEJB.findAll();
    }
    
    public void insertarPedido(){
        
        
        try{
            
            pedido.setProveedor(proveedor);
            pedido.setMaterial(material);
            pedidoEJB.create(pedido);
            System.out.println("Pedido realizado con exito: "+pedido.getIdPedido());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Pedido creado correctamente "+pedido.getIdPedido()));
            
        } catch(Exception e){
            System.out.println("Error al realizar el pedido: "+e.getMessage());
        }
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public MaterialProveedor getPedido() {
        return pedido;
    }

    public void setPedido(MaterialProveedor pedido) {
        this.pedido = pedido;
    }

    public ProveedorFacadeLocal getProveedorEJB() {
        return proveedorEJB;
    }

    public void setProveedorEJB(ProveedorFacadeLocal proveedorEJB) {
        this.proveedorEJB = proveedorEJB;
    }

    public MaterialFacadeLocal getMaterialEJB() {
        return materialEJB;
    }

    public void setMaterialEJB(MaterialFacadeLocal materialEJB) {
        this.materialEJB = materialEJB;
    }

    public MaterialProveedorFacadeLocal getPedidoEJB() {
        return pedidoEJB;
    }

    public void setPedidoEJB(MaterialProveedorFacadeLocal pedidoEJB) {
        this.pedidoEJB = pedidoEJB;
    }

    public List<Material> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(List<Material> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.proveedor);
        hash = 83 * hash + Objects.hashCode(this.material);
        hash = 83 * hash + Objects.hashCode(this.pedido);
        hash = 83 * hash + Objects.hashCode(this.proveedorEJB);
        hash = 83 * hash + Objects.hashCode(this.materialEJB);
        hash = 83 * hash + Objects.hashCode(this.pedidoEJB);
        hash = 83 * hash + Objects.hashCode(this.listaMateriales);
        hash = 83 * hash + Objects.hashCode(this.listaProveedores);
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
        final AltaPedidoController other = (AltaPedidoController) obj;
        if (!Objects.equals(this.proveedor, other.proveedor)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        if (!Objects.equals(this.proveedorEJB, other.proveedorEJB)) {
            return false;
        }
        if (!Objects.equals(this.materialEJB, other.materialEJB)) {
            return false;
        }
        if (!Objects.equals(this.pedidoEJB, other.pedidoEJB)) {
            return false;
        }
        if (!Objects.equals(this.listaMateriales, other.listaMateriales)) {
            return false;
        }
        if (!Objects.equals(this.listaProveedores, other.listaProveedores)) {
            return false;
        }
        return true;
    }
    
    
    
}
