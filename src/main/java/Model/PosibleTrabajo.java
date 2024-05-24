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
@Table(name="tblPosiblesTrabajos")

public class PosibleTrabajo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tarea;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activoTrabajo")
    private boolean activoTrabajo;

    @Column(name = "importeUd")
    private float importeUd;

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivoTrabajo() {
        return activoTrabajo;
    }

    public void setActivoTrabajo(boolean activoTrabajo) {
        this.activoTrabajo = activoTrabajo;
    }

    public float getImporteUd() {
        return importeUd;
    }

    public void setImporteUd(float importeUd) {
        this.importeUd = importeUd;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_tarea;
        hash = 29 * hash + Objects.hashCode(this.descripcion);
        hash = 29 * hash + (this.activoTrabajo ? 1 : 0);
        hash = 29 * hash + Float.floatToIntBits(this.importeUd);
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
        final PosibleTrabajo other = (PosibleTrabajo) obj;
        if (this.id_tarea != other.id_tarea) {
            return false;
        }
        if (this.activoTrabajo != other.activoTrabajo) {
            return false;
        }
        if (Float.floatToIntBits(this.importeUd) != Float.floatToIntBits(other.importeUd)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }
    
    
        

}
