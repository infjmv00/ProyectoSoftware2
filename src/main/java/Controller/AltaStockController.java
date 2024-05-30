/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.MaterialFacadeLocal;
import EJB.MaterialProveedorFacadeLocal;
import EJB.StockMaterialFacadeLocal;
import Model.Material;
import Model.MaterialProveedor;
import Model.StockMaterial;
import java.io.Serializable;
import java.util.List;
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
public class AltaStockController implements Serializable {
    
    
    @Inject
    private Material material;
    
    @Inject
    private StockMaterial stock;
    
    @EJB
    private StockMaterialFacadeLocal stockEJB;
    
    
    private List<MaterialProveedor> listaPedidos;
    
      @EJB
    private MaterialFacadeLocal materialkEJB;
      
      @EJB
    private MaterialProveedorFacadeLocal pedidoEJB;
    
    private List<Material> listaMateriales;
    
    
    @PostConstruct
    public void init(){
        stock = new StockMaterial();
        material = new Material();
        listaMateriales = materialkEJB.findAll();
        listaPedidos = pedidoEJB.findAll();
        
         
        
    }
    
    public void insertarStock(){
        
        // REVISAR
        
 
        
        try{
            
        
           // ;
            stock.setMaterial(material);
            stockEJB.create(stock);
            System.out.println("Stock dado de alta correctamente: "+stock.getIdStock());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Stock creado correctamente "+stock.getIdStock()));
            
        } catch(Exception e){
            System.out.println("Erroe al crear el stock: "+e.getMessage());
        }
//}  
        
        
        
                
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public StockMaterial getStock() {
        return stock;
    }

    public void setStock(StockMaterial stock) {
        this.stock = stock;
    }

    public StockMaterialFacadeLocal getStockEJB() {
        return stockEJB;
    }

    public void setStockEJB(StockMaterialFacadeLocal stockEJB) {
        this.stockEJB = stockEJB;
    }

    public MaterialFacadeLocal getMaterialkEJB() {
        return materialkEJB;
    }

    public void setMaterialkEJB(MaterialFacadeLocal materialkEJB) {
        this.materialkEJB = materialkEJB;
    }

    public List<Material> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(List<Material> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }
    
    
}
