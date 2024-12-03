package com.devweb.energia.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ordem_servico")
@NamedQueries({
		@NamedQuery(name = "OrdemServico.findAbertas", query = "SELECT os FROM OrdemServico os WHERE os.dataEncerramento IS NULL"),
		@NamedQuery(name = "OrdemServico.findByPrioridade", query = "SELECT os FROM OrdemServico os WHERE os.prioridade = :prioridade") })
@XmlRootElement
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToMany(mappedBy = "ordensServico")
	private List<Cliente> clientes;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataAbertura;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEncerramento;

	@Column
	private Integer prioridade;

	@ManyToOne
	private Equipe equipeResponsavel;

	public OrdemServico() {
	}

	public OrdemServico(Long codigo, List<Cliente> clientes, Date dataAbertura, Date dataEncerramento,
			Integer prioridade, Equipe equipeResponsavel) {
		this.codigo = codigo;
		this.clientes = clientes;
		this.dataAbertura = dataAbertura;
		this.dataEncerramento = dataEncerramento;
		this.prioridade = prioridade;
		this.equipeResponsavel = equipeResponsavel;
	}

	public OrdemServico(List<Cliente> clientes, Date dataAbertura, Date dataEncerramento, Integer prioridade,
			Equipe equipeResponsavel) {
		this.clientes = clientes;
		this.dataAbertura = dataAbertura;
		this.dataEncerramento = dataEncerramento;
		this.prioridade = prioridade;
		this.equipeResponsavel = equipeResponsavel;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public Equipe getEquipeResponsavel() {
		return equipeResponsavel;
	}

	public void setEquipeResponsavel(Equipe equipeResponsavel) {
		this.equipeResponsavel = equipeResponsavel;
	}
	
	
}
