package com.devweb.energia.service;

import java.util.List;

import com.devweb.energia.model.Cliente;
import com.devweb.energia.model.ClienteVital;
import com.devweb.energia.model.Equipe;
import com.devweb.energia.model.OrdemServico;
import com.devweb.energia.persistence.ClienteDAOJPA;
import com.devweb.energia.persistence.ClienteVitalDAOJPA;
import com.devweb.energia.persistence.EquipeDAOJPA;
import com.devweb.energia.persistence.OrdemServicoDAOJPA;
import com.devweb.energia.persistence.TerceirizadaDAOJPA;

/**
 * Serviço para operações relacionadas à empresa de energia.
 */
public class EmpresaLuzService {

    private final ClienteDAOJPA clienteDAOJPA = new ClienteDAOJPA();
    private final ClienteVitalDAOJPA clienteVitalDAOJPA = new ClienteVitalDAOJPA();
    private final EquipeDAOJPA equipeDAOJPA = new EquipeDAOJPA();
    private final OrdemServicoDAOJPA ordemServicoDAOJPA = new OrdemServicoDAOJPA();
    private final TerceirizadaDAOJPA terceirizadaDAOJPA = new TerceirizadaDAOJPA();

    // Métodos de Cliente
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

    // Métodos de ClienteVital
    public ClienteVital getClienteVitalById(Long id) {
        return clienteVitalDAOJPA.findById(id);
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

    // Métodos de Equipe
    public Equipe getEquipeById(Long id) {
        return equipeDAOJPA.findById(id);
    }

    // Métodos de OrdemServico
    public OrdemServico getOrdemServicoById(Long id) {
        return ordemServicoDAOJPA.findById(id);
    }

    public List<OrdemServico> getAllOrdensServico() {
        return ordemServicoDAOJPA.findAll();
    }

    public void createOrdemServico(OrdemServico ordemServico) {
        if (ordemServico != null) {
            ordemServicoDAOJPA.save(ordemServico);
        } else {
            throw new IllegalArgumentException("Ordem de serviço inválida");
        }
    }

    // Métodos de Terceirizada
    public void deleteTerceirizada(Long id) {
        terceirizadaDAOJPA.delete(id);
    }
}
