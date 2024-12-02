package com.devweb.energia.dao;

import com.devweb.energia.model.Equipe;

import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class EquipeDAO {

	private static List<Equipe> equipes = new ArrayList<>();

	public List<Equipe> findAll() {
		return equipes;
	}

	public void save(Equipe equipe) {
		equipes.add(equipe);
	}

	public void update(String codigo, Equipe equipeAtualizada) {
		equipes.stream().filter(equipe -> equipe.getCodigo().equals(codigo)).findFirst().ifPresent(equipe -> {
			equipe.setQuantidadeFuncionarios(equipeAtualizada.getQuantidadeFuncionarios());
		});
	}

	public void delete(String codigo) {
		equipes.removeIf(equipe -> equipe.getCodigo().equals(codigo));
	}
}
