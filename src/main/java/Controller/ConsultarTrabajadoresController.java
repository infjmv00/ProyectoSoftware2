/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TrabajadorFacadeLocal;
import Model.Trabajador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.FilterMeta;

/**
 *
 * @author Jose Maria
 */

@Named
@ViewScoped
public class ConsultarTrabajadoresController implements Serializable {
    
    @EJB
    private TrabajadorFacadeLocal trabajadorEJB;

    private List<Trabajador> listaTrabajadores;
    private List<Trabajador> listaAdministradores;
    private List<Trabajador> listaPropietarios;
    private List<Trabajador> listaEmpleados;
    private List<Trabajador> filteredAdmins;
    private List<Trabajador> filteredPropietarios;
    private List<Trabajador> filteredEmpleados;
    private Trabajador selectedAdmin;
    private Trabajador selectedProp;
     private Trabajador selectedEmp; 
    private int codigoTrabajador;
    private String globalFilter;

    @PostConstruct
    public void init() {
        listaTrabajadores = trabajadorEJB.findAll();
        listaAdministradores = filtrarAdministradores();
        listaPropietarios = this.filtrarPropietarios();
        listaEmpleados = this.filtrarEmpleados();
    }

    public Trabajador getSelectedProp() {
        return selectedProp;
    }

    public void setSelectedProp(Trabajador selectedProp) {
        this.selectedProp = selectedProp;
    }

    public Trabajador getSelectedEmp() {
        return selectedEmp;
    }

    public void setSelectedEmp(Trabajador selectedEmp) {
        this.selectedEmp = selectedEmp;
    }

    public List<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public List<Trabajador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(List<Trabajador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public List<Trabajador> getFilteredAdmins() {
        return filteredAdmins;
    }

    public void setFilteredAdmins(List<Trabajador> filteredAdmins) {
        this.filteredAdmins = filteredAdmins;
    }

    public Trabajador getSelectedAdmin() {
        return selectedAdmin;
    }

    public void setSelectedAdmin(Trabajador selectedAdmin) {
        this.selectedAdmin = selectedAdmin;
    }

    public int getCodigoTrabajador() {
        return codigoTrabajador;
    }

    public void setCodigoTrabajador(int codigoTrabajador) {
        this.codigoTrabajador = codigoTrabajador;
    }

    public String getGlobalFilter() {
        return globalFilter;
    }

    public void setGlobalFilter(String globalFilter) {
        this.globalFilter = globalFilter;
    }

    private List<Trabajador> filtrarAdministradores() {
        return listaTrabajadores.stream()
                .filter(t -> t.getRol().getIdRol() == 3 && t.isTrabajadoractivo())
                .collect(Collectors.toList());
    }
    
    private List<Trabajador> filtrarPropietarios() {
        return listaTrabajadores.stream()
                .filter(t -> t.getRol().getIdRol() == 1 && t.isTrabajadoractivo())
                .collect(Collectors.toList());
    }
    
    private List<Trabajador> filtrarEmpleados() {
        return listaTrabajadores.stream()
                .filter(t -> t.getRol().getIdRol() == 2 && t.isTrabajadoractivo())
                .collect(Collectors.toList());
    }

    public TrabajadorFacadeLocal getTrabajadorEJB() {
        return trabajadorEJB;
    }

    public void setTrabajadorEJB(TrabajadorFacadeLocal trabajadorEJB) {
        this.trabajadorEJB = trabajadorEJB;
    }

    public List<Trabajador> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(List<Trabajador> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }

    public List<Trabajador> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Trabajador> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Trabajador> getFilteredPropietarios() {
        return filteredPropietarios;
    }

    public void setFilteredPropietarios(List<Trabajador> filteredPropietarios) {
        this.filteredPropietarios = filteredPropietarios;
    }

    public List<Trabajador> getFilteredEmpleados() {
        return filteredEmpleados;
    }

    public void setFilteredEmpleados(List<Trabajador> filteredEmpleados) {
        this.filteredEmpleados = filteredEmpleados;
    }
    
    
    
    
    
    
    
}
