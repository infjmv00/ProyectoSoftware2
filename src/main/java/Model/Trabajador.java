/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jose Maria
 */

@Entity
@Table(name="tblTrabajadores")
public class Trabajador implements Serializable {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrabajador;
     
     @JoinColumn(name="idRol",nullable= false)
     @ManyToOne
     
    private Rol rol;
     
     @ManyToOne
     @JoinColumn(name="id_Empresa", nullable= false)
     private Empresa empresa;
    
      @Column(name="Fecha")
    private Date Fecha_nacimiento;
     @Column(name="usuario")
    private String usuario;
     @Column(name="contrasenya")
    private String contrasenya;
     @Column(name="nombretrab")
    private String nombre_trabajador;
     @Column(name="apellidostrab")
    private String apellidos_trabajador;
 @Column(name="direcciontrab")
    private String direccion_trabajador;
     @Column(name="Telefonotrab")
    private int telefono_trabajador;
     @Column(name="e_mailtrab")
    private String email_trabajador;
     @Column(name="fecha_inicio")
    private Date fecha_inicio;
     @Column(name="fecha_fin")
    private Date fecha_fin;
     @Column(name="activotrab")
    private boolean activo;
     @Column(name="NIFtrab")
    private String dni_trabajador;

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
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

    public Date getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date Fecha_nacimiento) {
        this.Fecha_nacimiento = Fecha_nacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getNombre_trabajador() {
        return nombre_trabajador;
    }

    public void setNombre_trabajador(String nombre_trabajador) {
        this.nombre_trabajador = nombre_trabajador;
    }

    public String getApellidos_trabajador() {
        return apellidos_trabajador;
    }

    public void setApellidos_trabajador(String apellidos_trabajador) {
        this.apellidos_trabajador = apellidos_trabajador;
    }

    public String getDireccion_trabajador() {
        return direccion_trabajador;
    }

    public void setDireccion_trabajador(String direccion_trabajador) {
        this.direccion_trabajador = direccion_trabajador;
    }

    public int getTelefono_trabajador() {
        return telefono_trabajador;
    }

    public void setTelefono_trabajador(int telefono_trabajador) {
        this.telefono_trabajador = telefono_trabajador;
    }

    public String getEmail_trabajador() {
        return email_trabajador;
    }

    public void setEmail_trabajador(String email_trabajador) {
        this.email_trabajador = email_trabajador;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDni_trabajador() {
        return dni_trabajador;
    }

    public void setDni_trabajador(String dni_trabajador) {
        this.dni_trabajador = dni_trabajador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idTrabajador;
        hash = 97 * hash + Objects.hashCode(this.rol);
        hash = 97 * hash + Objects.hashCode(this.empresa);
        hash = 97 * hash + Objects.hashCode(this.Fecha_nacimiento);
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.contrasenya);
        hash = 97 * hash + Objects.hashCode(this.nombre_trabajador);
        hash = 97 * hash + Objects.hashCode(this.apellidos_trabajador);
        hash = 97 * hash + Objects.hashCode(this.direccion_trabajador);
        hash = 97 * hash + this.telefono_trabajador;
        hash = 97 * hash + Objects.hashCode(this.email_trabajador);
        hash = 97 * hash + Objects.hashCode(this.fecha_inicio);
        hash = 97 * hash + Objects.hashCode(this.fecha_fin);
        hash = 97 * hash + (this.activo ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.dni_trabajador);
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
        final Trabajador other = (Trabajador) obj;
        if (this.idTrabajador != other.idTrabajador) {
            return false;
        }
        if (this.telefono_trabajador != other.telefono_trabajador) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasenya, other.contrasenya)) {
            return false;
        }
        if (!Objects.equals(this.nombre_trabajador, other.nombre_trabajador)) {
            return false;
        }
        if (!Objects.equals(this.apellidos_trabajador, other.apellidos_trabajador)) {
            return false;
        }
        if (!Objects.equals(this.direccion_trabajador, other.direccion_trabajador)) {
            return false;
        }
        if (!Objects.equals(this.email_trabajador, other.email_trabajador)) {
            return false;
        }
        if (!Objects.equals(this.dni_trabajador, other.dni_trabajador)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.Fecha_nacimiento, other.Fecha_nacimiento)) {
            return false;
        }
        if (!Objects.equals(this.fecha_inicio, other.fecha_inicio)) {
            return false;
        }
        if (!Objects.equals(this.fecha_fin, other.fecha_fin)) {
            return false;
        }
        return true;
    }


   
   

    
    
}

