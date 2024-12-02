package com.devweb.energia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.devweb.energia.model.Cliente;

import jakarta.inject.Singleton;
@Singleton
public class ClienteDAO {
    private static List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> findAll() {
        return clientes;
    }

	public void save(Cliente cliente) {
		clientes.add(cliente);
	}

	public void update(String cpf, Cliente clienteAtualizado) {
		Optional<Cliente> clienteExistente = clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf))
				.findFirst();

		clienteExistente.ifPresent(cliente -> {
			cliente.setNome(clienteAtualizado.getNome());
			cliente.setEndereco(clienteAtualizado.getEndereco());
		});
	}

	public void delete(String cpf) {
		clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));
	}

	public List<Cliente> findByName(String nome) {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) { 
            if (cliente.getNome().contains(nome)) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }
}
