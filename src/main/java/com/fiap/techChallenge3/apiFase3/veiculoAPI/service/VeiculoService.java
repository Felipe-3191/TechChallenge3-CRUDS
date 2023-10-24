package com.fiap.techChallenge3.apiFase3.veiculoAPI.service;

import com.fiap.techChallenge3.apiFase3.veiculoAPI.dto.VeiculoDTO;

public interface VeiculoService {

    VeiculoDTO buscaVeiculo(String placa);
}
