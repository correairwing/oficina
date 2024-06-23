package com.icorrea.oficina.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "seq_servico", sequenceName = "seq_servico", allocationSize = 1, initialValue = 1)
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_servico")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "orcamento_id")
    private Orcamento orcamento;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;
}

