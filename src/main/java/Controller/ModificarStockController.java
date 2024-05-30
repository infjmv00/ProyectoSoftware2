/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.FacturaFacadeLocal;
import EJB.MaterialProveedorFacadeLocal;
import EJB.StockMaterialFacadeLocal;
import Model.Factura;
import Model.MaterialProveedor;
import Model.StockMaterial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Jose Maria
 */

@Named
@ViewScoped
public class ModificarStockController  implements Serializable{
     @Inject
    private StockMaterial stock;
     
     
    private List<Factura> listaFacturas;
     
    private List<MaterialProveedor> listaPedidos;
     
    private List<StockMaterial> listaSstock;

    @EJB
    private StockMaterialFacadeLocal stockEJB;
    
    @EJB
    private FacturaFacadeLocal facturaEJB;
    
     @EJB
    private MaterialProveedorFacadeLocal pedidoEJB;
    
    
     @PostConstruct
    public void init() {
        try {
            listaPedidos = pedidoEJB.findAll();
            listaSstock = stockEJB.findAll();
            listaFacturas = facturaEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inicialización", e.getMessage()));
            e.printStackTrace();
        }
    }
    
    public void onRowEdit(RowEditEvent<StockMaterial> event) {
        FacesMessage msg = new FacesMessage("Emprea editada", String.valueOf(event.getObject().getIdStock()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        int cantidad_pendiente = 0;
        int cantidad_total =0;
        stock = event.getObject();
        for (int i = 0; i< listaPedidos.size();i++){
            
            if(listaPedidos.get(i).getMaterial().getIdMaterial() == stock.getMaterial().getIdMaterial() && listaPedidos.get(i).isActivo() == true && listaPedidos.get(i).isFinalizado() == false ){
                cantidad_pendiente = cantidad_pendiente + listaPedidos.get(i).getUnidades();
            }
            if(listaPedidos.get(i).getMaterial().getIdMaterial() == stock.getMaterial().getIdMaterial() && listaPedidos.get(i).isActivo() == true && listaPedidos.get(i).isFinalizado() == true ){
                cantidad_total = cantidad_total + listaPedidos.get(i).getUnidades();
            }
            
            //Cantidad_real = total - facturada
        }
        
        int cantidad_facturada = materialFacturado(stock.getMaterial().getIdMaterial());
        System.out.println("Cantidad facturada: "+cantidad_facturada);
        stock.setCantidadPteRecibir(cantidad_pendiente);
        stock.setCantidadTotal(cantidad_total);
        stock.setCantidadReal(cantidad_total - cantidad_facturada);
        
        System.out.println("Cantidad real: "+stock.getCantidadReal());
        
        
        
        
        // Logica para editar en funcion de los pedidos
        
        stockEJB.edit(stock);
    }

    
    private int materialFacturado(int identificador){
         int cantidadFacturada = 0;
         
        if(listaFacturas!=null){
            for (int i = 0; i < listaFacturas.size(); i++){
                
                if (listaFacturas.get(i).getMaterial().getIdMaterial() == identificador){
                    cantidadFacturada = cantidadFacturada + listaFacturas.get(i).getCantidad();
                }
            }
        }
        return cantidadFacturada;
    }
    
    public void onRowCancel(RowEditEvent<StockMaterial> event) {
        FacesMessage msg = new FacesMessage("Edición Cancelada con Id", String.valueOf(event.getObject().getIdStock()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public StockMaterial getStock() {
        return stock;
    }

    public void setStock(StockMaterial stock) {
        this.stock = stock;
    }

    public List<MaterialProveedor> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<MaterialProveedor> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public List<StockMaterial> getListaSstock() {
        return listaSstock;
    }

    public void setListaSstock(List<StockMaterial> listaSstock) {
        this.listaSstock = listaSstock;
    }

    public StockMaterialFacadeLocal getStockEJB() {
        return stockEJB;
    }

    public void setStockEJB(StockMaterialFacadeLocal stockEJB) {
        this.stockEJB = stockEJB;
    }

    public MaterialProveedorFacadeLocal getPedidoEJB() {
        return pedidoEJB;
    }

    public void setPedidoEJB(MaterialProveedorFacadeLocal pedidoEJB) {
        this.pedidoEJB = pedidoEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.stock);
        hash = 79 * hash + Objects.hashCode(this.listaPedidos);
        hash = 79 * hash + Objects.hashCode(this.listaSstock);
        hash = 79 * hash + Objects.hashCode(this.stockEJB);
        hash = 79 * hash + Objects.hashCode(this.pedidoEJB);
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
        final ModificarStockController other = (ModificarStockController) obj;
        if (!Objects.equals(this.stock, other.stock)) {
            return false;
        }
        if (!Objects.equals(this.listaPedidos, other.listaPedidos)) {
            return false;
        }
        if (!Objects.equals(this.listaSstock, other.listaSstock)) {
            return false;
        }
        if (!Objects.equals(this.stockEJB, other.stockEJB)) {
            return false;
        }
        if (!Objects.equals(this.pedidoEJB, other.pedidoEJB)) {
            return false;
        }
        return true;
    }

    
}
