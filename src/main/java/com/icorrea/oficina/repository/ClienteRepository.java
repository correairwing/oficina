package com.icorrea.oficina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icorrea.oficina.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) = LOWER(:nome)")
    List<Cliente> findByNome(@Param("nome") String nome);
}
