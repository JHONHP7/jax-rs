package com.devweb.energia.dao;

import java.util.List;

import com.devweb.energia.model.Equipe;
import com.devweb.energia.model.Terceirizada;

public interface EquipeDAO {

	public void save(Equipe equipe);

	public void update(Equipe equipe);

	public void delete(Long id);

    public Equipe findById(Long id);

    public Equipe findByTerceirizada(Terceirizada terceirizada);

    public List<Equipe> findAll();
}
