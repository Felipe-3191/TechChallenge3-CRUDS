package com.fiap.techChallenge3.apiFase3.condutorAPI.dto;

import com.fiap.techChallenge3.apiFase3.condutorAPI.projections.CondutorBuscarTodosProjection;

public class CondutorBuscarTodosMinDTO {

    private String nome;
    private String endereco;
    private String contato;
    private String formaDePagamentoPadrao;


    public CondutorBuscarTodosMinDTO() {}

    public CondutorBuscarTodosMinDTO(CondutorBuscarTodosProjection entity) {
        this.nome = entity.getNome();
        this.endereco = entity.getEndereco();
        this.contato = entity.getContato();
        this.formaDePagamentoPadrao = entity.getFormadePagamentoPadrao();

    }
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

    public String getFormaDePagamentoPadrao() {
        return formaDePagamentoPadrao;
    }
}
