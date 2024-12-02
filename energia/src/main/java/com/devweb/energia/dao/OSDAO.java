package com.devweb.energia.dao;

import com.devweb.energia.model.OS;

import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class OSDAO {

	private static List<OS> ordensServico = new ArrayList<>();

	public List<OS> findAll() {
		return ordensServico;
	}

	public void save(OS os) {
		ordensServico.add(os);
	}

	public void update(String codigo, OS osAtualizado) {
		ordensServico.stream().filter(os -> os.getCodigo().equals(codigo)).findFirst().ifPresent(os -> {
			os.setDataAbertura(osAtualizado.getDataAbertura());
			os.setDataEncerramento(osAtualizado.getDataEncerramento());
			os.setCodigoPrioridade(osAtualizado.getCodigoPrioridade());
		});
	}

	public void delete(String codigo) {
		ordensServico.removeIf(os -> os.getCodigo().equals(codigo));
	}
}
