/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.modelo.Transaccion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author juan
 */
@Stateless
public class TransaccionManager implements TransaccionManagerLocal {

    @PersistenceContext(unitName = "com.udea_PasarelaPagos-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @Override
    public List<Transaccion> getTransacciones() {
        Query query = em.createNamedQuery("Transaccion.findAll");
        return query.getResultList();
    }

    @Override
    public void guardarTransaccion(Transaccion transaccion) {
        try {
            em.persist(transaccion);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    
}
