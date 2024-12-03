package com.devweb.energia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "equipes")
@XmlRootElement
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "terceirizada_id", nullable = false)
	private Terceirizada terceirizada;

	@Column(nullable = false)
	private int quantidadeFuncionarios;

	@OneToMany
	private List<OrdemServico> ordensServicos;

	public Equipe(Long codigo, Terceirizada terceirizada, int quantidadeFuncionarios,
			List<OrdemServico> ordensServicos) {
		this.codigo = codigo;
		this.terceirizada = terceirizada;
		this.quantidadeFuncionarios = quantidadeFuncionarios;
		this.ordensServicos = ordensServicos;
	}

	public Equipe(Terceirizada terceirizada, int quantidadeFuncionarios, List<OrdemServico> ordensServicos) {
		this.terceirizada = terceirizada;
		this.quantidadeFuncionarios = quantidadeFuncionarios;
		this.ordensServicos = ordensServicos;
	}

	public Equipe() {

	}

	public Equipe(Long codigo, Terceirizada terceirizada, int quantidadeFuncionarios) {
		this.codigo = codigo;
		this.terceirizada = terceirizada;
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	public Equipe(Terceirizada terceirizada, int quantidadeFuncionarios) {
		this.terceirizada = terceirizada;
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Terceirizada getTerceirizada() {
		return terceirizada;
	}

	public void setTerceirizada(Terceirizada terceirizada) {
		this.terceirizada = terceirizada;
	}

	public int getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}

	public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	public List<OrdemServico> getOrdensServicos() {
		return ordensServicos;
	}

	public void setOrdensServicos(List<OrdemServico> ordensServicos) {
		this.ordensServicos = ordensServicos;
	}

}
