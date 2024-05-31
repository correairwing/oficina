package com.icorrea.oficina.service;

import java.util.Date;
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

    public Cliente inserir(Cliente obj) {
        obj.setDataCriacao(new Date());
        Cliente clienteNovo = clienteRepository.saveAndFlush(obj);
        return clienteNovo;
    }

    public Cliente alterar(Cliente obj) {
        obj.setDataAtualizacao(new Date());
        return clienteRepository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        Cliente obj = clienteRepository.findById(id).get();
        clienteRepository.delete(obj);
    }
}
