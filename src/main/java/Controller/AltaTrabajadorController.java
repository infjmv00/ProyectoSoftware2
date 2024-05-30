/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.EmpresaFacadeLocal;
import EJB.RolFacadeLocal;
import EJB.TrabajadorFacadeLocal;
import Model.Empresa;
import Model.Rol;
import Model.Trabajador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Jose Maria
 */

@Named
@ViewScoped
public class AltaTrabajadorController implements Serializable {
    
    @EJB
    private TrabajadorFacadeLocal trabajadorEJB;
    
    @EJB
    private EmpresaFacadeLocal empresaEJB;
    
    @EJB
    private RolFacadeLocal rolEJB;
    
    @Inject
    private Trabajador trabajador;
    
    @Inject
    private Rol rol;
    
    @Inject
    private Empresa empresa;
    
    
    
    
    
    private List<Rol> listaRoles;
     private List<Empresa>listaEmpresas;
    private List<Integer> listaIdRoles;
    private List<Integer> listaIdEmpresas;
    
    
  @PostConstruct
    
    public void init(){
        
        trabajador = new Trabajador();
         rol = new Rol(); // Inicializar el objeto rol
        empresa = new Empresa(); // Inicializar el objeto empresa       
        listaRoles = rolEJB.findAll();
        listaEmpresas = empresaEJB.findAll();
        listaIdRoles = new ArrayList();
        listaIdEmpresas = new ArrayList();
        for (int i =0; i < listaRoles.size();i++){
            listaIdRoles.add(listaRoles.get(i).getIdRol());
        }
        for (int i =0; i < listaEmpresas.size();i++){
            listaIdEmpresas.add(listaEmpresas.get(i).getIdEmpresa());
        }
    }
    
    public void insertarTrabajador(){
    
        System.out.println("Nombre del trabajador: "+trabajador.getNombre_trabajador());
        try{
         //  trabajador.setRol(rol);
           trabajador.setRol(rol);
           trabajador.setEmpresa(empresa);
      
          System.out.println("aparentemente insertas");
            //trabajador.setRol(rol);
            trabajadorEJB.create(trabajador);
            
            System.out.println(trabajador.getIdTrabajador());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Proveedor creado correctamente "+trabajador.getIdTrabajador()));
            System.out.println(trabajador.getNombre_trabajador()+ " insertado correctamente");
            
           
        } catch(Exception e){
            
            System.out.println("Error al insertar trabajador en la base de datos "+ e.getMessage() );
        }
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TrabajadorFacadeLocal getTrabajadorEJB() {
        return trabajadorEJB;
    }

    public void setTrabajadorEJB(TrabajadorFacadeLocal trabajadorEJB) {
        this.trabajadorEJB = trabajadorEJB;
    }

    public EmpresaFacadeLocal getEmpresaEJB() {
        return empresaEJB;
    }

    public void setEmpresaEJB(EmpresaFacadeLocal empresaEJB) {
        this.empresaEJB = empresaEJB;
    }

    public RolFacadeLocal getRolEJB() {
        return rolEJB;
    }

    public void setRolEJB(RolFacadeLocal rolEJB) {
        this.rolEJB = rolEJB;
    }

    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public List<Integer> getListaIdRoles() {
        return listaIdRoles;
    }

    public void setListaIdRoles(List<Integer> listaIdRoles) {
        this.listaIdRoles = listaIdRoles;
    }

    public List<Integer> getListaIdEmpresas() {
        return listaIdEmpresas;
    }

    public void setListaIdEmpresas(List<Integer> listaIdEmpresas) {
        this.listaIdEmpresas = listaIdEmpresas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.trabajador);
        hash = 23 * hash + Objects.hashCode(this.rol);
        hash = 23 * hash + Objects.hashCode(this.empresa);
        hash = 23 * hash + Objects.hashCode(this.trabajadorEJB);
        hash = 23 * hash + Objects.hashCode(this.empresaEJB);
        hash = 23 * hash + Objects.hashCode(this.rolEJB);
        hash = 23 * hash + Objects.hashCode(this.listaRoles);
        hash = 23 * hash + Objects.hashCode(this.listaEmpresas);
        hash = 23 * hash + Objects.hashCode(this.listaIdRoles);
        hash = 23 * hash + Objects.hashCode(this.listaIdEmpresas);
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
        final AltaTrabajadorController other = (AltaTrabajadorController) obj;
        if (!Objects.equals(this.trabajador, other.trabajador)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.trabajadorEJB, other.trabajadorEJB)) {
            return false;
        }
        if (!Objects.equals(this.empresaEJB, other.empresaEJB)) {
            return false;
        }
        if (!Objects.equals(this.rolEJB, other.rolEJB)) {
            return false;
        }
        if (!Objects.equals(this.listaRoles, other.listaRoles)) {
            return false;
        }
        if (!Objects.equals(this.listaEmpresas, other.listaEmpresas)) {
            return false;
        }
        if (!Objects.equals(this.listaIdRoles, other.listaIdRoles)) {
            return false;
        }
        if (!Objects.equals(this.listaIdEmpresas, other.listaIdEmpresas)) {
            return false;
        }
        return true;
    }

   

    
    
    

    
}
