package com.fiap.techChallenge3.apiFase3.condutorAPI.dto;

import com.fiap.techChallenge3.apiFase3.model.Condutor;
import com.fiap.techChallenge3.apiFase3.model.Veiculo;
import com.fiap.techChallenge3.apiFase3.veiculoAPI.dto.VeiculoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CondutorBuscarTodosDTO {

    private String nome;
    private String endereco;
    private String contato;
    private List<VeiculoDTO> veiculos;

    public CondutorBuscarTodosDTO(){}

    public CondutorBuscarTodosDTO(Condutor entity){
        this.nome = entity.getNome();
        this.endereco = entity.getEndereco();
        this.contato = entity.getContato();
        this.veiculos = entity.getVeiculos().stream().map(VeiculoDTO::new).collect(Collectors.toList());

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

    public List<VeiculoDTO> getVeiculos() {
        return veiculos;
    }
}
