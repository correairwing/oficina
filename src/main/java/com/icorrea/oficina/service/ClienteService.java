package com.icorrea.oficina.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icorrea.oficina.entity.Cliente;
import com.icorrea.oficina.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public List<Cliente> getClientesByName(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public Cliente inserir(Cliente obj) {
        Cliente clienteNovo = clienteRepository.saveAndFlush(obj);
        return clienteNovo;
    }

    public Cliente alterar(Cliente obj) {;
        return clienteRepository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        Cliente obj = clienteRepository.findById(id).get();
        clienteRepository.delete(obj);
    }
}
