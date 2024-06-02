package com.icorrea.oficina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.icorrea.oficina.entity.Servico;
import com.icorrea.oficina.service.ServicoService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/")
    public List<Servico> getAllServicos() {
        return servicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Long id) {
        Optional<Servico> servico = servicoService.findById(id);
        if (servico.isPresent()) {
            return ResponseEntity.ok(servico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public Servico createServico(@RequestBody Servico servico) {
        return servicoService.save(servico);
    }

    @PutMapping("/")
    public Servico updateServico(@RequestBody Servico servico) {
        return servicoService.alterar(servico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {
        if (servicoService.findById(id).isPresent()) {
            servicoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

