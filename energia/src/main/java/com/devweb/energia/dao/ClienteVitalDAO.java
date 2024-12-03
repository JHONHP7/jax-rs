package com.devweb.energia.dao;

import java.util.List;

import com.devweb.energia.model.ClienteVital;

public interface ClienteVitalDAO {

    public void delete(Long id);

    public void update(ClienteVital clienteVital);

    public void save(ClienteVital clienteVital);

    public ClienteVital findById(Long id);

    public List<ClienteVital> findByName(String name);

    public ClienteVital findByCpf(String cpf);

    public List<ClienteVital> findAll();
}
