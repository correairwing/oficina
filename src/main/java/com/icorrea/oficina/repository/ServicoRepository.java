package com.icorrea.oficina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.icorrea.oficina.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

    @EntityGraph(attributePaths = {"cliente"})
    List<Servico> findAll();
}
