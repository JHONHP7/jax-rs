package com.devweb.energia.dao;

import java.util.List;

import com.devweb.energia.model.Terceirizada;

public interface TerceirizadaDAO {

	public void delete(Long id);

	public void update(Terceirizada terceirizada);

	public void save(Terceirizada terceirizada);

	public Terceirizada findById(Long id);

	public Terceirizada findByCity(String city);

	public List<Terceirizada> findByName(String name);

	public List<Terceirizada> findByTeam(Long teamId);

	public List<Terceirizada> findAll();
}
