package com.devweb.energia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@DiscriminatorValue("VITAL")
@NamedQueries({
        @NamedQuery(name = "ClienteVital.findByPrioridade", query = "SELECT c FROM ClienteVital c WHERE c.prioridade = :prioridade") })
@XmlRootElement
public class ClienteVital extends Cliente {

    @Column(nullable = false)
    private int tempoMaximoSemEnergia;

    @Min(1)
    @Max(3)
    @Column(nullable = false)
    private int prioridade;

    public ClienteVital() {
        
    }

    public ClienteVital(Long id, String cpf, String nome, String endereco, List<OrdemServico> ordensServico,
                        int tempoMaximoSemEnergia, @Min(1) @Max(3) int prioridade) {
        super(id, cpf, nome, endereco, ordensServico);
        this.tempoMaximoSemEnergia = tempoMaximoSemEnergia;
        this.prioridade = prioridade;
    }

    public ClienteVital(Long id, String cpf, String nome, String endereco, List<OrdemServico> ordensServico) {
        super(id, cpf, nome, endereco, ordensServico);
    }

    public int getTempoMaximoSemEnergia() {
        return tempoMaximoSemEnergia;
    }

    public void setTempoMaximoSemEnergia(int tempoMaximoSemEnergia) {
        this.tempoMaximoSemEnergia = tempoMaximoSemEnergia;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
