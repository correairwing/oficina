package com.icorrea.oficina.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orcamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq_orcamento", sequenceName = "seq_orcamento", allocationSize = 1, initialValue = 1)
public class Orcamento {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orcamento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL)
    private List<Servico> servicos;

    private Double totalBruto;
    private Double totalLiquido;
}
