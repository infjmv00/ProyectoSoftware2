/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.EmpresaFacadeLocal;
import Model.Empresa;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jose Maria
 */
@Named
@ViewScoped
public class AltaEmpresaController implements Serializable{
    
     private Empresa empresa;
    
    @EJB
    private EmpresaFacadeLocal empresaEJB;
    
    
    @PostConstruct
    public void init(){
        
        empresa = new Empresa();
    }
    
    public void insertarEmpresa(){
        
         try{
            empresaEJB.create(empresa);
            System.out.println(empresa.getNombre_empresa()+ " Insertada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Empresa creada correctamente "+empresa.getIdEmpresa()));
        } catch(Exception e){
            
            System.out.println("Error al insertar empresa en la base de datos "+ e.getMessage());
        }
         
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public EmpresaFacadeLocal getEmpresaEJB() {
        return empresaEJB;
    }

    public void setEmpresaEJB(EmpresaFacadeLocal empresaEJB) {
        this.empresaEJB = empresaEJB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.empresa);
        hash = 97 * hash + Objects.hashCode(this.empresaEJB);
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
        final AltaEmpresaController other = (AltaEmpresaController) obj;
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.empresaEJB, other.empresaEJB)) {
            return false;
        }
        return true;
    }
    
    
}
