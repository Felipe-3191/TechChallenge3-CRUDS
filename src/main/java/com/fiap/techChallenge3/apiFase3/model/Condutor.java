package com.fiap.techChallenge3.apiFase3.model;

import static com.fiap.techChallenge3.apiFase3.model.FormadePagamentoEnum.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fiap.techChallenge3.apiFase3.condutorAPI.dto.CondutorDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Condutor {

    @OneToMany(mappedBy = "condutor", cascade = CascadeType.ALL)
    private final List<Veiculo> veiculos = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String contato;
    @Enumerated(EnumType.ORDINAL)
    private FormadePagamentoEnum formadePagamentoPadrao;

    public Condutor(Long id, String nome, String endereco, String contato) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Condutor() {
    }

    public Condutor(CondutorDTO condutorDTO) {
        this.id = condutorDTO.getId();
        this.nome = condutorDTO.getNome();
        this.endereco = condutorDTO.getEndereco();
        this.contato = condutorDTO.getContato();
        this.formadePagamentoPadrao = valueOf(condutorDTO.getFormaDePagamentoPadrao());
    }

    public FormadePagamentoEnum getFormadePagamentoPadrao() {
        return formadePagamentoPadrao;
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
