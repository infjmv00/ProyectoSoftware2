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
@Table(name="tblTrabajosRealizados")
public class TrabajoRealizado implements Serializable{
 
    
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int cod_trabajo;
   
    @Column(name = "fecha_inicio")
    private Date fecha_inicio;
    
    @Column(name = "descripcion")
    private String descripcion;
            
    @JoinColumn(name = "n_factura", nullable = false)
    @ManyToOne
    private Factura factura;

    @JoinColumn(name = "IdTrabajador", nullable = false)
    @ManyToOne
    private Trabajador trabajador;
    
    @Column(name = "fecha_fin")
    private Date fecha_fin;

    public int getCod_trabajo() {
        return cod_trabajo;
    }

    public void setCod_trabajo(int cod_trabajo) {
        this.cod_trabajo = cod_trabajo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.cod_trabajo;
        hash = 41 * hash + Objects.hashCode(this.fecha_inicio);
        hash = 41 * hash + Objects.hashCode(this.descripcion);
        hash = 41 * hash + Objects.hashCode(this.factura);
        hash = 41 * hash + Objects.hashCode(this.trabajador);
        hash = 41 * hash + Objects.hashCode(this.fecha_fin);
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
        final TrabajoRealizado other = (TrabajoRealizado) obj;
        if (this.cod_trabajo != other.cod_trabajo) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.fecha_inicio, other.fecha_inicio)) {
            return false;
        }
        if (!Objects.equals(this.factura, other.factura)) {
            return false;
        }
        if (!Objects.equals(this.trabajador, other.trabajador)) {
            return false;
        }
        if (!Objects.equals(this.fecha_fin, other.fecha_fin)) {
            return false;
        }
        return true;
    }
    
    


}
