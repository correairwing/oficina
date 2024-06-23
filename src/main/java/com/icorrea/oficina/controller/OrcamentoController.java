package com.icorrea.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icorrea.oficina.entity.Orcamento;
import com.icorrea.oficina.service.OrcamentoService;

@RestController
@RequestMapping("/api/orcamentos")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @PostMapping
    public ResponseEntity<Orcamento> criarOrcamento(@RequestBody Orcamento orcamento) {
        try {
            Orcamento novoOrcamento = orcamentoService.criarOrcamento(orcamento);
            return ResponseEntity.ok(novoOrcamento);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Orcamento>> obterOrcamentos() {
        List<Orcamento> orcamentos = orcamentoService.obterOrcamentos();
        return ResponseEntity.ok(orcamentos);
    }
}