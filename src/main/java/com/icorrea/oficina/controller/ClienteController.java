package com.icorrea.oficina.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.icorrea.oficina.entity.Cliente;
import com.icorrea.oficina.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

     private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);


    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @GetMapping("/search")
    public List<Cliente> getClientesByName(@RequestParam String name) {
        try {
            return clienteService.getClientesByName(name);
        } catch (Exception e) {
            logger.error("Erro ao buscar clientes pelo nome " + name, e);
            throw e; // rethrow the exception to propagate it to the client
        }
    }

    @GetMapping("/{id}")
    public Optional<Cliente> findById(@PathVariable Long id) {
        try {
            return clienteService.findById(id);
        } catch (Exception e) {
            logger.error("Erro ao buscar cliente com ID " + id, e);
            throw e; // rethrow the exception to propagate it to the client
        }
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
