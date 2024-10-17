package com.fcamara.estacionamento.controller;

import com.fcamara.estacionamento.model.Relatorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    @GetMapping
    public ResponseEntity<List<Relatorio>> getRelatorios() {
        // Lógica fictícia para retornar os relatórios
        List<Relatorio> relatorios = new ArrayList<>();
        relatorios.add(new Relatorio("Relatório 1", "Descrição do Relatório 1"));
        relatorios.add(new Relatorio("Relatório 2", "Descrição do Relatório 2"));
        
        return ResponseEntity.ok(relatorios);
    }
}
