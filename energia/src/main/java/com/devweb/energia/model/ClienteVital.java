package com.devweb.energia.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteVital extends Cliente {

    private int tempoMaximoSemEnergia;
    private int codigoPrioridade;
    private List<OS> ordensServico;

    public int getTempoMaximoSemEnergia() {
        return tempoMaximoSemEnergia;
    }

    public void setTempoMaximoSemEnergia(int tempoMaximoSemEnergia) {
        this.tempoMaximoSemEnergia = tempoMaximoSemEnergia;
    }

    public int getCodigoPrioridade() {
        return codigoPrioridade;
    }

    public void setCodigoPrioridade(int codigoPrioridade) {
        this.codigoPrioridade = codigoPrioridade;
    }

    public List<OS> getOrdensServico() {
        return ordensServico;
    }

    public void setOrdensServico(List<OS> ordensServico) {
        this.ordensServico = ordensServico;
    }
}
