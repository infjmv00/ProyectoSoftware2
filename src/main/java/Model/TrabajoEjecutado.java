/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name="tblTrabajosEjecutados")
public class TrabajoEjecutado implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            
    @JoinColumn(name = "codigo_trabajo", nullable = false)
    @OneToOne  
    private TrabajoRealizado trabRealizado;
    
    @JoinColumn(name = "trabajadoro", nullable = false)
    @OneToOne  
    private Trabajador trabajador;

    public TrabajoRealizado getTrabRealizado() {
        return trabRealizado;
    }

    public void setTrabRealizado(TrabajoRealizado trabRealizado) {
        this.trabRealizado = trabRealizado;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.trabRealizado);
        hash = 23 * hash + Objects.hashCode(this.trabajador);
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
        final TrabajoEjecutado other = (TrabajoEjecutado) obj;
        if (!Objects.equals(this.trabRealizado, other.trabRealizado)) {
            return false;
        }
        if (!Objects.equals(this.trabajador, other.trabajador)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
