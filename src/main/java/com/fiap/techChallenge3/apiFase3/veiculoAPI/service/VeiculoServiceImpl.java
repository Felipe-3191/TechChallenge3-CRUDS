package com.fiap.techChallenge3.apiFase3.veiculoAPI.service;

import java.util.Optional;

import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.fiap.techChallenge3.apiFase3.condutorAPI.repository.CondutorRepository;
import com.fiap.techChallenge3.apiFase3.model.Condutor;
import com.fiap.techChallenge3.apiFase3.model.Veiculo;
import com.fiap.techChallenge3.apiFase3.veiculoAPI.dto.VeiculoDTO;
import com.fiap.techChallenge3.apiFase3.veiculoAPI.repository.VeiculoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository repository;
    @Autowired
    private CondutorRepository condutorRepository;

    @Override
    public VeiculoDTO buscaVeiculo(String placa) {
        try {
            Optional<Veiculo> veiculo = repository.findByPlaca(placa);
            if (veiculo.isEmpty()) {
                throw new RuntimeException("Veiculo não encontrado");
            }
            VeiculoDTO response = new VeiculoDTO(veiculo.get());
            return response;
        } catch (SqlScriptException e) {
            throw new RuntimeException("Erro ao buscar placa");
        }
    }

    @Override
    public VeiculoDTO buscaVeiculoId(Long id) {
        try {
            Optional<Veiculo> veiculo = repository.findById(id);
            if (veiculo.isEmpty()) {
                throw new RuntimeException("Veiculo não encontrado");
            }
            return new VeiculoDTO(repository.findById(id).get());
        } catch (SqlScriptException e) {
            throw new RuntimeException("Erro ao buscar id");
        }
    }

    @Override
    public VeiculoDTO salvarVeiculo(VeiculoDTO veiculoDto) {
        try {
            Veiculo veiculo = new Veiculo(veiculoDto);
            Condutor condutor = condutorRepository.getReferenceById(veiculoDto.getIdCondutor());
            veiculo.setCondutor(condutor);
            veiculo = repository.save(veiculo);
            VeiculoDTO response = new VeiculoDTO(veiculo);
            return response;
        }catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao salvar veiculo, condutor não existe");
        }catch (Exception e) {
            throw new RuntimeException("Erro ao salvar veiculo");
        }
    }

    @Override
    public VeiculoDTO atualizarVeiculo(VeiculoDTO veiculoDto) {
        try {
            Veiculo veiculo = new Veiculo(veiculoDto);
            veiculo = repository.save(veiculo);
            VeiculoDTO response = new VeiculoDTO(veiculo);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar veiculo");
        }
    }

    @Override
    public void deletarVeiculo(Long id) {
        try {
            Optional<Veiculo> veiculo = repository.findById(id);
            if (veiculo.isEmpty()) {
                throw new RuntimeException("Veiculo não encontrado");
            }
            repository.delete(veiculo.get());
        } catch (SqlScriptException e) {
            throw new RuntimeException("Erro ao deletar veiculo");
        }
    }
}
