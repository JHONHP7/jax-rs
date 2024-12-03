package com.devweb.energia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "terceirizadas")
@XmlRootElement
public class Terceirizada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cidade;

    @Column(nullable = false)
    private int numeroAtendimentos;

    @OneToMany
    private List<Equipe> equipes;

    public Terceirizada(Long codigo, String nome, String cidade, int numeroAtendimentos, List<Equipe> equipes) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
        this.numeroAtendimentos = numeroAtendimentos;
        this.equipes = equipes;
    }

    public Terceirizada(String nome, String cidade, int numeroAtendimentos, List<Equipe> equipes) {
        this.nome = nome;
        this.cidade = cidade;
        this.numeroAtendimentos = numeroAtendimentos;
        this.equipes = equipes;
    }

    public Terceirizada() {
    }

    public Terceirizada(Long codigo, String nome, String cidade, int numeroAtendimentos) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
        this.numeroAtendimentos = numeroAtendimentos;
    }

    public Terceirizada(String nome, String cidade, int numeroAtendimentos) {
        this.nome = nome;
        this.cidade = cidade;
        this.numeroAtendimentos = numeroAtendimentos;
    }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
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
