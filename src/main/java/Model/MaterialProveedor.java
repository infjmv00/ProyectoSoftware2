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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jose Maria
 */
@Entity
@Table(name="tblRoles")
public class MaterialProveedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @JoinColumn(name = "CIFpro", nullable = false)
    @OneToOne
    private Proveedor proveedor;

    @JoinColumn(name = "idmat", nullable = false)
    @OneToOne
    private Material material;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "unidades")
    private int unidades;

    @Column(name = "importe_ud")
    private float importe_unidad;

    @Column(name = "activo")
    private boolean activo;

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public float getImporte_unidad() {
        return importe_unidad;
    }

    public void setImporte_unidad(float importe_unidad) {
        this.importe_unidad = importe_unidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.proveedor);
        hash = 89 * hash + Objects.hashCode(this.material);
        hash = 89 * hash + Objects.hashCode(this.fecha);
        hash = 89 * hash + this.unidades;
        hash = 89 * hash + Float.floatToIntBits(this.importe_unidad);
        hash = 89 * hash + (this.activo ? 1 : 0);
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
        final MaterialProveedor other = (MaterialProveedor) obj;
        if (this.unidades != other.unidades) {
            return false;
        }
        if (Float.floatToIntBits(this.importe_unidad) != Float.floatToIntBits(other.importe_unidad)) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        if (!Objects.equals(this.proveedor, other.proveedor)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    
    
}
