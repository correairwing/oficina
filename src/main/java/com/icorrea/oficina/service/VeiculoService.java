package com.icorrea.oficina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icorrea.oficina.entity.Cliente;
import com.icorrea.oficina.entity.Veiculo;
import com.icorrea.oficina.repository.ClienteRepository;
import com.icorrea.oficina.repository.VeiculoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VeiculoService {


    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Veiculo criarVeiculo(Veiculo veiculo) {
        Optional<Cliente> cliente = clienteRepository.findById(veiculo.getCliente().getId());
        if (cliente.isPresent()) {
            veiculo.setCliente(cliente.get());
            return veiculoRepository.save(veiculo);
        } else {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
    }

    public List<Veiculo> getVeiculosByCliente(Long clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (cliente.isPresent()) {
            return cliente.get().getVeiculos();
        } else {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
    }
}
