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
}
