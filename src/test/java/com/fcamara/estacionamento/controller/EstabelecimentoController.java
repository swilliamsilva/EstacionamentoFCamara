package com.fcamara.estacionamento.controller;

import com.fcamara.estacionamento.model.Estabelecimento;
import com.fcamara.estacionamento.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estabelecimentos")
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @PostMapping
    public ResponseEntity<Estabelecimento> criarEstabelecimento(@RequestBody Estabelecimento estabelecimento) {
        Estabelecimento novoEstabelecimento = estabelecimentoRepository.save(estabelecimento);
        return ResponseEntity.ok(novoEstabelecimento);
    }
}

