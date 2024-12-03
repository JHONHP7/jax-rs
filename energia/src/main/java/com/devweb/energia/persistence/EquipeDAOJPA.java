package com.devweb.energia.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.devweb.energia.dao.EquipeDAO;
import com.devweb.energia.model.Equipe;
import com.devweb.energia.model.Terceirizada;
import com.devweb.energia.util.UtilJPA;

public class EquipeDAOJPA implements EquipeDAO{

	
	private EntityManager em;


    @Override
    public List<Equipe> findAll() {
		em = UtilJPA.getEm();
        List<Equipe> equipes = em.createQuery("SELECT e FROM Equipe e", Equipe.class).getResultList();
        em.close();
        return equipes;
    }
    
    @Override
    public void delete(Long id) {
        em = UtilJPA.getEm();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Equipe equipe = em.find(Equipe.class, id);
        if (equipe != null) { em.remove(equipe); }
        et.commit();
        em.close();
    }

    @Override
    public void update(Equipe equipe) {
        em = UtilJPA.getEm();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(equipe);
        et.commit();
        em.close();
    }

    @Override
    public void save(Equipe equipe) {
        em = UtilJPA.getEm();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(equipe);
        et.commit();
        em.close();
    }

    @Override
    public Equipe findById(Long id) {
        em = UtilJPA.getEm();
        Equipe equipe = em.find(Equipe.class, id);
        em.close();
        return equipe;
    }

    @Override
    public Equipe findByTerceirizada(Terceirizada terceirizada) {
        em = UtilJPA.getEm();
        Equipe equipe = em.createQuery("SELECT e FROM Equipe e WHERE e.terceirizada = :terceirizada", Equipe.class)
                .setParameter("terceirizada", terceirizada)
                .getSingleResult();
        em.close();
        return equipe;
    }



}