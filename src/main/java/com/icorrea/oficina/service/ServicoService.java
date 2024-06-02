package com.icorrea.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icorrea.oficina.dto.ServicoRequest;
import com.icorrea.oficina.entity.Cliente;
import com.icorrea.oficina.entity.Servico;
import com.icorrea.oficina.repository.ClienteRepository;
import com.icorrea.oficina.repository.ServicoRepository;

import jakarta.transaction.Transactional;

@Service
public class ServicoService {


    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

     @Transactional
    public Servico createServico(ServicoRequest servicoRequest) {
        Cliente cliente = clienteRepository.findById(servicoRequest.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Servico servico = new Servico();
        servico.setDescricaoServico(servicoRequest.getDescricaoServico());
        servico.setStatus(servicoRequest.getStatus());
        servico.setCliente(cliente);

        return servicoRepository.save(servico);
    }

    public Servico alterar(Servico obj) {
        return servicoRepository.saveAndFlush(obj);
    }

    public List<Servico> listarVendas() {
        return servicoRepository.findAll();
    }

    public Servico buscarVendaPorId(Long id) {
        return servicoRepository.findById(id).orElse(null);
    }

    public void deletarVenda(Long id) {
        servicoRepository.deleteById(id);
    }
}
