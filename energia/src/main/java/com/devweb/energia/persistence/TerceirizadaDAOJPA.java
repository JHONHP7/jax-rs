package com.devweb.energia.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.devweb.energia.dao.TerceirizadaDAO;
import com.devweb.energia.model.Terceirizada;
import com.devweb.energia.util.UtilJPA;

public class TerceirizadaDAOJPA implements TerceirizadaDAO {

	private EntityManager em;


	@Override
	public List<Terceirizada> findAll() {
		em = UtilJPA.getEm();
		List<Terceirizada> terceirizadas = em.createQuery("SELECT t FROM Terceirizada t", Terceirizada.class)
				.getResultList();
		em.close();
		return terceirizadas;
	}

	@Override
	public void delete(Long id) {
		em = UtilJPA.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Terceirizada terceirizada = em.find(Terceirizada.class, id);
		if (terceirizada != null) {
			em.remove(terceirizada);
		}
		et.commit();
		em.close();
	}

	@Override
	public void update(Terceirizada terceirizada) {
		em = UtilJPA.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(terceirizada);
		et.commit();
		em.close();
	}

	@Override
	public void save(Terceirizada terceirizada) {
		em = UtilJPA.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(terceirizada);
		et.commit();
		em.close();
	}

	@Override
	public Terceirizada findById(Long id) {
		em = UtilJPA.getEm();
		Terceirizada terceirizada = em.find(Terceirizada.class, id);
		em.close();
		return terceirizada;
	}

	@Override
	public Terceirizada findByCity(String city) {
		em = UtilJPA.getEm();
		Terceirizada terceirizada = em
				.createQuery("SELECT t FROM Terceirizada t WHERE t.cidade = :city", Terceirizada.class)
				.setParameter("city", city).getSingleResult();
		em.close();
		return terceirizada;
	}

	@Override
	public List<Terceirizada> findByName(String name) {
		em = UtilJPA.getEm();
		List<Terceirizada> terceirizadas = em
				.createQuery("SELECT t FROM Terceirizada t WHERE t.nome = :name", Terceirizada.class)
				.setParameter("name", name).getResultList();
		em.close();
		return terceirizadas;
	}

	@Override
	public List<Terceirizada> findByTeam(Long teamId) {
		em = UtilJPA.getEm();
		List<Terceirizada> terceirizadas = em
				.createQuery("SELECT t FROM Terceirizada t JOIN t.equipes e WHERE e.codigo = :teamId",
						Terceirizada.class)
				.setParameter("teamId", teamId).getResultList();
		em.close();
		return terceirizadas;
	}

}
