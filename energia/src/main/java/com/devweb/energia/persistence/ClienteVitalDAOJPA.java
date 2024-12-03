package com.devweb.energia.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.devweb.energia.model.ClienteVital;
import com.devweb.energia.util.UtilJPA;

public class ClienteVitalDAOJPA {

    private EntityManager em;

    public void delete(Long id) {
        em = UtilJPA.getEm();
        EntityTransaction et = em.getTransaction();
        et.begin();
        ClienteVital clienteVital = em.find(ClienteVital.class, id);
        if (clienteVital != null) {
            em.remove(clienteVital);
        }
        et.commit();
        em.close();
    }

    public List<ClienteVital> findAll() {
        em = UtilJPA.getEm();
        List<ClienteVital> clientesVitais = em.createQuery("SELECT c FROM ClienteVital c", ClienteVital.class).getResultList();
        em.close();
        return clientesVitais;
    }

    public void update(ClienteVital clienteVital) {
        em = UtilJPA.getEm();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(clienteVital);
        et.commit();
        em.close();
    }

    public void save(ClienteVital clienteVital) {
        em = UtilJPA.getEm();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(clienteVital);
        et.commit();
        em.close();
    }

    public ClienteVital findById(Long id) {
        em = UtilJPA.getEm();
        ClienteVital clienteVital = em.find(ClienteVital.class, id);
        em.close();
        return clienteVital;
    }
}
