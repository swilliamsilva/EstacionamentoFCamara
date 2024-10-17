package com.fcamara.estacionamento.controller;

import com.fcamara.estacionamento.model.Estabelecimento;
import com.fcamara.estacionamento.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Estabelecimento>> listarEstabelecimentos() {
        List<Estabelecimento> estabelecimentos = estabelecimentoRepository.findAll();
        return ResponseEntity.ok(estabelecimentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estabelecimento> atualizarEstabelecimento(@PathVariable Long id, @RequestBody Estabelecimento estabelecimentoAtualizado) {
        Optional<Estabelecimento> estabelecimentoExistente = estabelecimentoRepository.findById(id);
        if (estabelecimentoExistente.isPresent()) {
            Estabelecimento estabelecimento = estabelecimentoExistente.get();
            estabelecimento.setNome(estabelecimentoAtualizado.getNome());
            estabelecimento.setCnpj(estabelecimentoAtualizado.getCnpj());
            estabelecimento.setEndereco(estabelecimentoAtualizado.getEndereco());
            estabelecimento.setTelefone(estabelecimentoAtualizado.getTelefone());
            estabelecimento.setVagasCarros(estabelecimentoAtualizado.getVagasCarros());
            estabelecimento.setVagasMotos(estabelecimentoAtualizado.getVagasMotos());
            return ResponseEntity.ok(estabelecimentoRepository.save(estabelecimento));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstabelecimento(@PathVariable Long id) {
        Optional<Estabelecimento> estabelecimento = estabelecimentoRepository.findById(id);
        if (estabelecimento.isPresent()) {
            estabelecimentoRepository.delete(estabelecimento.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
