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
public class MenuPruebaController implements Serializable {
    
    @EJB
    private MenuFacadeLocal menuEJB;
    private List<Menu> lista;
    private MenuModel model;

    @PostConstruct 
    public void init() {
        //this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();

        // First submenu
        

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

    if (trab.getRol().getRol().equals("E")) {
        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder().label("Trabajadores").build();

       /* DefaultMenuItem itemNuevoTrabajador = DefaultMenuItem.builder().value("Nuevo").build();
        itemNuevoTrabajador.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaTrabajador.xhtml");
        firstSubmenu.getElements().add(itemNuevoTrabajador);*/

        DefaultMenuItem itemModificarTrabajador = DefaultMenuItem.builder().value("Modificar").build();
        itemModificarTrabajador.setUrl("/ProyectoSoftware2/faces/protegido/empleado/ModificarTrabajador.xhtml");
        firstSubmenu.getElements().add(itemModificarTrabajador);

        DefaultSubMenu secondSubmenu = DefaultSubMenu.builder().label("Nominas").build();

        DefaultMenuItem itemAltaNomina = DefaultMenuItem.builder().value("Alta").build();
        itemAltaNomina.setUrl("/ProyectoSoftware2/faces/protegido/empleado/AltaNomina.xhtml");
        secondSubmenu.getElements().add(itemAltaNomina);

        DefaultMenuItem itemModificarNomina = DefaultMenuItem.builder().value("Modificar").build();
        itemModificarNomina.setUrl("/ProyectoSoftware2/faces/protegido/empleado/ModificarNomina.xhtml");
        secondSubmenu.getElements().add(itemModificarNomina);

       
        
        
        
        
        
        
        model.getElements().add(firstSubmenu);
        model.getElements().add(secondSubmenu);
    }
    else if (trab.getRol().getRol().equals("P")) {
        
        
        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder().label("Trabajadores").build();

        DefaultMenuItem itemNuevoTrabajador = DefaultMenuItem.builder().value("Nuevo").build();
        itemNuevoTrabajador.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaTrabajador.xhtml");
        firstSubmenu.getElements().add(itemNuevoTrabajador);

        DefaultMenuItem itemModificarTrabajador = DefaultMenuItem.builder().value("Modificar").build();
        itemModificarTrabajador.setUrl("/ProyectoSoftware2/faces/protegido/empleado/ModificarTrabajador.xhtml");
        firstSubmenu.getElements().add(itemModificarTrabajador);
        
        
        DefaultMenuItem itemEliminarTrabajador = DefaultMenuItem.builder().value("Eliminar").build();
        itemModificarTrabajador.setUrl("/ProyectoSoftware2/faces/protegido/emplesdo/EliminarTrabajador.xhtml");
        firstSubmenu.getElements().add(itemModificarTrabajador);

        DefaultSubMenu secondSubmenu = DefaultSubMenu.builder().label("Nominas").build();

        DefaultMenuItem itemAltaNomina = DefaultMenuItem.builder().value("Alta").build();
        itemAltaNomina.setUrl("/ProyectoSoftware2/faces/protegido/empleado/AltaNomina.xhtml");
        secondSubmenu.getElements().add(itemAltaNomina);

        DefaultMenuItem itemModificarNomina = DefaultMenuItem.builder().value("Modificar").build();
        itemModificarNomina.setUrl("/ProyectoSoftware2/faces/protegido/empleado/ModificarNomina.xhtml");
        secondSubmenu.getElements().add(itemModificarNomina);

        
         DefaultSubMenu FamiliasSubmenu = DefaultSubMenu.builder().label("Familias").build();
         
         DefaultMenuItem itemAltaFamilia = DefaultMenuItem.builder().value("Alta").build();
         itemAltaFamilia.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaFamilias.xhtml");
         FamiliasSubmenu.getElements().add(itemAltaFamilia);
         
         
         
        DefaultSubMenu MaterialSubmenu = DefaultSubMenu.builder().label("Material").build();
         
         DefaultMenuItem itemAltaMaterial = DefaultMenuItem.builder().value("Alta").build();
         itemAltaMaterial.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaMaterial.xhtml");
         FamiliasSubmenu.getElements().add(itemAltaMaterial);
         
         DefaultMenuItem itemModificarMaterial = DefaultMenuItem.builder().value("Modificar").build();
         itemModificarMaterial.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ModificarMaterial.xhtml");
         FamiliasSubmenu.getElements().add(itemModificarMaterial);
         
         
         DefaultSubMenu ClientesSubmenu = DefaultSubMenu.builder().label("Clientes").build();
         
         DefaultMenuItem itemAltaClientes = DefaultMenuItem.builder().value("Alta").build();
         itemAltaClientes.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaClientes.xhtml");
         ClientesSubmenu.getElements().add(itemAltaClientes);
         
         DefaultMenuItem itemModificarEliminarCliente = DefaultMenuItem.builder().value("Modificar").build();
         itemModificarEliminarCliente.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ModificarEliminarCliente.xhtml");
         ClientesSubmenu.getElements().add(itemModificarEliminarCliente);
         
         DefaultSubMenu PresupuestoSubmenu = DefaultSubMenu.builder().label("Presupuestos").build();
         
         DefaultMenuItem itemAltaPresupuesto = DefaultMenuItem.builder().value("Alta").build();
         itemAltaPresupuesto.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaPresupuesto.xhtml");
         PresupuestoSubmenu.getElements().add(itemAltaPresupuesto);
         
         DefaultMenuItem itemModificarPresupuesto = DefaultMenuItem.builder().value("Modificar").build();
         itemModificarPresupuesto.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ModificarPresupuesto.xhtml");
         FamiliasSubmenu.getElements().add(itemModificarPresupuesto);
         
         DefaultSubMenu FacturasSubmenu = DefaultSubMenu.builder().label("Facturas").build();
         
         DefaultMenuItem itemAltaFactura = DefaultMenuItem.builder().value("Alta").build();
         itemAltaFactura.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaFactura.xhtml");
         FacturasSubmenu.getElements().add(itemAltaFactura);
         
         DefaultMenuItem itemModificarFactura = DefaultMenuItem.builder().value("Modificar").build();
         itemModificarFactura.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ModificarPresupuesto.xhtml");
         FacturasSubmenu.getElements().add(itemModificarFactura);
         
         DefaultSubMenu ProveedoresSubmenu = DefaultSubMenu.builder().label("Proveedores").build();
         
         DefaultMenuItem itemAltaproveedor = DefaultMenuItem.builder().value("Alta").build();
         itemAltaproveedor.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaProveedor.xhtml");
         ProveedoresSubmenu.getElements().add(itemAltaproveedor);
         
         DefaultMenuItem itemModificarproveedor = DefaultMenuItem.builder().value("Modificar").build();
         itemModificarproveedor.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ModificarProveedor.xhtml");
         ProveedoresSubmenu.getElements().add(itemModificarproveedor);
         
         DefaultMenuItem itemEliminarproveedor = DefaultMenuItem.builder().value("Modificar").build();
         itemEliminarproveedor.setUrl("/ProyectoSoftware2/faces/protegido/propietario/EliminarProveedor.xhtml");
         ProveedoresSubmenu.getElements().add(itemEliminarproveedor);
        
        
        DefaultSubMenu StockSubmenu = DefaultSubMenu.builder().label("Stock").build();
         
         DefaultMenuItem itemAltaStock = DefaultMenuItem.builder().value("Alta").build();
         itemAltaStock.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaStock.xhtml");
         StockSubmenu.getElements().add(itemAltaStock);
         
         DefaultMenuItem itemModificarStock = DefaultMenuItem.builder().value("Modificar").build();
         itemModificarStock.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ModificarStock.xhtml");
         StockSubmenu.getElements().add(itemModificarStock);
        
         DefaultSubMenu ConsultaSubmenu = DefaultSubMenu.builder().label("Consultas").build();
         
         DefaultMenuItem itemConsultaEmpleados = DefaultMenuItem.builder().value("consulta empleados").build();
         itemConsultaEmpleados.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ConsultaEmpleados.xhtml");
         StockSubmenu.getElements().add(itemConsultaEmpleados);
         
         DefaultMenuItem itemConsultaProveedores = DefaultMenuItem.builder().value("Consulta Proveedores").build();
         itemConsultaProveedores.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ConsultaProveedores.xhtml");
         StockSubmenu.getElements().add(itemConsultaProveedores);
        
        
        
        model.getElements().add(firstSubmenu);
        model.getElements().add(secondSubmenu);
        model.getElements().add(FamiliasSubmenu);
        model.getElements().add(MaterialSubmenu);
        model.getElements().add(ClientesSubmenu);
        model.getElements().add(PresupuestoSubmenu);
        model.getElements().add(FacturasSubmenu);
         model.getElements().add(ProveedoresSubmenu);
         
         model.getElements().add(StockSubmenu);
        
        model.getElements().add(ConsultaSubmenu);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Add additional roles if necessary
    } else if (trab.getRol().getRol().equals("A")) {
        
        
         DefaultSubMenu firstSubmenu = DefaultSubMenu.builder().label("Trabajadores").build();

        DefaultMenuItem itemNuevoTrabajador = DefaultMenuItem.builder().value("Nuevo").build();
        itemNuevoTrabajador.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaTrabajador.xhtml");
        firstSubmenu.getElements().add(itemNuevoTrabajador);

        DefaultMenuItem itemModificarTrabajador = DefaultMenuItem.builder().value("Modificar").build();
        itemModificarTrabajador.setUrl("/ProyectoSoftware2/faces/protegido/empleado/ModificarTrabajador.xhtml");
        firstSubmenu.getElements().add(itemModificarTrabajador);
        
        
        DefaultMenuItem itemEliminarTrabajador = DefaultMenuItem.builder().value("Eliminar").build();
        itemModificarTrabajador.setUrl("/ProyectoSoftware2/faces/protegido/emplesdo/EliminarTrabajador.xhtml");
        firstSubmenu.getElements().add(itemModificarTrabajador);

        DefaultSubMenu secondSubmenu = DefaultSubMenu.builder().label("Nominas").build();

        DefaultMenuItem itemAltaNomina = DefaultMenuItem.builder().value("Alta").build();
        itemAltaNomina.setUrl("/ProyectoSoftware2/faces/protegido/empleado/AltaNomina.xhtml");
        secondSubmenu.getElements().add(itemAltaNomina);

        DefaultMenuItem itemModificarNomina = DefaultMenuItem.builder().value("Modificar").build();
        itemModificarNomina.setUrl("/ProyectoSoftware2/faces/protegido/empleado/ModificarNomina.xhtml");
        secondSubmenu.getElements().add(itemModificarNomina);

        
         DefaultSubMenu FamiliasSubmenu = DefaultSubMenu.builder().label("Familias").build();
         
         DefaultMenuItem itemAltaFamilia = DefaultMenuItem.builder().value("Alta").build();
         itemAltaFamilia.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaFamilias.xhtml");
         FamiliasSubmenu.getElements().add(itemAltaFamilia);
         
         
         
        DefaultSubMenu MaterialSubmenu = DefaultSubMenu.builder().label("Material").build();
         
         DefaultMenuItem itemAltaMaterial = DefaultMenuItem.builder().value("Alta").build();
         itemAltaMaterial.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaMaterial.xhtml");
         FamiliasSubmenu.getElements().add(itemAltaMaterial);
         
         DefaultMenuItem itemModificarMaterial = DefaultMenuItem.builder().value("Modificar").build();
         itemModificarMaterial.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ModificarMaterial.xhtml");
         FamiliasSubmenu.getElements().add(itemModificarMaterial);
         
         DefaultSubMenu PresupuestoSubmenu = DefaultSubMenu.builder().label("Presupuestos").build();
         
         DefaultMenuItem itemAltaPresupuesto = DefaultMenuItem.builder().value("Alta").build();
         itemAltaPresupuesto.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaPresupuesto.xhtml");
         PresupuestoSubmenu.getElements().add(itemAltaPresupuesto);
         
         DefaultMenuItem itemModificarPresupuesto = DefaultMenuItem.builder().value("Modificar").build();
         itemModificarPresupuesto.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ModificarPresupuesto.xhtml");
         FamiliasSubmenu.getElements().add(itemModificarPresupuesto);
         
         DefaultSubMenu FacturasSubmenu = DefaultSubMenu.builder().label("Facturas").build();
         
         DefaultMenuItem itemAltaFactura = DefaultMenuItem.builder().value("Alta").build();
         itemAltaFactura.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaFactura.xhtml");
         FacturasSubmenu.getElements().add(itemAltaFactura);
         
         DefaultMenuItem itemModificarFactura = DefaultMenuItem.builder().value("Modificar").build();
         itemModificarFactura.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ModificarPresupuesto.xhtml");
         FacturasSubmenu.getElements().add(itemModificarFactura);
         
         DefaultSubMenu ProveedoresSubmenu = DefaultSubMenu.builder().label("Proveedores").build();
         
         DefaultMenuItem itemAltaproveedor = DefaultMenuItem.builder().value("Alta").build();
         itemAltaproveedor.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaProveedor.xhtml");
         ProveedoresSubmenu.getElements().add(itemAltaproveedor);
         
         DefaultMenuItem itemModificarproveedor = DefaultMenuItem.builder().value("Modificar").build();
         itemModificarproveedor.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ModificarProveedor.xhtml");
         ProveedoresSubmenu.getElements().add(itemModificarproveedor);
         
         DefaultMenuItem itemEliminarproveedor = DefaultMenuItem.builder().value("Modificar").build();
         itemEliminarproveedor.setUrl("/ProyectoSoftware2/faces/protegido/propietario/EliminarProveedor.xhtml");
         ProveedoresSubmenu.getElements().add(itemEliminarproveedor);
        
        
        DefaultSubMenu StockSubmenu = DefaultSubMenu.builder().label("Stock").build();
         
         DefaultMenuItem itemAltaStock = DefaultMenuItem.builder().value("Alta").build();
         itemAltaStock.setUrl("/ProyectoSoftware2/faces/protegido/propietario/AltaStock.xhtml");
         StockSubmenu.getElements().add(itemAltaStock);
         
         DefaultMenuItem itemModificarStock = DefaultMenuItem.builder().value("Modificar").build();
         itemModificarStock.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ModificarStock.xhtml");
         StockSubmenu.getElements().add(itemModificarStock);
        
         DefaultSubMenu ConsultaSubmenu = DefaultSubMenu.builder().label("Consultas").build();
         
         DefaultMenuItem itemConsultaEmpleados = DefaultMenuItem.builder().value("consulta empleados").build();
         itemConsultaEmpleados.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ConsultaEmpleados.xhtml");
         StockSubmenu.getElements().add(itemConsultaEmpleados);
         
         DefaultMenuItem itemConsultaProveedores = DefaultMenuItem.builder().value("Consulta Proveedores").build();
         itemConsultaProveedores.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ConsultaProveedores.xhtml");
         StockSubmenu.getElements().add(itemConsultaProveedores);
         
         DefaultMenuItem itemConsultaTiendas = DefaultMenuItem.builder().value("Consulta Tiendas").build();
         itemConsultaTiendas.setUrl("/ProyectoSoftware2/faces/protegido/propietario/ConsultaInformacionTiendas.xhtml");
         StockSubmenu.getElements().add(itemConsultaTiendas);
        
        DefaultSubMenu tiendasSubmenu = DefaultSubMenu.builder().label("Tiendas").build();

        DefaultMenuItem itemNuevaTienda = DefaultMenuItem.builder().value("Nueva").build();
        itemNuevaTienda.setUrl("/ProyectoSoftware2/faces/protegido/administrador/AltaEmpresa.xhtml");
        tiendasSubmenu.getElements().add(itemNuevaTienda);

        DefaultMenuItem itemModificarTienda = DefaultMenuItem.builder().value("Modificar").build();
        itemModificarTienda.setUrl("/ProyectoSoftware2/faces/protegido/administrador/ModificarEmpresa.xhtml");
        tiendasSubmenu.getElements().add(itemModificarTienda);
        
        
        DefaultMenuItem itemEliminarTienda = DefaultMenuItem.builder().value("Eliminar").build();
        itemEliminarTienda.setUrl("/ProyectoSoftware2/faces/administrador/emplesdo/EliminarEmpresa.xhtml");
        tiendasSubmenu.getElements().add(itemEliminarTienda);

        
        model.getElements().add(firstSubmenu);
        model.getElements().add(secondSubmenu);
        model.getElements().add(FamiliasSubmenu);
        model.getElements().add(MaterialSubmenu);
        model.getElements().add(PresupuestoSubmenu);
        model.getElements().add(FacturasSubmenu);
         model.getElements().add(ProveedoresSubmenu);
         
         model.getElements().add(StockSubmenu);
        
        model.getElements().add(ConsultaSubmenu);
        model.getElements().add(tiendasSubmenu);
        
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
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
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
    
    
    
}
