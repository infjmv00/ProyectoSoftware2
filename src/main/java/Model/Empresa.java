/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jose Maria
 */

@Entity
@Table(name="tblDatos_Empresa")
public class Empresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int IdEmpresa;
      @Column(name="CIF_Empresa")
    private String cif_empresa;
    @Column(name="nombre_empresa")
    private String nombre_empresa;
    @Column(name="direccion_empresa")
    private String direccion_empresa;
    @Column(name="Telefono_empresa")
    private int telefono_empresa;
    @Column(name="e_mail")
    private String email;
    @Column(name="activaEmpresa")
    private boolean activaEmpresa;


    

   

    /*
    create table  tblDatos_Empresa(
    IdEmpresa int NOT NULL AUTO_INCREMENT primary key,
    CIF_Empresa CHAR(20) NOT NULL,
    nombre_empresa char(50) NOT NULL,
    direccion_empresa char(50) NOT NULL,
    Telefono_empresa bigint NOT NULL,
    e_mail char(50),
    activaempresa bit);
     */

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    public String getCif_empresa() {
        return cif_empresa;
    }

    public void setCif_empresa(String cif_empresa) {
        this.cif_empresa = cif_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public int getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(int telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivaEmpresa() {
        return activaEmpresa;
    }

    public void setActivaEmpresa(boolean activaEmpresa) {
        this.activaEmpresa = activaEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.IdEmpresa;
        hash = 47 * hash + Objects.hashCode(this.cif_empresa);
        hash = 47 * hash + Objects.hashCode(this.nombre_empresa);
        hash = 47 * hash + Objects.hashCode(this.direccion_empresa);
        hash = 47 * hash + this.telefono_empresa;
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + (this.activaEmpresa ? 1 : 0);
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
        final Empresa other = (Empresa) obj;
        if (this.IdEmpresa != other.IdEmpresa) {
            return false;
        }
        if (this.telefono_empresa != other.telefono_empresa) {
            return false;
        }
        if (this.activaEmpresa != other.activaEmpresa) {
            return false;
        }
        if (!Objects.equals(this.cif_empresa, other.cif_empresa)) {
            return false;
        }
        if (!Objects.equals(this.nombre_empresa, other.nombre_empresa)) {
            return false;
        }
        if (!Objects.equals(this.direccion_empresa, other.direccion_empresa)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

   
   
   
    
}
