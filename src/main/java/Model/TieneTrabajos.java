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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jose Maria
 */
@Entity
@Table(name="tblTieneTrabajos")
public class TieneTrabajos implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JoinColumn(name = "id_trabajo", nullable = false)
    @OneToOne
    private TrabajoRealizado trabRealizado;

    @JoinColumn(name = "codigo_tarea", nullable = false)
    @OneToOne
    private PosibleTrabajo posTrab;

    @Column(name = "importe_ud")
    private float importe_ud;

    public TrabajoRealizado getTrabRealizado() {
        return trabRealizado;
    }

    public void setTrabRealizado(TrabajoRealizado trabRealizado) {
        this.trabRealizado = trabRealizado;
    }

    public PosibleTrabajo getPosTrab() {
        return posTrab;
    }

    public void setPosTrab(PosibleTrabajo posTrab) {
        this.posTrab = posTrab;
    }

    public float getImporte_ud() {
        return importe_ud;
    }

    public void setImporte_ud(float importe_ud) {
        this.importe_ud = importe_ud;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.trabRealizado);
        hash = 83 * hash + Objects.hashCode(this.posTrab);
        hash = 83 * hash + Float.floatToIntBits(this.importe_ud);
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
        final TieneTrabajos other = (TieneTrabajos) obj;
        if (Float.floatToIntBits(this.importe_ud) != Float.floatToIntBits(other.importe_ud)) {
            return false;
        }
        if (!Objects.equals(this.trabRealizado, other.trabRealizado)) {
            return false;
        }
        if (!Objects.equals(this.posTrab, other.posTrab)) {
            return false;
        }
        return true;
    }
    
    

}
