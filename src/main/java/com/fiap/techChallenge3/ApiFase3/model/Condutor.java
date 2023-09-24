package com.fiap.techChallenge3.ApiFase3.model;

import java.util.ArrayList;
import java.util.List;

public class Condutor {

    private Long id;
    private String nome;
    private String endereco;
    private String contato;
    private List<Veiculo> veiculos = new ArrayList<>();
    private FormadePagamentoEnum formadePagamentoPadrao;

    public Condutor(Long id, String nome, String endereco, String contato) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
