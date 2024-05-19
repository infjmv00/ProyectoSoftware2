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
@Table(name="tblFacturas")
public class Factura implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int n_factura;

    @ManyToOne
    @JoinColumn(name = "id_Cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private int cantidad; 

    @Column(name = "tipo")
    private String tipo;


    @Column(name = "iva_aplicado")
    private int iva_aplicado;

    public int getN_factura() {
        return n_factura;
    }

    public void setN_factura(int n_factura) {
        this.n_factura = n_factura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIva_aplicado() {
        return iva_aplicado;
    }

    public void setIva_aplicado(int iva_aplicado) {
        this.iva_aplicado = iva_aplicado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.n_factura;
        hash = 97 * hash + Objects.hashCode(this.cliente);
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + this.cantidad;
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + this.iva_aplicado;
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
        final Factura other = (Factura) obj;
        if (this.n_factura != other.n_factura) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.iva_aplicado != other.iva_aplicado) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }
    
    


}
