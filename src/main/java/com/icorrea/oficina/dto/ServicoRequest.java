package com.icorrea.oficina.dto;

import com.icorrea.oficina.entity.Status;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServicoRequest {

    private Long clienteId;
    private String descricaoServico;
    private Status status;
}
