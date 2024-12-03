package com.devweb.energia.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.devweb.energia.model.Cliente;
import com.devweb.energia.util.UtilJPA;

public class ClienteDAOJPA {

    private EntityManager em;

    public List<Cliente> findAll() {
        em = UtilJPA.getEm();
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        em.close();
        return clientes;
    }

    public void delete(Long id) {
        em = UtilJPA.getEm();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) { em.remove(cliente); }
        et.commit();
        em.close();
    }

    public void save(Cliente cliente) {
        em = UtilJPA.getEm();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(cliente);
        et.commit();
        em.close();
    }

    public Cliente findById(Long id) {
        em = UtilJPA.getEm();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return cliente;
    }

    public void update(Cliente cliente) {
        em = UtilJPA.getEm();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(cliente);
        et.commit();
        em.close();
    }
}
