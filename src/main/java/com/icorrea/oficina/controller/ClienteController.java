package com.icorrea.oficina.controller;

import java.util.List;

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

import com.icorrea.oficina.entity.Cliente;
import com.icorrea.oficina.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @GetMapping("/{nome}")
    public List<Cliente> getClientesByName(@PathVariable String nome) {
        return clienteService.getClientesByName(nome);
    }

    @PostMapping("/")
    public Cliente inserir(@RequestBody Cliente obj) {
        return clienteService.inserir(obj);             
    }

    @PutMapping("/")
    public Cliente alterar(@RequestBody Cliente obj) {
        return clienteService.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
