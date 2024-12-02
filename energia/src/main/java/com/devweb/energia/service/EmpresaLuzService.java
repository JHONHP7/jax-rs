package com.devweb.energia.service;

import java.util.List;

import com.devweb.energia.dao.ClienteDAO;
import com.devweb.energia.dao.ClienteVitalDAO; // Importando o DAO do ClienteVital
import com.devweb.energia.dao.EquipeDAO;
import com.devweb.energia.dao.OSDAO;
import com.devweb.energia.dao.TerceirizadaDAO;
import com.devweb.energia.model.Cliente;
import com.devweb.energia.model.ClienteVital; // Importando o modelo ClienteVital
import com.devweb.energia.model.Equipe;
import com.devweb.energia.model.OS;
import com.devweb.energia.model.Terceirizada;

public class EmpresaLuzService {

    private ClienteDAO clienteDAO;
    private OSDAO osDAO;
    private EquipeDAO equipeDAO;
    private TerceirizadaDAO terceirizadaDAO;
    private ClienteVitalDAO clienteVitalDAO; // Declaração do ClienteVitalDAO

    public EmpresaLuzService() {
        this.clienteDAO = new ClienteDAO();
        this.osDAO = new OSDAO();
        this.equipeDAO = new EquipeDAO();
        this.terceirizadaDAO = new TerceirizadaDAO();
        this.clienteVitalDAO = new ClienteVitalDAO(); // Inicializando o ClienteVitalDAO
    }

    // Métodos de Cliente
    public List<Cliente> listarClientes() {
        return clienteDAO.findAll();
    }

    public boolean adicionarCliente(Cliente cliente) {
        for (Cliente c : clienteDAO.findAll()) {
            if (c.getCpf().equals(cliente.getCpf())) {
                return false;
            }
        }
        clienteDAO.save(cliente);
        return true;
    }

    public void atualizarCliente(String cpf, Cliente cliente) {
        clienteDAO.update(cpf, cliente);
    }

    public void removerCliente(String cpf) {
        clienteDAO.delete(cpf);
    }

    public List<Cliente> buscarPorNome(String nome) {
        return clienteDAO.findByName(nome);
    }

    // Métodos de ClienteVital
    public List<ClienteVital> listarClientesVitais() {
        return clienteVitalDAO.findAll();
    }

    public boolean adicionarClienteVital(ClienteVital clienteVital) {
        // Verifica se o ClienteVital já existe
        for (ClienteVital c : clienteVitalDAO.findAll()) {
            if (c.getCpf().equals(clienteVital.getCpf())) {
                return false; // Cliente já existe
            }
        }
        clienteVitalDAO.save(clienteVital); // Salva o ClienteVital
        return true; // ClienteVital adicionado com sucesso
    }

    public boolean atualizarClienteVital(String cpf, ClienteVital clienteVital) {
        // Verifica se o ClienteVital existe
        if (clienteVitalDAO.findByCpf(cpf) == null) {
            return false; // ClienteVital não encontrado
        }
        clienteVitalDAO.update(cpf, clienteVital); // Atualiza o ClienteVital
        return true;
    }

    public void removerClienteVital(String cpf) {
        clienteVitalDAO.delete(cpf);
    }

    public List<ClienteVital> buscarClienteVitalPorNome(String nome) {
        return clienteVitalDAO.findByName(nome);
    }

    // Métodos de Ordem de Serviço (OS)
    public List<OS> listarOrdens() {
        return osDAO.findAll();
    }

    public void adicionarOS(OS os) {
        osDAO.save(os);
    }

    public void atualizarOS(String codigo, OS os) {
        osDAO.update(codigo, os);
    }

    public void removerOS(String codigo) {
        osDAO.delete(codigo);
    }

    // Métodos de Equipe
    public List<Equipe> listarEquipes() {
        return equipeDAO.findAll();
    }

    public void adicionarEquipe(Equipe equipe) {
        equipeDAO.save(equipe);
    }

    public void atualizarEquipe(String codigo, Equipe equipe) {
        equipeDAO.update(codigo, equipe);
    }

    public void removerEquipe(String codigo) {
        equipeDAO.delete(codigo);
    }

    // Métodos de Terceirizada
    public List<Terceirizada> listarTerceirizadas() {
        return terceirizadaDAO.findAll();
    }

    public void adicionarTerceirizada(Terceirizada terceirizada) {
        terceirizadaDAO.save(terceirizada);
    }

    public void atualizarTerceirizada(String codigo, Terceirizada terceirizada) {
        terceirizadaDAO.update(codigo, terceirizada);
    }

    public void removerTerceirizada(String codigo) {
        terceirizadaDAO.delete(codigo);
    }
}
