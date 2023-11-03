package com.fiap.techChallenge3.apiFase3.condutorAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.techChallenge3.apiFase3.condutorAPI.dto.CondutorBuscarTodosDTO;
import com.fiap.techChallenge3.apiFase3.condutorAPI.dto.CondutorBuscarTodosMinDTO;
import com.fiap.techChallenge3.apiFase3.condutorAPI.dto.CondutorDTO;
import com.fiap.techChallenge3.apiFase3.condutorAPI.service.CondutorService;
import com.fiap.techChallenge3.apiFase3.model.Condutor;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/condutor")
public class CondutorController {

    private final CondutorService service;

    @Autowired
    CondutorController(CondutorService service) {
        this.service = service;
    }

    @GetMapping(value = "/buscarTodosMin")
    public ResponseEntity<Page<CondutorBuscarTodosMinDTO>> buscarTodosOsCondutoresMin(Pageable page) {
        Page<CondutorBuscarTodosMinDTO> response = this.service.buscarTodosOsCondutoresMin(page);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<Page<CondutorBuscarTodosDTO>> buscarTodosOsCondutores(Pageable page) {
        Page<CondutorBuscarTodosDTO> response = this.service.buscarTodosOsCondutores(page);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CondutorDTO> salvarCondutor(@RequestBody @Valid CondutorDTO condutor) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarCondutor(condutor));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletarCondutor(@PathVariable("id") Long id) {
        service.deletarCondutor(id);
        return ResponseEntity.noContent().build();
    }
}
