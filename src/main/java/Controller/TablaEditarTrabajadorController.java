package Controller;

import EJB.TrabajadorFacadeLocal;
import Model.Trabajador;
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

@Named
@RequestScoped
public class TablaEditarTrabajadorController implements Serializable {

    @Inject
    private Trabajador trabajador;

    private List<Trabajador> listaTrabajadores;

    @EJB
    private TrabajadorFacadeLocal trabajadorEJB;

    @PostConstruct
    public void init() {
        try {
            listaTrabajadores = trabajadorEJB.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inicialización", e.getMessage()));
            e.printStackTrace();
        }
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public List<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public TrabajadorFacadeLocal getTrabajadorEJB() {
        return trabajadorEJB;
    }

    public void setTrabajadorEJB(TrabajadorFacadeLocal trabajadorEJB) {
        this.trabajadorEJB = trabajadorEJB;
    }

    public void onRowEdit(RowEditEvent<Trabajador> event) {
        FacesMessage msg = new FacesMessage("Trabajador Editado", String.valueOf(event.getObject().getIdTrabajador()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        trabajador = event.getObject();
        trabajadorEJB.edit(trabajador);
    }

    public void onRowCancel(RowEditEvent<Trabajador> event) {
        FacesMessage msg = new FacesMessage("Edición Cancelada con Id", String.valueOf(event.getObject().getIdTrabajador()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
   
    public void eliminar(Trabajador trabajador){
        FacesMessage msg = new FacesMessage("Trabajador Eliminado", String.valueOf(trabajador.getIdTrabajador()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        trabajador.setTrabajadoractivo(false);
        trabajadorEJB.edit(trabajador);
        // Volver a cargar la lista de trabajadores
        //listaTrabajadores = trabajadorEJB.findAll();
        System.out.println("Valor de trabajador activo: "+trabajador.isTrabajadoractivo());
       // trabajadorEJB.remove(trabajador);
       
    }
    
    
}
