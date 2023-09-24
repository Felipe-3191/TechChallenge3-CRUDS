package com.fiap.techChallenge3.apiFase3.condutorAPI.service;

import com.fiap.techChallenge3.apiFase3.condutorAPI.dto.CondutorBuscarTodosDTO;
import com.fiap.techChallenge3.apiFase3.condutorAPI.dto.CondutorBuscarTodosMinDTO;
import com.fiap.techChallenge3.apiFase3.condutorAPI.projections.CondutorBuscarTodosProjection;
import com.fiap.techChallenge3.apiFase3.condutorAPI.repository.CondutorRepository;
import com.fiap.techChallenge3.apiFase3.model.Condutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class CondutorService {

    private CondutorRepository repository;

    @Autowired
    public CondutorService(CondutorRepository repository) {
        this.repository = repository;
    }


    public Page<CondutorBuscarTodosMinDTO> buscarTodosOsCondutoresMin(Pageable page) {
        Page<CondutorBuscarTodosProjection> condutoresProjection =  this.repository.buscarTodosMin(page);
        return condutoresProjection.map(CondutorBuscarTodosMinDTO::new);

    }


    public Page<CondutorBuscarTodosDTO> buscarTodosOsCondutores(Pageable page) {
        Page<Condutor> condutores =  this.repository.findAll(page);
        return condutores.map(CondutorBuscarTodosDTO::new);

    }
}
