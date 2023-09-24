package com.fiap.techChallenge3.apiFase3.veiculoAPI.dto;

import com.fiap.techChallenge3.apiFase3.model.Veiculo;

public class VeiculoDTO {
    private String marca;
    private String modelo;
    private String placa;


    public VeiculoDTO() {

    }

    public VeiculoDTO(Veiculo entity) {
        this.marca = entity.getMarca();
        this.modelo = entity.getModelo();
        this.placa = entity.getPlaca();
    }


    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }
}
