/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.Trabajador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jose Maria
 */
@Stateless
public class TrabajadorFacade extends AbstractFacade<Trabajador> implements TrabajadorFacadeLocal {

    @PersistenceContext(unitName = "GestionEmpresarialGE")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajadorFacade() {
        super(Trabajador.class);
    }
    
    @Override
    public Trabajador iniciarSesion(Trabajador trab){
        Trabajador trabajador = null;
        
        String consulta;
        
        try{
            consulta = "FROM Trabajador t WHERE  t.usuario =?1 and t.contrasenya=?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, trab.getUsuario());
            query.setParameter(2, trab.getContrasenya());
            List<Trabajador> lista = query.getResultList();
            
            if(!lista.isEmpty()){
                
                trabajador = lista.get(0);
            } 
        } catch(Exception e){
            throw e;
        } 
        return trabajador;
    }

    @Override
    public List<Trabajador> BuscarTelefonoAdministrador(int codigoTrabajador) throws Exception {
        
       
      List<Trabajador> listaAdministradores = null;
      String consulta;
      
        
        try{
           consulta = "SELECT t.telefonoTrab FROM Trabajador t WHERE t.idRol = ?1";
           Query query = em.createQuery(consulta);
           query.setParameter(1, codigoTrabajador);
           
           listaAdministradores = query.getResultList();
           
       } catch(Exception e){
           throw e;
       }
        
       
       return listaAdministradores;
    }
    
    
    
}
