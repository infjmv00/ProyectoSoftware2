/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.MenuFacadeLocal;
import Model.Menu;
import Model.Trabajador;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Jose Maria
 */
@Named
@SessionScoped
public class MenuController implements Serializable {

    @EJB
    private MenuFacadeLocal menuEJB;
    private List<Menu> lista;
    private MenuModel model;

    @PostConstruct
    public void init() {
        this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }

    public void listarMenus() {

        try {
            lista = menuEJB.findAll();
        } catch (Exception e) {
            //mensaje JSF 
        }

    }

    public void establecerPermisos() {
        Trabajador trab = (Trabajador) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("trabajador");
       DefaultSubMenu cerrarSesion = DefaultSubMenu.builder().label("Cerrar Sesión").build();
        for (Menu m : lista) {

            if (m.getTipo().equals("S") && m.getRol().getRol().equals(trab.getRol().getRol())) {
                // firstSubmenu
                DefaultSubMenu firstSubmenu = DefaultSubMenu.builder().label(m.getNombre()).build();
                for (Menu i : lista) {
                    Menu subMenu = i.getCodigo_submenu();

                    if (subMenu != null) {

                        if (subMenu.getIdMenu() == m.getIdMenu()) {
                            DefaultMenuItem item = DefaultMenuItem.builder().value(i.getNombre()).build();
                            item.setUrl(i.getUrl());
                            firstSubmenu.getElements().add(item);

                        }
                    }

                }
                 
            
                model.getElements().add(firstSubmenu);
                 

            } else {
                
                if(m.getCodigo_submenu() == null && m.getRol().getRol().equals(trab.getRol().getRol())){
                    DefaultMenuItem item = DefaultMenuItem.builder().value(m.getNombre()).build();
                    item.setUrl(m.getUrl());
                    model.getElements().add(item);
                }
                
            
        }
    }
       
        
        cerrarSesion.getElements().add(DefaultMenuItem.builder()
            .value("Cerrar Sesión")
            .icon("pi pi-fw pi-sign-out")
            .command("#{menuController.cerrarSesion}")
            .build());
        model.getElements().add(cerrarSesion);
        
    }
    
    
    public void cerrarSesion(){
        
        // Invalida la sesión actual
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        // Redirige a la página de inicio
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("./../index.xhtml?faces-redirect=true");
        } catch (Exception e) {
            System.out.println("Error en cerrar sesion: " +e.getMessage());
        }
    }

    public MenuFacadeLocal getMenuEJB() {
        return menuEJB;
    }

    public void setMenuEJB(MenuFacadeLocal menuEJB) {
        this.menuEJB = menuEJB;
    }

    public List<Menu> getLista() {
        return lista;
    }

    public void setLista(List<Menu> lista) {
        this.lista = lista;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.menuEJB);
        hash = 53 * hash + Objects.hashCode(this.lista);
        hash = 53 * hash + Objects.hashCode(this.model);
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
        final MenuController other = (MenuController) obj;
        if (!Objects.equals(this.menuEJB, other.menuEJB)) {
            return false;
        }
        if (!Objects.equals(this.lista, other.lista)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        return true;
    }
    
    

}
