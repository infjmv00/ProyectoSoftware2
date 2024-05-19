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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jose Maria
 */
@Entity
@Table(name="tblMaterialUsado")
public class MaterialUsado implements Serializable {
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        
   @JoinColumn(name = "cod_trabajo", nullable = false)
    @ManyToOne    
    private TrabajoRealizado trabRealizado;
    
    @JoinColumn(name = "code_material", nullable = false)
    @ManyToOne   
    private Material material;
    
    @Column(name = "unidades")
    private int unidades;
    
    @Column(name = "uso_desgaste")
    private boolean uso_desgaste;
    
    @Column(name = "desgastado")
    private boolean desgastado;

    public TrabajoRealizado getTrabRealizado() {
        return trabRealizado;
    }

    public void setTrabRealizado(TrabajoRealizado trabRealizado) {
        this.trabRealizado = trabRealizado;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public boolean isUso_desgaste() {
        return uso_desgaste;
    }

    public void setUso_desgaste(boolean uso_desgaste) {
        this.uso_desgaste = uso_desgaste;
    }

    public boolean isDesgastado() {
        return desgastado;
    }

    public void setDesgastado(boolean desgastado) {
        this.desgastado = desgastado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.trabRealizado);
        hash = 53 * hash + Objects.hashCode(this.material);
        hash = 53 * hash + this.unidades;
        hash = 53 * hash + (this.uso_desgaste ? 1 : 0);
        hash = 53 * hash + (this.desgastado ? 1 : 0);
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
        final MaterialUsado other = (MaterialUsado) obj;
        if (this.unidades != other.unidades) {
            return false;
        }
        if (this.uso_desgaste != other.uso_desgaste) {
            return false;
        }
        if (this.desgastado != other.desgastado) {
            return false;
        }
        if (!Objects.equals(this.trabRealizado, other.trabRealizado)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
