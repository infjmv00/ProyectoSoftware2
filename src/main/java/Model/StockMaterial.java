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
@Table(name="tblStockMateriales")
public class StockMaterial implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int IdStock;
    
    @JoinColumn(name = "IdMaterial", nullable = false)
    @OneToOne
    private Material material;
    
    
    @Column(name = "cantidadReal")
    private int cantidadReal;
    
    @Column(name = "CantidadPteRecibir")
    private int CantidadPteRecibir;
    
    @Column(name = "cantidadTotal")
    private int cantidadTotal;

    public int getIdStock() {
        return IdStock;
    }

    public void setIdStock(int IdStock) {
        this.IdStock = IdStock;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getCantidadReal() {
        return cantidadReal;
    }

    public void setCantidadReal(int cantidadReal) {
        this.cantidadReal = cantidadReal;
    }

    public int getCantidadPteRecibir() {
        return CantidadPteRecibir;
    }

    public void setCantidadPteRecibir(int CantidadPteRecibir) {
        this.CantidadPteRecibir = CantidadPteRecibir;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.IdStock;
        hash = 79 * hash + Objects.hashCode(this.material);
        hash = 79 * hash + this.cantidadReal;
        hash = 79 * hash + this.CantidadPteRecibir;
        hash = 79 * hash + this.cantidadTotal;
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
        final StockMaterial other = (StockMaterial) obj;
        if (this.IdStock != other.IdStock) {
            return false;
        }
        if (this.cantidadReal != other.cantidadReal) {
            return false;
        }
        if (this.CantidadPteRecibir != other.CantidadPteRecibir) {
            return false;
        }
        if (this.cantidadTotal != other.cantidadTotal) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
}
