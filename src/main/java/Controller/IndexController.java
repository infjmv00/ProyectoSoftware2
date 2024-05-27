package Controller;

import EJB.TrabajadorFacadeLocal;
import Model.Trabajador;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable {
   
    @EJB
    private TrabajadorFacadeLocal trabajadorEJB;
    
    private Trabajador trabajador;

    @PostConstruct
    public void init() {
        trabajador = new Trabajador();
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    public String iniciarSesion() {
        Trabajador trab;
        String redireccion = null;
       
        try {
            trab = trabajadorEJB.iniciarSesion(trabajador);
            if(trab.isTrabajadoractivo() == false){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso ", "No tienes permisos de acceso a la aplicacion"));
            } else if (trab != null) {
                // Almacenar sesión en JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("trabajador", trab);
                redireccion = "/protegido/principal?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso ", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            // Mensaje de JSF
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso ", "Error!! "));
        }
        
        return redireccion;
    }
    
   public void registrarTrabajador() {
    
       System.out.println("entras en registrar usuario");
    FacesContext context = FacesContext.getCurrentInstance();
    ExternalContext externalContext = context.getExternalContext();
    String contextPath = externalContext.getRequestContextPath();
    String redirectURL = contextPath + "/faces/AltaTrabajador.xhtml";
    
    try {
        externalContext.redirect(redirectURL);
    } catch (Exception e) {
        e.printStackTrace();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de redirección", "No se pudo redirigir a la página de registro."));
    }
}
}
