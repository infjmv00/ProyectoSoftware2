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
import javax.persistence.Table;

/**
 *
 * @author Jose Maria
 */

@Entity
@Table(name="tblClientes")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Cliente;
 
    @Column(name = "CIFNIFcli")
    private String CIFNIFcli;

    @Column(name = "Fecha")
    private Date Fecha;

    @Column(name = "nombrecli")
    private String nombrecli;

    @Column(name = "apellidoscli")
    private String apellidoscli;

    @Column(name = "direccioncli")
    private String direccioncli;

    @Column(name = "Telefonocli")
    private long Telefonocli;

    @Column(name = "e_mailcli")
    private String e_mailcli;

    @Column(name = "activocli")
    private boolean activocli;

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getCIFNIFcli() {
        return CIFNIFcli;
    }

    public void setCIFNIFcli(String CIFNIFcli) {
        this.CIFNIFcli = CIFNIFcli;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getNombrecli() {
        return nombrecli;
    }

    public void setNombrecli(String nombrecli) {
        this.nombrecli = nombrecli;
    }

    public String getApellidoscli() {
        return apellidoscli;
    }

    public void setApellidoscli(String apellidoscli) {
        this.apellidoscli = apellidoscli;
    }

    public String getDireccioncli() {
        return direccioncli;
    }

    public void setDireccioncli(String direccioncli) {
        this.direccioncli = direccioncli;
    }

    public long getTelefonocli() {
        return Telefonocli;
    }

    public void setTelefonocli(long Telefonocli) {
        this.Telefonocli = Telefonocli;
    }

    public String getE_mailcli() {
        return e_mailcli;
    }

    public void setE_mailcli(String e_mailcli) {
        this.e_mailcli = e_mailcli;
    }

    public boolean isActivocli() {
        return activocli;
    }

    public void setActivocli(boolean activocli) {
        this.activocli = activocli;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_Cliente;
        hash = 97 * hash + Objects.hashCode(this.CIFNIFcli);
        hash = 97 * hash + Objects.hashCode(this.Fecha);
        hash = 97 * hash + Objects.hashCode(this.nombrecli);
        hash = 97 * hash + Objects.hashCode(this.apellidoscli);
        hash = 97 * hash + Objects.hashCode(this.direccioncli);
        hash = 97 * hash + (int) (this.Telefonocli ^ (this.Telefonocli >>> 32));
        hash = 97 * hash + Objects.hashCode(this.e_mailcli);
        hash = 97 * hash + (this.activocli ? 1 : 0);
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
        final Cliente other = (Cliente) obj;
        if (this.id_Cliente != other.id_Cliente) {
            return false;
        }
        if (this.Telefonocli != other.Telefonocli) {
            return false;
        }
        if (this.activocli != other.activocli) {
            return false;
        }
        if (!Objects.equals(this.CIFNIFcli, other.CIFNIFcli)) {
            return false;
        }
        if (!Objects.equals(this.nombrecli, other.nombrecli)) {
            return false;
        }
        if (!Objects.equals(this.apellidoscli, other.apellidoscli)) {
            return false;
        }
        if (!Objects.equals(this.direccioncli, other.direccioncli)) {
            return false;
        }
        if (!Objects.equals(this.e_mailcli, other.e_mailcli)) {
            return false;
        }
        if (!Objects.equals(this.Fecha, other.Fecha)) {
            return false;
        }
        return true;
    }
    
    
    

}
