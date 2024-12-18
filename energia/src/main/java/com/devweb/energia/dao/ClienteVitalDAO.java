package com.devweb.energia.dao;

import com.devweb.energia.model.ClienteVital;
import java.util.ArrayList;
import java.util.List;

public class ClienteVitalDAO {

    // Simulação de um banco de dados em memória
    private static List<ClienteVital> clientesVitais = new ArrayList<>();

    // Método para adicionar um ClienteVital
    public void save(ClienteVital clienteVital) {
        clientesVitais.add(clienteVital);
    }

    // Método para atualizar um ClienteVital
    public void update(String cpf, ClienteVital clienteVital) {
        for (int i = 0; i < clientesVitais.size(); i++) {
            ClienteVital c = clientesVitais.get(i);
            if (c.getCpf().equals(cpf)) {
                clientesVitais.set(i, clienteVital);
                return;
            }
        }
    }

    // Método para deletar um ClienteVital
    public void delete(String cpf) {
        clientesVitais.removeIf(clienteVital -> clienteVital.getCpf().equals(cpf));
    }

    // Método para encontrar todos os ClienteVital
    public List<ClienteVital> findAll() {
        return clientesVitais;
    }

    // Método para buscar ClienteVital pelo nome
    public List<ClienteVital> findByName(String nome) {
        List<ClienteVital> result = new ArrayList<>();
        for (ClienteVital c : clientesVitais) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                result.add(c);
            }
        }
        return result;
    }

    // Método para buscar ClienteVital pelo CPF
    public ClienteVital findByCpf(String cpf) {
        for (ClienteVital c : clientesVitais) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null; // Retorna null se não encontrar
    }
}