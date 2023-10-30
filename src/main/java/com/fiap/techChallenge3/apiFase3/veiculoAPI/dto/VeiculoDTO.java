package com.fiap.techChallenge3.apiFase3.veiculoAPI.dto;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techChallenge3.apiFase3.model.Veiculo;
public class VeiculoDTO {
    private Long id;
    private String marca;
    private String modelo;
    private String placa;


    public VeiculoDTO(Veiculo entity) {
        this.id = entity.getId();
        this.marca = entity.getMarca();
        this.modelo = entity.getModelo();
        this.placa = entity.getPlaca();
    }

    public VeiculoDTO() {
    }

    public Long getId() {
        return id;
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
