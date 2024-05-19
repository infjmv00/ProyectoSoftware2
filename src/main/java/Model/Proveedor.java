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
@Table(name="tblProveedores")
public class Proveedor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdProveedor;

    @Column(name = "CIFprov")
    private String CIFprov;
    
    @Column(name = "nombreprov")
    private String nombreprov;
    
    @Column(name = "apellidosprov")
    private String apellidosprov;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "Telefonoprov")
    private long Telefonoprov;
    
    @Column(name = "e_mail")
    private String e_mail;
    
    @Column(name = "activoprov")
    private boolean activoprov;

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getCIFprov() {
        return CIFprov;
    }

    public void setCIFprov(String CIFprov) {
        this.CIFprov = CIFprov;
    }

    public String getNombreprov() {
        return nombreprov;
    }

    public void setNombreprov(String nombreprov) {
        this.nombreprov = nombreprov;
    }

    public String getApellidosprov() {
        return apellidosprov;
    }

    public void setApellidosprov(String apellidosprov) {
        this.apellidosprov = apellidosprov;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefonoprov() {
        return Telefonoprov;
    }

    public void setTelefonoprov(long Telefonoprov) {
        this.Telefonoprov = Telefonoprov;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public boolean isActivoprov() {
        return activoprov;
    }

    public void setActivoprov(boolean activoprov) {
        this.activoprov = activoprov;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.IdProveedor;
        hash = 89 * hash + Objects.hashCode(this.CIFprov);
        hash = 89 * hash + Objects.hashCode(this.nombreprov);
        hash = 89 * hash + Objects.hashCode(this.apellidosprov);
        hash = 89 * hash + Objects.hashCode(this.direccion);
        hash = 89 * hash + (int) (this.Telefonoprov ^ (this.Telefonoprov >>> 32));
        hash = 89 * hash + Objects.hashCode(this.e_mail);
        hash = 89 * hash + (this.activoprov ? 1 : 0);
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
        final Proveedor other = (Proveedor) obj;
        if (this.IdProveedor != other.IdProveedor) {
            return false;
        }
        if (this.Telefonoprov != other.Telefonoprov) {
            return false;
        }
        if (this.activoprov != other.activoprov) {
            return false;
        }
        if (!Objects.equals(this.CIFprov, other.CIFprov)) {
            return false;
        }
        if (!Objects.equals(this.nombreprov, other.nombreprov)) {
            return false;
        }
        if (!Objects.equals(this.apellidosprov, other.apellidosprov)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.e_mail, other.e_mail)) {
            return false;
        }
        return true;
    }
    
    
    
}
