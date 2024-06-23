package com.icorrea.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icorrea.oficina.entity.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

}
