package com.icorrea.oficina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icorrea.oficina.entity.Servico;
import com.icorrea.oficina.entity.Status;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

    List<Servico> findByClienteId(Long clienteId);

    List<Servico> findByStatusNotOrderByDataCriacaoDesc(Status status);
}
