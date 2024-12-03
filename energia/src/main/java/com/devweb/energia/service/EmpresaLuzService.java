package com.devweb.energia.service;

import com.devweb.energia.model.Cliente;
import com.devweb.energia.model.ClienteVital;
import com.devweb.energia.model.Equipe;
import com.devweb.energia.model.OrdemServico;
import com.devweb.energia.model.Terceirizada;
import com.devweb.energia.persistence.ClienteDAOJPA;
import com.devweb.energia.persistence.ClienteVitalDAOJPA;
import com.devweb.energia.persistence.EquipeDAOJPA;
import com.devweb.energia.persistence.OrdemServicoDAOJPA;
import com.devweb.energia.persistence.TerceirizadaDAOJPA;

import java.util.List;

public class EmpresaLuzService {

	private final ClienteDAOJPA clienteDAOJPA = new ClienteDAOJPA();
	private final ClienteVitalDAOJPA clienteVitalDAOJPA = new ClienteVitalDAOJPA();
	private final EquipeDAOJPA equipeDAOJPA = new EquipeDAOJPA();
	private final OrdemServicoDAOJPA ordemServicoDAOJPA = new OrdemServicoDAOJPA();
	private final TerceirizadaDAOJPA terceirizadaDAOJPA = new TerceirizadaDAOJPA();
/**
 * Cliente service
 * @return
 */
	public List<Cliente> getAllClientes() {
		return clienteDAOJPA.findAll();
	}

	public Cliente getClienteById(Long id) {
		return clienteDAOJPA.findById(id);
	}

	public void createCliente(Cliente cliente) {
		if (cliente != null && cliente.getCpf() != null && cliente.getNome() != null) {
			clienteDAOJPA.save(cliente);
		} else {
			throw new IllegalArgumentException("Cliente inválido");
		}
	}

	public void updateCliente(Long id, Cliente cliente) {
		Cliente existingCliente = clienteDAOJPA.findById(id);
		if (existingCliente != null) {
			if (cliente.getNome() != null)
				existingCliente.setNome(cliente.getNome());
			if (cliente.getEndereco() != null)
				existingCliente.setEndereco(cliente.getEndereco());
			if (cliente.getCpf() != null)
				existingCliente.setCpf(cliente.getCpf());
			clienteDAOJPA.update(existingCliente);
		} else {
			throw new IllegalArgumentException("Cliente não encontrado");
		}
	}

	public void deleteCliente(Long id) {
		clienteDAOJPA.delete(id);
	}

	/**
	 * ClienteVital service
	 * @return
	 */

	public List<ClienteVital> getAllClientesVitais() {
		return clienteVitalDAOJPA.findAll();
	}

	public ClienteVital getClienteVitalById(Long id) {
		return clienteVitalDAOJPA.findById(id);
	}

	public void createClienteVital(ClienteVital clienteVital) {
		if (clienteVital != null && clienteVital.getCpf() != null && clienteVital.getNome() != null) {
			clienteVitalDAOJPA.save(clienteVital);
		} else {
			throw new IllegalArgumentException("ClienteVital inválido");
		}
	}

	public void updateClienteVital(Long id, ClienteVital clienteVital) {
		ClienteVital existingClienteVital = clienteVitalDAOJPA.findById(id);
		if (existingClienteVital != null) {
			if (clienteVital.getNome() != null)
				existingClienteVital.setNome(clienteVital.getNome());
			if (clienteVital.getTempoMaximoSemEnergia() != 0)
				existingClienteVital.setTempoMaximoSemEnergia(clienteVital.getTempoMaximoSemEnergia());
			if (clienteVital.getEndereco() != null)
				existingClienteVital.setEndereco(clienteVital.getEndereco());
			if (clienteVital.getCpf() != null)
				existingClienteVital.setCpf(clienteVital.getCpf());
			clienteVitalDAOJPA.update(existingClienteVital);
		} else {
			throw new IllegalArgumentException("ClienteVital não encontrado");
		}
	}

	public void deleteClienteVital(Long id) {
		clienteVitalDAOJPA.delete(id);
	}


	/**
	 * Equipe resource
	 * @return
	 */
	public List<Equipe> getAllEquipes() {
		return equipeDAOJPA.findAll();
	}

	public Equipe getEquipeById(Long id) {
		return equipeDAOJPA.findById(id);
	}

	public void createEquipe(Equipe equipe) {
		if (equipe != null && equipe.getCodigo() != null) {
			equipeDAOJPA.save(equipe);
		} else {
			throw new IllegalArgumentException("Equipe inválida");
		}
	}

