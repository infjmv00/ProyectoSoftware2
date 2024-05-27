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
    private int IdTrabajador;
    
    @Column(name="NIFtrab")
    private String nifTrabajador;
    
    @Column(name="fecha")
    private Date fecha_nacimiento;
    
    @Column(name="usuario")
    private String usuario;
    
    @Column(name="contrasenya")
    private String contrasenya;
    
    @Column(name="nombreTrab")
    private String nombre_trabajador;
    
    @Column(name="apellidostrab")
    private String apellidos_trabajador;
    
    @Column(name="Telefonotrab")
    private long telefono_trabajador;
    
    @Column(name="direcciontrab")
    private String direccion_trabajador;
    
    @Column(name="e_mailtrab")
    private String e_mailtrabajador;
    
    @Column(name="Fecha_inicio")
    private Date fecha_inicio;
    
    @Column(name="fecha_fin")
    private Date fecha_fin;
    
    @Column(name="activotrab")
    private boolean trabajadoractivo;
    
    @JoinColumn(name="id_Empresa")
    @ManyToOne    
    private Empresa empresa;
    
    @JoinColumn(name="idRol")
    @ManyToOne 
    private Rol rol;
  
    
    /*
    
    IdTrabajador int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
NIFtrab char(15) NOT NULL UNIQUE,
IdRol int(11) NOT NULL,
id_Empresa int NOT NULL,
Fecha date NOT NULL,
usuario char(30),
contrasenya char(10),
nombretrab char(20) NOT NULL,
apellidostrab char(30) NOT NULL,
direcciontrab char(50) NOT NULL,
Telefonotrab bigint NOT NULL,
e_mailtrab char(50),
Fecha_inicio date NOT NULL,
fecha_fin date,
activotrab bit,*/

    public int getIdTrabajador() {
        return IdTrabajador;
    }

    public void setIdTrabajador(int IdTrabajador) {
        this.IdTrabajador = IdTrabajador;
    }

    public String getNifTrabajador() {
        return nifTrabajador;
    }

    public void setNifTrabajador(String nifTrabajador) {
        this.nifTrabajador = nifTrabajador;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public long getTelefono_trabajador() {
        return telefono_trabajador;
    }

    public void setTelefono_trabajador(long telefono_trabajador) {
        this.telefono_trabajador = telefono_trabajador;
    }

    public String getDireccion_trabajador() {
        return direccion_trabajador;
    }

    public void setDireccion_trabajador(String direccion_trabajador) {
        this.direccion_trabajador = direccion_trabajador;
    }

    public String getE_mailtrabajador() {
        return e_mailtrabajador;
    }

    public void setE_mailtrabajador(String e_mailtrabajador) {
        this.e_mailtrabajador = e_mailtrabajador;
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

    public boolean isTrabajadoractivo() {
        return trabajadoractivo;
    }

    public void setTrabajadoractivo(boolean trabajadoractivo) {
        this.trabajadoractivo = trabajadoractivo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.IdTrabajador;
        hash = 83 * hash + Objects.hashCode(this.nifTrabajador);
        hash = 83 * hash + Objects.hashCode(this.fecha_nacimiento);
        hash = 83 * hash + Objects.hashCode(this.usuario);
        hash = 83 * hash + Objects.hashCode(this.contrasenya);
        hash = 83 * hash + Objects.hashCode(this.nombre_trabajador);
        hash = 83 * hash + Objects.hashCode(this.apellidos_trabajador);
        hash = 83 * hash + (int) (this.telefono_trabajador ^ (this.telefono_trabajador >>> 32));
        hash = 83 * hash + Objects.hashCode(this.direccion_trabajador);
        hash = 83 * hash + Objects.hashCode(this.e_mailtrabajador);
        hash = 83 * hash + Objects.hashCode(this.fecha_inicio);
        hash = 83 * hash + Objects.hashCode(this.fecha_fin);
        hash = 83 * hash + (this.trabajadoractivo ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.empresa);
        hash = 83 * hash + Objects.hashCode(this.rol);
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
        if (this.IdTrabajador != other.IdTrabajador) {
            return false;
        }
        if (this.telefono_trabajador != other.telefono_trabajador) {
            return false;
        }
        if (this.trabajadoractivo != other.trabajadoractivo) {
            return false;
        }
        if (!Objects.equals(this.nifTrabajador, other.nifTrabajador)) {
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
        if (!Objects.equals(this.e_mailtrabajador, other.e_mailtrabajador)) {
            return false;
        }
        if (!Objects.equals(this.fecha_nacimiento, other.fecha_nacimiento)) {
            return false;
        }
        if (!Objects.equals(this.fecha_inicio, other.fecha_inicio)) {
            return false;
        }
        if (!Objects.equals(this.fecha_fin, other.fecha_fin)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        return true;
    }

    
    

    
    
}

