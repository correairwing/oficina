package com.icorrea.oficina.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icorrea.oficina.entity.Servico;
import com.icorrea.oficina.entity.Status;
import com.icorrea.oficina.service.ServicoService;

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

    @GetMapping("/cliente/{clienteId}")
    public List<Servico> getServicosByClienteId(@PathVariable Long clienteId) {
        return servicoService.findByClienteId(clienteId);
    }

    @GetMapping("/naoFinalizados")
    public List<Servico> getNaoFinalizados() {
        return servicoService.findNaoFinalizados(Status.FINALIZADO);
    }

    @PostMapping("/")
    public Servico createServico(@RequestBody Servico servico) {
        return servicoService.save(servico);
    }

    
    @PutMapping("/{id}")
    public Servico updateServico(@PathVariable Long id, @RequestBody Servico servico) {
        servico.setId(id);
        return servicoService.save(servico);
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

