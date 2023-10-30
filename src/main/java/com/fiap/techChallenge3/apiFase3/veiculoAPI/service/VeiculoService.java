package com.fiap.techChallenge3.apiFase3.veiculoAPI.service;

import com.fiap.techChallenge3.apiFase3.veiculoAPI.dto.VeiculoDTO;

public interface VeiculoService {

    VeiculoDTO buscaVeiculo(String placa);
    VeiculoDTO buscaVeiculoId(Long id);

    VeiculoDTO salvarVeiculo(VeiculoDTO veiculo);

    VeiculoDTO atualizarVeiculo(VeiculoDTO veiculo);

    void deletarVeiculo(Long id);

}

