package com.devweb.energia.dao;

import java.util.List;

import com.devweb.energia.model.Cliente;

public interface ClienteDAO {

	public void save(Cliente cliente);

	public void update(Cliente cliente);

    public void delete(Long id);

    public Cliente findByCpf(String cpf);
    
    public Cliente findById(Long id);
    
    public List<Cliente> findByName(String name);

    public List<Cliente> findAll();

}
