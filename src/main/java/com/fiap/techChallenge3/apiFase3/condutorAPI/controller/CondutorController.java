package com.fiap.techChallenge3.apiFase3.condutorAPI.controller;

import com.fiap.techChallenge3.apiFase3.condutorAPI.dto.CondutorBuscarTodosDTO;
import com.fiap.techChallenge3.apiFase3.condutorAPI.dto.CondutorBuscarTodosMinDTO;
import com.fiap.techChallenge3.apiFase3.condutorAPI.service.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/condutor")
public class CondutorController {

    private CondutorService service;

    @Autowired
    CondutorController(CondutorService service) {
        this.service = service;
    }

    @GetMapping(value = "/buscarTodosMin")
    public ResponseEntity<Page<CondutorBuscarTodosMinDTO>> buscarTodosOsCondutoresMin(Pageable page){
        Page<CondutorBuscarTodosMinDTO> response = this.service.buscarTodosOsCondutoresMin(page);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<Page<CondutorBuscarTodosDTO>> buscarTodosOsCondutores(Pageable page){
        Page<CondutorBuscarTodosDTO> response = this.service.buscarTodosOsCondutores(page);
        return ResponseEntity.ok(response);
    }
}