	public void updateEquipe(Long id, Equipe equipe) {
		Equipe existingEquipe = equipeDAOJPA.findById(id);
		if (existingEquipe != null) {
			if (equipe.getCodigo() != null)
				existingEquipe.setCodigo(equipe.getCodigo());
			if (equipe.getOrdensServicos() != null)
				existingEquipe.setOrdensServicos(equipe.getOrdensServicos());
			if (equipe.getQuantidadeFuncionarios() != 0)
				existingEquipe.setQuantidadeFuncionarios(equipe.getQuantidadeFuncionarios());
			if (equipe.getTerceirizada() != null)
				existingEquipe.setTerceirizada(equipe.getTerceirizada());
			equipeDAOJPA.update(existingEquipe);
		} else {
			throw new IllegalArgumentException("Equipe não encontrada");
		}
	}

	public void deleteEquipe(Long id) {
		equipeDAOJPA.delete(id);
	}


	/*
	 * OrdemService service
	 */
	public List<OrdemServico> getAllOrdensServico() {
		return ordemServicoDAOJPA.findAll();
	}

	public OrdemServico getOrdemServicoById(Long id) {
		return ordemServicoDAOJPA.findById(id);
	}

	public void createOrdemServico(OrdemServico ordemServico) {
		if (ordemServico != null) {
			ordemServicoDAOJPA.save(ordemServico);
		} else {
			throw new IllegalArgumentException("Ordem de serviço inválida");
		}
	}

	public void updateOrdemServico(Long id, OrdemServico ordemServico) {
		OrdemServico existingOrdemServico = ordemServicoDAOJPA.findById(id);
		if (existingOrdemServico != null) {
			if (ordemServico.getClientes() != null)
				existingOrdemServico.setClientes(ordemServico.getClientes());
			if (ordemServico.getDataAbertura() != null)
				existingOrdemServico.setDataAbertura(ordemServico.getDataAbertura());
			if (ordemServico.getDataEncerramento() != null)
				existingOrdemServico.setDataEncerramento(ordemServico.getDataEncerramento());
			if (ordemServico.getEquipeResponsavel() != null)
				existingOrdemServico.setEquipeResponsavel(ordemServico.getEquipeResponsavel());
			if (ordemServico.getPrioridade() != null)
				existingOrdemServico.setPrioridade(ordemServico.getPrioridade());
			if (ordemServico.getCodigo() != null)
				existingOrdemServico.setCodigo(ordemServico.getCodigo());
			ordemServicoDAOJPA.update(existingOrdemServico);
		} else {
			throw new IllegalArgumentException("Ordem de serviço não encontrada");
		}
	}

	public void deleteOrdemServico(Long id) {
		ordemServicoDAOJPA.delete(id);
	}

	/**
	 * Terceirizada service
	 * @return
	 */

	public List<Terceirizada> getAllTerceirizadas() {
		return terceirizadaDAOJPA.findAll();
	}

	public Terceirizada getTerceirizadaById(Long id) {
		return terceirizadaDAOJPA.findById(id);
	}

	public void createTerceirizada(Terceirizada terceirizada) {
		if (terceirizada != null) {
			terceirizadaDAOJPA.save(terceirizada);
		} else {
			throw new IllegalArgumentException("Terceirizada inválida");
		}
	}

	public void updateTerceirizada(Long id, Terceirizada terceirizada) {
		Terceirizada existingTerceirizada = terceirizadaDAOJPA.findById(id);
		if (existingTerceirizada != null) {
			if (terceirizada.getNome() != null)
				existingTerceirizada.setNome(terceirizada.getNome());
			if (terceirizada.getCidade() != null)
				existingTerceirizada.setCidade(terceirizada.getCidade());
			if (terceirizada.getCodigo() != null)
				existingTerceirizada.setCodigo(terceirizada.getCodigo());
			if (terceirizada.getNumeroAtendimentos() != 0)
				existingTerceirizada.setNumeroAtendimentos(terceirizada.getNumeroAtendimentos());
			if (terceirizada.getEquipes() != null)
				existingTerceirizada.setEquipes(terceirizada.getEquipes());
			terceirizadaDAOJPA.update(existingTerceirizada);
		} else {
			throw new IllegalArgumentException("Terceirizada não encontrada");
		}
	}

	public void deleteTerceirizada(Long id) {
		terceirizadaDAOJPA.delete(id);
	}
}
