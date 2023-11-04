package com.fiap.techChallenge3.apiFase3.condutorAPI.service;

import java.util.Optional;

import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiap.techChallenge3.apiFase3.condutorAPI.dto.CondutorBuscarTodosDTO;
import com.fiap.techChallenge3.apiFase3.condutorAPI.dto.CondutorBuscarTodosMinDTO;
import com.fiap.techChallenge3.apiFase3.condutorAPI.dto.CondutorDTO;
import com.fiap.techChallenge3.apiFase3.condutorAPI.projections.CondutorBuscarTodosProjection;
import com.fiap.techChallenge3.apiFase3.condutorAPI.repository.CondutorRepository;
import com.fiap.techChallenge3.apiFase3.model.Condutor;

@Service
public class CondutorService {

    private final CondutorRepository repository;

    @Autowired
    public CondutorService(CondutorRepository repository) {
        this.repository = repository;
    }

    public Page<CondutorBuscarTodosMinDTO> buscarTodosOsCondutoresMin(Pageable page) {
        Page<CondutorBuscarTodosProjection> condutoresProjection = this.repository.buscarTodosMin(page);
        return condutoresProjection.map(CondutorBuscarTodosMinDTO::new);

    }

    public Page<CondutorBuscarTodosDTO> buscarTodosOsCondutores(Pageable page) {
        Page<Condutor> condutores = this.repository.findAll(page);
        return condutores.map(CondutorBuscarTodosDTO::new);
    }

    public CondutorDTO salvarCondutor(CondutorDTO condutorDTO) {
        try {
            Condutor condutorSalvo = new Condutor(condutorDTO);
            condutorSalvo = repository.save(condutorSalvo);
            CondutorDTO response = new CondutorDTO(condutorSalvo);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar condutor");
        }
    }
    public CondutorDTO atualizarCondutor(CondutorDTO condutorDTO) {
        if(condutorDTO.getId() == null) {
            throw new RuntimeException("Necessário passar o id do condutor");
        }
            try {
                Condutor condutorSalvo = new Condutor(condutorDTO);
                condutorSalvo = repository.save(condutorSalvo);
                CondutorDTO response = new CondutorDTO(condutorSalvo);
                return response;
            } catch (Exception e) {
                throw new RuntimeException("Erro ao atualizar condutor");
            }
    }

    public void deletarCondutor(Long id) {
        try {
            Optional<Condutor> condutor = repository.findById(id);
            if (condutor.isEmpty()) {
                throw new RuntimeException("Condutor não encontrado");
            }
            repository.delete(condutor.get());
        } catch (SqlScriptException e) {
            throw new RuntimeException("Erro ao deletar condutor");
        }
    }

}
