package com.fiap.techChallenge3.apiFase3.condutorAPI.repository;

import com.fiap.techChallenge3.apiFase3.condutorAPI.projections.CondutorBuscarTodosProjection;
import com.fiap.techChallenge3.apiFase3.model.Condutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long> {


    @Query(value = "SELECT c.nome as nome, c.endereco as endereco, c.contato as contato, c.formadePagamentoPadrao as formadePagamentoPadrao FROM Condutor c")
    Page<CondutorBuscarTodosProjection> buscarTodosMin(Pageable page);
}
