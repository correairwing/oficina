package com.icorrea.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icorrea.oficina.entity.Orcamento;
import com.icorrea.oficina.entity.Servico;
import com.icorrea.oficina.repository.OrcamentoRepository;
import com.icorrea.oficina.repository.ServicoRepository;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    public Orcamento criarOrcamento(Orcamento orcamento) {
        double totalBruto = orcamento.getServicos().stream().mapToDouble(Servico::getValor).sum();
        orcamento.setTotalBruto(totalBruto);
        orcamento.setTotalLiquido(totalBruto); // Ajuste conforme necessário

        Orcamento savedOrcamento = orcamentoRepository.save(orcamento);

        for (Servico servico : orcamento.getServicos()) {
            servico.setOrcamento(savedOrcamento);
            servicoRepository.save(servico);
        }

        return savedOrcamento;
    }

    public List<Orcamento> obterOrcamentos() {
        return orcamentoRepository.findAll();
    }
}