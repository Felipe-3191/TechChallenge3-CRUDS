package com.fiap.techChallenge3.apiFase3.veiculoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.techChallenge3.apiFase3.veiculoAPI.dto.VeiculoDTO;
import com.fiap.techChallenge3.apiFase3.veiculoAPI.service.VeiculoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping

    public ResponseEntity<VeiculoDTO> buscaVeiculo(@RequestParam @Valid @NotBlank String placa) {

        return ResponseEntity.status(HttpStatus.OK).body(service.buscaVeiculo(placa));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VeiculoDTO> buscaVeiculoId(@PathVariable("id") @Valid @Positive @NotNull Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(service.buscaVeiculoId(id));
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> inserirVeiculo(@RequestBody @Valid VeiculoDTO veiculo) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarVeiculo(veiculo));
    }

    @PutMapping
    public ResponseEntity<VeiculoDTO> atualizarVeiculo(@RequestBody @Valid VeiculoDTO veiculo) {

        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarVeiculo(veiculo));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable("id") Long id) {
        service.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}
