/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import EJB.FamiliaFacadeLocal;
import Model.Familia;
import java.io.Serializable;
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
public class AltaFamiliaController implements Serializable {
    
    @Inject
    private Familia familia;
    
    @EJB
    private FamiliaFacadeLocal familiaEJB;
    
    
    @PostConstruct
    
    public void init(){
        
        familia = new Familia();
    }
    
    public void insertarFamilia(){
        
        try{
            familiaEJB.create(familia);
            System.out.println("Familia creada con identificador "+familia.getCodigoFamilia()+" correctamente");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Familia creada correctamente "+familia.getCodigoFamilia()));
            
        } catch(Exception e){
            System.out.println("Error al insertar familia: "+e.getMessage());
        }
        
        
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public FamiliaFacadeLocal getFamiliaEJB() {
        return familiaEJB;
    }

    public void setFamiliaEJB(FamiliaFacadeLocal familiaEJB) {
        this.familiaEJB = familiaEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.familia);
        hash = 79 * hash + Objects.hashCode(this.familiaEJB);
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
        final AltaFamiliaController other = (AltaFamiliaController) obj;
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Objects.equals(this.familiaEJB, other.familiaEJB)) {
            return false;
        }
        return true;
    }
    
    
}
