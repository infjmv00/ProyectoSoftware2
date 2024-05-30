/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.SueldoFacadeLocal;
import EJB.TrabajadorFacadeLocal;
import Model.Sueldo;
import Model.Trabajador;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
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
public class AltaNominaController implements Serializable {
    
    @Inject
    private Sueldo sueldo;
    
    @EJB
    private SueldoFacadeLocal sueldoEJB;
    
    @EJB
    private TrabajadorFacadeLocal trabajadorEJB;
    
    @Inject
    private Trabajador trabajador;
    
    private List<Trabajador>listaTrabajadores;
    
    
    @PostConstruct
    public void init(){
        sueldo = new Sueldo();
        trabajador = new Trabajador();
        listaTrabajadores = trabajadorEJB.findAll();
    }
    
    public void insertarNomina(){
        
        
        // error en la calcularNomina
       try{
            sueldo.setTotal(sueldoEJB.calcularNomina(sueldo));
            sueldo.setTrabajador(trabajador);
            sueldoEJB.create(sueldo);
            System.out.println(sueldo.getIdSueldo()+ " insertado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nomina creada correctamente "+sueldo.getIdSueldo()));
        } catch(Exception e){
            
            System.out.println("Error al insertar Sueldo en la base de datos "+ e.getMessage() + "iDENTIFICADOR DEL TRBAJADOR :"+trabajador.getIdTrabajador());
            System.out.println("Valor de Nomina: "+sueldo.getTotal());
        }
       
    }

    public Sueldo getSueldo() {
        return sueldo;
    }

    public void setSueldo(Sueldo sueldo) {
        this.sueldo = sueldo;
    }

    public SueldoFacadeLocal getSueldoEJB() {
        return sueldoEJB;
    }

    public void setSueldoEJB(SueldoFacadeLocal sueldoEJB) {
        this.sueldoEJB = sueldoEJB;
    }

    public TrabajadorFacadeLocal getTrabajadorEJB() {
        return trabajadorEJB;
    }

    public void setTrabajadorEJB(TrabajadorFacadeLocal trabajadorEJB) {
        this.trabajadorEJB = trabajadorEJB;
    }

    public List<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.sueldo);
        hash = 29 * hash + Objects.hashCode(this.sueldoEJB);
        hash = 29 * hash + Objects.hashCode(this.trabajadorEJB);
        hash = 29 * hash + Objects.hashCode(this.trabajador);
        hash = 29 * hash + Objects.hashCode(this.listaTrabajadores);
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
        final AltaNominaController other = (AltaNominaController) obj;
        if (!Objects.equals(this.sueldo, other.sueldo)) {
            return false;
        }
        if (!Objects.equals(this.sueldoEJB, other.sueldoEJB)) {
            return false;
        }
        if (!Objects.equals(this.trabajadorEJB, other.trabajadorEJB)) {
            return false;
        }
        if (!Objects.equals(this.trabajador, other.trabajador)) {
            return false;
        }
        if (!Objects.equals(this.listaTrabajadores, other.listaTrabajadores)) {
            return false;
        }
        return true;
    }

   
    
}
