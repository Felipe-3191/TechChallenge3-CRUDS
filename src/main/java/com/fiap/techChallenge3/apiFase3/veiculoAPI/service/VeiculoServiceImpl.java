package com.fiap.techChallenge3.apiFase3.veiculoAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techChallenge3.apiFase3.model.Veiculo;
import com.fiap.techChallenge3.apiFase3.veiculoAPI.dto.VeiculoDTO;
import com.fiap.techChallenge3.apiFase3.veiculoAPI.repository.VeiculoRepository;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    @Override
    public VeiculoDTO buscaVeiculo(String placa) {
        Veiculo veiculo = repository.findByPlaca(placa);
        VeiculoDTO response = new VeiculoDTO(veiculo);
        return response;
    }

    @Override
    public VeiculoDTO buscaVeiculoId(Long id) {
        return new VeiculoDTO(repository.findById(id).get());
    }

    @Override
    public VeiculoDTO salvarVeiculo(VeiculoDTO veiculoDto) {
        Veiculo veiculo = new Veiculo(veiculoDto);
        veiculo = repository.save(veiculo);
        VeiculoDTO response = new VeiculoDTO(veiculo);
        return response;
    }

    @Override
    public VeiculoDTO atualizarVeiculo(VeiculoDTO veiculoDto) {
        Veiculo veiculo = new Veiculo(veiculoDto);
        veiculo = repository.save(veiculo);
        VeiculoDTO response = new VeiculoDTO(veiculo);
        return response;
    }

    @Override
    public void deletarVeiculo(Long id) {

        repository.deleteById(id);
    }
}
