/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.EmpresaFacadeLocal;
import Model.Empresa;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jose Maria
 */

@Named
@RequestScoped
public class EliminarEmpresaController implements Serializable {
    
    @Inject
    private Empresa empresa;

    private List<Empresa> listaEmpresa;

    @EJB
    private EmpresaFacadeLocal empresaEJB;
    
    
    @PostConstruct
    public void init() {
        try {
            listaEmpresa = empresaEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inicialización", e.getMessage()));
            e.printStackTrace();
        }
    }
    
    public void eliminar(Empresa empresa){
        FacesMessage msg = new FacesMessage("empresa Eliminada", String.valueOf(empresa.getIdEmpresa()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        empresa.setActivaEmpresa(false);
        empresaEJB.edit(empresa);
       
       
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(List<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public EmpresaFacadeLocal getEmpresaEJB() {
        return empresaEJB;
    }

    public void setEmpresaEJB(EmpresaFacadeLocal empresaEJB) {
        this.empresaEJB = empresaEJB;
    }
    
    
}
