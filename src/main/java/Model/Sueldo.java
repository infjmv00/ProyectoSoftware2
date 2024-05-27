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
@Table(name="tblSueldos")
public class Sueldo implements Serializable {
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSueldo;
    
    @JoinColumn(name="IdTrabajador")
     @ManyToOne
    private Trabajador trabajador;
    
    @Column(name="fecha")
    private Date fecha;
    
    @Column(name="enbruto")
    private float enbruto;
    
    @Column(name="gastosirpf")
    private float gastosirpf;
    
    @Column(name="seguridad_social")
    private float seguridad_Social;
    
    @Column(name="primas")
    private float primas;
    
    @Column(name="total")
    private float total;

    public int getIdSueldo() {
        return idSueldo;
    }

    public void setIdSueldo(int idSueldo) {
        this.idSueldo = idSueldo;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getEnbruto() {
        return enbruto;
    }

    public void setEnbruto(float enbruto) {
        this.enbruto = enbruto;
    }

    public float getGastosirpf() {
        return gastosirpf;
    }

    public void setGastosirpf(float gastosirpf) {
        this.gastosirpf = gastosirpf;
    }

    public float getSeguridad_Social() {
        return seguridad_Social;
    }

    public void setSeguridad_Social(float seguridad_Social) {
        this.seguridad_Social = seguridad_Social;
    }

    public float getPrimas() {
        return primas;
    }

    public void setPrimas(float primas) {
        this.primas = primas;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idSueldo;
        hash = 37 * hash + Objects.hashCode(this.trabajador);
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + Float.floatToIntBits(this.enbruto);
        hash = 37 * hash + Float.floatToIntBits(this.gastosirpf);
        hash = 37 * hash + Float.floatToIntBits(this.seguridad_Social);
        hash = 37 * hash + Float.floatToIntBits(this.primas);
        hash = 37 * hash + Float.floatToIntBits(this.total);
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
        final Sueldo other = (Sueldo) obj;
        if (this.idSueldo != other.idSueldo) {
            return false;
        }
        if (Float.floatToIntBits(this.enbruto) != Float.floatToIntBits(other.enbruto)) {
            return false;
        }
        if (Float.floatToIntBits(this.gastosirpf) != Float.floatToIntBits(other.gastosirpf)) {
            return false;
        }
        if (Float.floatToIntBits(this.seguridad_Social) != Float.floatToIntBits(other.seguridad_Social)) {
            return false;
        }
        if (Float.floatToIntBits(this.primas) != Float.floatToIntBits(other.primas)) {
            return false;
        }
        if (Float.floatToIntBits(this.total) != Float.floatToIntBits(other.total)) {
            return false;
        }
        if (!Objects.equals(this.trabajador, other.trabajador)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    
    
    
            
    
    
}
