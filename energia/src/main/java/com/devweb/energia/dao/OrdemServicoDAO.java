package com.devweb.energia.dao;

import java.util.List;

import com.devweb.energia.model.OrdemServico;

public interface OrdemServicoDAO {

    public void delete(Long id);

    public void update(OrdemServico ordemServico);

    public void save(OrdemServico ordemServico);

    public OrdemServico findById(Long id);

    public List<OrdemServico> findByPriority(int priority);

    public List<OrdemServico> findAll();
}

