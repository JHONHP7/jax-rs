package com.devweb.energia.persistence;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.devweb.energia.dao.ClienteDAO;
import com.devweb.energia.model.Cliente;
import com.devweb.energia.util.UtilJPA;

public class ClienteDAOJPA implements ClienteDAO {

    private EntityManager em;

    @Override
    public List<Cliente> findAll() {
        em = UtilJPA.getEm();
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        em.close();
        return clientes;
    }

    @Override
    public void update(Cliente cliente) {
        em = UtilJPA.getEm();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(cliente);
        et.commit();
        em.close();
    }

    @Override
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

    @Override
    public Cliente findByCpf(String cpf) {
        em = UtilJPA.getEm();
        Cliente cliente = em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
        em.close();
        return cliente;
    }

    @Override
    public List<Cliente> findByName(String name) {
        em = UtilJPA.getEm();
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nome = :name", Cliente.class)
                .setParameter("name", name)
                .getResultList();
        em.close();
        return clientes;
    }


}
