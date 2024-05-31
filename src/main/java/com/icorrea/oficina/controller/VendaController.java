package com.icorrea.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icorrea.oficina.entity.Venda;
import com.icorrea.oficina.service.VendaService;

@RestController
@RequestMapping("/api/venda")
public class VendaController {


    @Autowired
    private VendaService vendaService;

    @PostMapping("/")
    public Venda criarVenda(@RequestBody Venda venda) {
        return vendaService.salvarVenda(venda);
    }

    @GetMapping("/")
    public List<Venda> listarVendas() {
        return vendaService.listarVendas();
    }

    @GetMapping("/{id}")
    public Venda buscarVendaPorId(@PathVariable Long id) {
        return vendaService.buscarVendaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarVenda(@PathVariable Long id) {
        vendaService.deletarVenda(id);
    }
}
