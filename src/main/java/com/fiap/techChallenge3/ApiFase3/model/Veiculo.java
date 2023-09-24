package com.fiap.techChallenge3.ApiFase3.model;


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

}
