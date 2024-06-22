package com.icorrea.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icorrea.oficina.entity.Veiculo;
import com.icorrea.oficina.service.VeiculoService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo) {
        try {
            Veiculo veiculoSalvo = veiculoService.criarVeiculo(veiculo);
            return ResponseEntity.ok(veiculoSalvo);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Veiculo>> getVeiculosByCliente(@PathVariable Long clienteId) {
        try {
            List<Veiculo> veiculos = veiculoService.getVeiculosByCliente(clienteId);
            return ResponseEntity.ok(veiculos);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

