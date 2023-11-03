package com.fiap.techChallenge3.apiFase3.veiculoAPI.dto;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techChallenge3.apiFase3.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VeiculoDTO {

    @Positive(message = "O id não pode ser negativo")
    private Long id;
    @NotBlank(message = "Marca obrigatoria")
    private String marca;
    @NotBlank(message = "Modelo obrigatorio")
    private String modelo;
    @NotBlank(message = "Placa obrigatoria")
    private String placa;
    @NotNull
    @Positive
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long idCondutor;

    public VeiculoDTO(Veiculo entity) {
        this.id = entity.getId();
        this.marca = entity.getMarca();
        this.modelo = entity.getModelo();
        this.placa = entity.getPlaca();
    }

    public Long getIdCondutor() {
        return idCondutor;
    }

    public void setIdCondutor(Long idCondutor) {
        this.idCondutor = idCondutor;
    }

    public VeiculoDTO(Optional<Veiculo> veiculo) {

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
