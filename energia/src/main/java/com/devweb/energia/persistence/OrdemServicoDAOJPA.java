package com.devweb.energia.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.devweb.energia.dao.OrdemServicoDAO;
import com.devweb.energia.model.OrdemServico;
import com.devweb.energia.util.UtilJPA;

public class OrdemServicoDAOJPA implements OrdemServicoDAO {

	private EntityManager em;

	@Override
	public void delete(Long id) {
		em = UtilJPA.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		OrdemServico ordenServico = em.find(OrdemServico.class, id);
		if (ordenServico != null) {
			em.remove(ordenServico);
		}
		et.commit();
		em.close();
	}

	@Override
	public List<OrdemServico> findAll() {
		em = UtilJPA.getEm();
		List<OrdemServico> ordensServico = em.createQuery("SELECT os FROM OrdemServico os", OrdemServico.class)
				.getResultList();
		em.close();
		return ordensServico;
	}

	@Override
	public void update(OrdemServico ordemServico) {
		em = UtilJPA.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(ordemServico);
		et.commit();
		em.close();
	}

	@Override
	public void save(OrdemServico ordemServico) {
		em = UtilJPA.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(ordemServico);
		et.commit();
		em.close();
	}

	@Override
	public OrdemServico findById(Long id) {
		em = UtilJPA.getEm();
		OrdemServico ordemServico = em.find(OrdemServico.class, id);
		em.close();
		return ordemServico;
	}

	@Override
	public List<OrdemServico> findByPriority(int priority) {
		em = UtilJPA.getEm();
		List<OrdemServico> ordensServico = em
				.createQuery("SELECT os FROM OrdemServico os WHERE os.prioridade = :priority", OrdemServico.class)
				.setParameter("priority", priority).getResultList();
		em.close();
		return ordensServico;
	}

}
