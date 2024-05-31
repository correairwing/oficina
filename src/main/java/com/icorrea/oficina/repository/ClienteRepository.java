package com.icorrea.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icorrea.oficina.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
