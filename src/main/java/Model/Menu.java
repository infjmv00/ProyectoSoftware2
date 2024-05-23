/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;
import javax.persistence.Column;
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

@Table(name="tblMenu")
public class Menu implements Serializable {
   
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenu;
    
    @Column(name="nombre")
    private String nombre;
    
    @JoinColumn(name="tipo")
    @ManyToOne    
    private Rol tipo;
    
    @Column(name="codigo_submenu")
    private int codigo_submenu;
    
    @JoinColumn(name="codigo_submenu")
    @ManyToOne
    private Menu submenu;
    
    @Column(name="estado")
    private boolean estado;
    
    
    
    /*
    `idMenu` int NOT NULL AUTO_INCREMENT,
  `idRol` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `tipo` enum('S','I') DEFAULT NULL,
  `codigo_submenu` int DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  PRIMARY KEY (`idMenu`),
  KEY `FK_tblmenu_tblRoles` (`idRol`),
  KEY `FK_Menu_Item` (`codigo_submenu`),
  CONSTRAINT `FK_Menu_Item` FOREIGN KEY (`codigo_submenu`) REFERENCES `tblMenu` (`idMenu`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_tblmenu_tblRoles` FOREIGN KEY (`idRol`) REFERENCES `tblroles` (`IdRol`)
    */

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getTipo() {
        return tipo;
    }

    public void setTipo(Rol tipo) {
        this.tipo = tipo;
    }

    public int getCodigo_submenu() {
        return codigo_submenu;
    }

    public void setCodigo_submenu(int codigo_submenu) {
        this.codigo_submenu = codigo_submenu;
    }

    public Menu getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Menu submenu) {
        this.submenu = submenu;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.idMenu;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.tipo);
        hash = 61 * hash + this.codigo_submenu;
        hash = 61 * hash + Objects.hashCode(this.submenu);
        hash = 61 * hash + (this.estado ? 1 : 0);
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
        final Menu other = (Menu) obj;
        if (this.idMenu != other.idMenu) {
            return false;
        }
        if (this.codigo_submenu != other.codigo_submenu) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.submenu, other.submenu)) {
            return false;
        }
        return true;
    }
    
}
