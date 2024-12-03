package com.devweb.energia.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.devweb.energia.dao.ClienteVitalDAO;
import com.devweb.energia.model.Cliente;
import com.devweb.energia.model.ClienteVital;
import com.devweb.energia.util.UtilJPA;

public class ClienteVitalDAOJPA implements ClienteVitalDAO {

	private EntityManager em;

	@Override
	public void delete(Long id) {
		em = UtilJPA.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Cliente cliente = em.find(ClienteVital.class, id);
		if (cliente != null) {
			em.remove(cliente);
		}
		et.commit();
	}

	@Override
	public List<ClienteVital> findAll() {
		em = UtilJPA.getEm();
		List<ClienteVital> clientesVitais = em.createNamedQuery("Cliente.findAll", ClienteVital.class).getResultList();
		em.close();
		return clientesVitais;
	}

	@Override
	public void update(ClienteVital clienteVital) {
		em = UtilJPA.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(clienteVital);
		et.commit();
		em.close();
	}

	@Override
	public void save(ClienteVital clienteVital) {
		em = UtilJPA.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(clienteVital);
		et.commit();
		em.close();
	}

	@Override
	public ClienteVital findById(Long id) {
		em = UtilJPA.getEm();
		ClienteVital clienteVital = em.find(ClienteVital.class, id);
		em.close();
		return clienteVital;
	}

	@Override
	public List<ClienteVital> findByName(String nome) {
		em = UtilJPA.getEm();
		List<ClienteVital> clientes = em
				.createQuery("SELECT c FROM ClienteVital c WHERE c.nome = :nome", ClienteVital.class)
				.setParameter("nome", nome).getResultList();
		em.close();
		return clientes;
	}

	@Override
	public ClienteVital findByCpf(String cpf) {
		em = UtilJPA.getEm();
		ClienteVital clienteVital = em.createNamedQuery("Cliente.findByCPF", ClienteVital.class)
				.setParameter("cpf", cpf).getSingleResult();
		em.close();
		return clienteVital;
	}


}
