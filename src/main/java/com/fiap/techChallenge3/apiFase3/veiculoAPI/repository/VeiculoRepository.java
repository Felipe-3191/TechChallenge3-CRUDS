package com.fiap.techChallenge3.apiFase3.veiculoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.techChallenge3.apiFase3.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Veiculo findByPlaca(String placa);
}
