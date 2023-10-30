package com.fiap.techChallenge3.apiFase3.model;


import com.fiap.techChallenge3.apiFase3.veiculoAPI.dto.VeiculoDTO;
import jakarta.persistence.*;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private String placa;

    @ManyToOne
    @JoinColumn(name = "condutor_id")
    private Condutor condutor;


    public  Veiculo(VeiculoDTO veiculoDto) {
        this.id = veiculoDto.getId();
        this.marca = veiculoDto.getMarca();
        this.modelo = veiculoDto.getModelo();
        this.placa = veiculoDto.getPlaca();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }
}
