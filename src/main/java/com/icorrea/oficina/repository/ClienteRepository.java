package com.icorrea.oficina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icorrea.oficina.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByNome(String nome);
}
