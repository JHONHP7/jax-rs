package com.devweb.energia.dao;

import com.devweb.energia.model.Terceirizada;

import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TerceirizadaDAO {

	private static List<Terceirizada> terceirizadas = new ArrayList<>();

	public List<Terceirizada> findAll() {
		return terceirizadas;
	}

	public void save(Terceirizada terceirizada) {
		terceirizadas.add(terceirizada);
	}

	public void update(String codigo, Terceirizada terceirizadaAtualizada) {
		terceirizadas.stream().filter(t -> t.getCodigo().equals(codigo)).findFirst().ifPresent(t -> {
			t.setNome(terceirizadaAtualizada.getNome());
			t.setCidade(terceirizadaAtualizada.getCidade());
			t.setNumeroAtendimentos(terceirizadaAtualizada.getNumeroAtendimentos());
		});
	}

	public void delete(String codigo) {
		terceirizadas.removeIf(t -> t.getCodigo().equals(codigo));
	}
}
