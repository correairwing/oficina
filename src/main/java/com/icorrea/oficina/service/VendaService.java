package com.icorrea.oficina.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icorrea.oficina.entity.Venda;
import com.icorrea.oficina.repository.VendaRepository;

@Service
public class VendaService {


    @Autowired
    private VendaRepository vendaRepository;

    public Venda salvarVenda(Venda obj) {
        obj.setDataCriacao(new Date());
        return vendaRepository.saveAndFlush(obj);
    }

    public Venda alterar(Venda obj) {
        obj.setDataAtualizacao(new Date());
        return vendaRepository.saveAndFlush(obj);
    }

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    public Venda buscarVendaPorId(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public void deletarVenda(Long id) {
        vendaRepository.deleteById(id);
    }
}
