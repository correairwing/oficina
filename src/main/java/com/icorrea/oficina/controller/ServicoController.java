package com.icorrea.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icorrea.oficina.dto.ServicoRequest;

import com.icorrea.oficina.entity.Servico;

import com.icorrea.oficina.service.ServicoService;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping("/")
    public ResponseEntity<Servico> createServico(@RequestBody ServicoRequest servicoRequest) {
        Servico novoServico = servicoService.createServico(servicoRequest);
        return ResponseEntity.ok(novoServico);
    }

    @GetMapping("/")
    public List<Servico> listarVendas() {
        return servicoService.listarVendas();
    }

    @GetMapping("/{id}")
    public Servico buscarVendaPorId(@PathVariable Long id) {
        return servicoService.buscarVendaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarVenda(@PathVariable Long id) {
        servicoService.deletarVenda(id);
    }
}
