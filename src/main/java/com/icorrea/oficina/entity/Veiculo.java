package com.icorrea.oficina.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "veiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq_veiculo", sequenceName = "seq_veiculo", allocationSize = 1, initialValue = 1)
public class Veiculo {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_veiculo")
    private Long id;

    private String placa;
    private String marca;
    private String modelo;
    private int ano;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
