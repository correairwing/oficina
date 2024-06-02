package com.icorrea.oficina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icorrea.oficina.entity.Cliente;
import com.icorrea.oficina.entity.Servico;
import com.icorrea.oficina.repository.ServicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> findById(Long id) {
        return servicoRepository.findById(id);
    }

    public Servico alterar(Servico obj) {;
        return servicoRepository.saveAndFlush(obj);
    }

    public Servico save(Servico obj) {
        return servicoRepository.saveAndFlush(obj);
    }

    public void deleteById(Long id) {
        servicoRepository.deleteById(id);
    }
}

