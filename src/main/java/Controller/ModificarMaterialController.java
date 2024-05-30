/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.MaterialFacadeLocal;
import Model.Factura;
import Model.Material;
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
public class ModificarMaterialController implements Serializable {
    
    
    @Inject
    private Material material;

    private List<Material> listaMaterial;

    @EJB
    private MaterialFacadeLocal materialEJB;
    
    @PostConstruct
    public void init() {
        try {
            listaMaterial = materialEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inicialización", e.getMessage()));
            e.printStackTrace();
        }
    }
    
    public void onRowEdit(RowEditEvent<Material> event) {
        FacesMessage msg = new FacesMessage("Material Editado: ", String.valueOf(event.getObject().getIdMaterial()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        material = event.getObject();
        materialEJB.edit(material);
    }

    public void onRowCancel(RowEditEvent<Material> event) {
        FacesMessage msg = new FacesMessage("Edición Cancelada con Id", String.valueOf(event.getObject().getIdMaterial()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Material> getListaMaterial() {
        return listaMaterial;
    }

    public void setListaMaterial(List<Material> listaMaterial) {
        this.listaMaterial = listaMaterial;
    }

    public MaterialFacadeLocal getMaterialEJB() {
        return materialEJB;
    }

    public void setMaterialEJB(MaterialFacadeLocal materialEJB) {
        this.materialEJB = materialEJB;
    }

    
    
}
