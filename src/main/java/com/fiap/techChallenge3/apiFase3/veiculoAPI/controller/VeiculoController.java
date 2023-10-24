package com.fiap.techChallenge3.apiFase3.veiculoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.techChallenge3.apiFase3.veiculoAPI.dto.VeiculoDTO;
import com.fiap.techChallenge3.apiFase3.veiculoAPI.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping

    public ResponseEntity<VeiculoDTO> buscaVeiculo(@RequestParam String placa) {

        return ResponseEntity.status(HttpStatus.OK).body(service.buscaVeiculo(placa));    }
}
