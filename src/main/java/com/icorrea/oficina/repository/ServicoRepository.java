package com.icorrea.oficina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icorrea.oficina.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

     @Query("SELECT s FROM Servico s WHERE s.cliente.id = :clienteId")
    List<Servico> findByClienteId(@Param("clienteId") Long clienteId);
}
