/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.FamiliaFacadeLocal;
import EJB.MaterialFacadeLocal;
import Model.Familia;
import Model.Material;
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
public class AltaMaterialController implements Serializable {
    
    @EJB
    private MaterialFacadeLocal materialEJB;
    
    @EJB
    private FamiliaFacadeLocal familiaEJB;
       
    @Inject
    private Familia familia;
    
    @Inject Material material;
    
    private List<Familia>listaFamilias;
    
    @PostConstruct
    public void init(){
        familia = new Familia();
        material = new Material();
        listaFamilias = familiaEJB.findAll();
        
    }
    
    public void insertarMaterial(){
        
        try{
        
            material.setFamilia(familia);
            materialEJB.create(material);
            System.out.println("Material con id "+material.getIdMaterial()+" creado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Familia creada correctamente "+material.getIdMaterial()));
            
        } catch(Exception e){
            System.out.println("Error al insertar material: "+e.getMessage());
        }
        
        
        
    }

    public MaterialFacadeLocal getMaterialEJB() {
        return materialEJB;
    }

    public void setMaterialEJB(MaterialFacadeLocal materialEJB) {
        this.materialEJB = materialEJB;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public FamiliaFacadeLocal getFamiliaEJB() {
        return familiaEJB;
    }

    public void setFamiliaEJB(FamiliaFacadeLocal familiaEJB) {
        this.familiaEJB = familiaEJB;
    }

    public List<Familia> getListaFamilias() {
        return listaFamilias;
    }

    public void setListaFamilias(List<Familia> listaFamilias) {
        this.listaFamilias = listaFamilias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.materialEJB);
        hash = 71 * hash + Objects.hashCode(this.familiaEJB);
        hash = 71 * hash + Objects.hashCode(this.familia);
        hash = 71 * hash + Objects.hashCode(this.material);
        hash = 71 * hash + Objects.hashCode(this.listaFamilias);
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
        final AltaMaterialController other = (AltaMaterialController) obj;
        if (!Objects.equals(this.materialEJB, other.materialEJB)) {
            return false;
        }
        if (!Objects.equals(this.familiaEJB, other.familiaEJB)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.listaFamilias, other.listaFamilias)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
