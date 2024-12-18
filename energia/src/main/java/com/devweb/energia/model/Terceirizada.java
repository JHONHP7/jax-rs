package com.devweb.energia.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Terceirizada {

	private String codigo;
	private String nome;
	private String cidade;
	private int numeroAtendimentos;
	private List<Equipe> equipes;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getNumeroAtendimentos() {
		return numeroAtendimentos;
	}

	public void setNumeroAtendimentos(int numeroAtendimentos) {
		this.numeroAtendimentos = numeroAtendimentos;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
}
