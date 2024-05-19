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
@Table(name="tblFamilias")
public class Familia implements Serializable {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFamilia;
     
    @Column(name="CodigoFamilia")
    private String codigoFamilia;
    
    @Column(name="familia")
    private String nombreFamilia;
    
    @Column(name="activo")
    private boolean activaFamilia;

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getCodigoFamilia() {
        return codigoFamilia;
    }

    public void setCodigoFamilia(String codigoFamilia) {
        this.codigoFamilia = codigoFamilia;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public boolean isActivaFamilia() {
        return activaFamilia;
    }

    public void setActivaFamilia(boolean activaFamilia) {
        this.activaFamilia = activaFamilia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idFamilia;
        hash = 89 * hash + Objects.hashCode(this.codigoFamilia);
        hash = 89 * hash + Objects.hashCode(this.nombreFamilia);
        hash = 89 * hash + (this.activaFamilia ? 1 : 0);
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
        final Familia other = (Familia) obj;
        if (this.idFamilia != other.idFamilia) {
            return false;
        }
        if (this.activaFamilia != other.activaFamilia) {
            return false;
        }
        if (!Objects.equals(this.codigoFamilia, other.codigoFamilia)) {
            return false;
        }
        if (!Objects.equals(this.nombreFamilia, other.nombreFamilia)) {
            return false;
        }
        return true;
    }
    
    
    
}
