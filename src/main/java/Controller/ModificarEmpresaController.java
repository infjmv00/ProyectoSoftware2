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
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Jose Maria
 */
@Named
@RequestScoped
public class ModificarEmpresaController implements Serializable {
    
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
    

public void onRowEdit(RowEditEvent<Empresa> event) {
        FacesMessage msg = new FacesMessage("Emprea editada", String.valueOf(event.getObject().getIdEmpresa()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        empresa = event.getObject();
        empresaEJB.edit(empresa);
    }

    public void onRowCancel(RowEditEvent<Empresa> event) {
        FacesMessage msg = new FacesMessage("Edición Cancelada con Id", String.valueOf(event.getObject().getIdEmpresa()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
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