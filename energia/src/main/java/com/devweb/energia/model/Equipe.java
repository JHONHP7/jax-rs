package com.devweb.energia.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Equipe {

    private String codigo;
    private Terceirizada terceirizadaResponsavel; // Relacionamento com Terceirizada
    private int quantidadeFuncionarios;
    private List<OS> ordensAtendidas; // Relacionamento com OSs

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Terceirizada getTerceirizadaResponsavel() {
        return terceirizadaResponsavel;
    }

    public void setTerceirizadaResponsavel(Terceirizada terceirizadaResponsavel) {
        this.terceirizadaResponsavel = terceirizadaResponsavel;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public List<OS> getOrdensAtendidas() {
        return ordensAtendidas;
    }

    public void setOrdensAtendidas(List<OS> ordensAtendidas) {
        this.ordensAtendidas = ordensAtendidas;
    }
}
