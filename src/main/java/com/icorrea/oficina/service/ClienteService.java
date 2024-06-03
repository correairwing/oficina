package com.icorrea.oficina.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icorrea.oficina.entity.Cliente;
import com.icorrea.oficina.repository.ClienteRepository;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public List<Cliente> getClientesByName(String name) {
        try {
            return clienteRepository.findByNome(name);
        } catch (Exception e) {
            logger.error("Erro ao buscar clientes pelo nome " + name, e);
            throw e; // rethrow the exception to propagate it to the client
        }
    }

    public Optional<Cliente> findById(Long id) {
        try {
            return clienteRepository.findById(id);
        } catch (Exception e) {
            logger.error("Erro ao buscar cliente com ID " + id, e);
            throw e; // rethrow the exception to propagate it to the client
        }
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
