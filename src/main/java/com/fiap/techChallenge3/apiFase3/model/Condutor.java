package com.fiap.techChallenge3.apiFase3.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Condutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String contato;

    @OneToMany(mappedBy = "condutor")
    private List<Veiculo> veiculos = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL)
    private FormadePagamentoEnum formadePagamentoPadrao;

    public Condutor() {}

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

    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }
    public List<Veiculo> getVeiculos() {
        return Collections.unmodifiableList(veiculos);
    }
}
