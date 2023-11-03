package com.fiap.techChallenge3.apiFase3.condutorAPI.dto;

import com.fiap.techChallenge3.apiFase3.model.Condutor;

public class CondutorDTO {

    private Long id;
    private String nome;
    private String endereco;
    private String contato;

    private String formaDePagamentoPadrao;

    public CondutorDTO() {
    }

    public String getFormaDePagamentoPadrao() {
        return formaDePagamentoPadrao;
    }

    public void setFormaDePagamentoPadrao(String formaDePagamentoPadrao) {
        this.formaDePagamentoPadrao = formaDePagamentoPadrao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CondutorDTO(Condutor entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.endereco = entity.getEndereco();
        this.contato = entity.getContato();
        this.formaDePagamentoPadrao = entity.getFormadePagamentoPadrao().name();

    }

    public CondutorDTO(CondutorDTO condutor) {

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

}
