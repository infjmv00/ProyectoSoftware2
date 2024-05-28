/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.ClienteFacadeLocal;
import EJB.FacturaFacadeLocal;
import EJB.MaterialFacadeLocal;
import Model.Cliente;
import Model.Factura;
import Model.Material;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jose Maria
 * 
 * 
 */

@Named
@ViewScoped
public class AltaFacturaController implements Serializable {
    
    @Inject
    private Factura factura;
    
    @Inject
    private Cliente cliente;
    
    @Inject
    private Material material;
    
    @EJB
    private FacturaFacadeLocal facturaEJB;
    
    @EJB
    private ClienteFacadeLocal clienteEJB;
    
    @EJB
    private MaterialFacadeLocal materialEJB;
    
     private List<Cliente>listaClientes;
     
     private List<Material>listaMateriales;
     
     @PostConstruct
     
     public void init(){
         factura = new Factura();
         cliente = new Cliente();
         material = new Material();
         listaClientes = clienteEJB.findAll();
         listaMateriales = materialEJB.findAll();
     }
     
     public void insertarFactura(){
         
         try{
             factura.setMaterial(material);
             factura.setCliente(cliente);
             
             factura.setTotal_bruto(facturaEJB.calcularTotalBrutoFactura(factura));
             factura.setTotal(facturaEJB.calcularTotalFactura(factura));
             facturaEJB.create(factura);
             System.out.println("Presupuesto  creado correctamente con id: "+factura.getN_factura());
         } catch(Exception e){
             System.out.println("Error al insertar el factura: "+e.getMessage());
         }
     }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
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

    public FacturaFacadeLocal getFacturaEJB() {
        return facturaEJB;
    }

    public void setFacturaEJB(FacturaFacadeLocal facturaEJB) {
        this.facturaEJB = facturaEJB;
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
        hash = 61 * hash + Objects.hashCode(this.factura);
        hash = 61 * hash + Objects.hashCode(this.cliente);
        hash = 61 * hash + Objects.hashCode(this.material);
        hash = 61 * hash + Objects.hashCode(this.facturaEJB);
        hash = 61 * hash + Objects.hashCode(this.clienteEJB);
        hash = 61 * hash + Objects.hashCode(this.materialEJB);
        hash = 61 * hash + Objects.hashCode(this.listaClientes);
        hash = 61 * hash + Objects.hashCode(this.listaMateriales);
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
        final AltaFacturaController other = (AltaFacturaController) obj;
        if (!Objects.equals(this.factura, other.factura)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.facturaEJB, other.facturaEJB)) {
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
