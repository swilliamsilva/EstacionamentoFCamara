package com.fcamara.estacionamento.controller;

import com.fcamara.estacionamento.model.RegistroEntradaSaida;
import com.fcamara.estacionamento.model.Veiculo;
import com.fcamara.estacionamento.repository.RegistroEntradaSaidaRepository;
import com.fcamara.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegistroEntradaSaidaController {

    @Autowired
    private RegistroEntradaSaidaRepository registroRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    // Registrar entrada de veículo
    @PostMapping("/entrada")
    public ResponseEntity<RegistroEntradaSaida> registrarEntrada(@RequestBody RegistroEntradaSaida entrada) {
        entrada.setDataEntrada(LocalDateTime.now()); // Define a data de entrada como o momento atual
        RegistroEntradaSaida novoRegistro = registroRepository.save(entrada);
        return ResponseEntity.ok(novoRegistro);
    }

    // Registrar saída de veículo
    @PutMapping("/saida/{id}")
    public ResponseEntity<RegistroEntradaSaida> registrarSaida(@PathVariable Long id) {
        Optional<RegistroEntradaSaida> registroOptional = registroRepository.findById(id);

        if (registroOptional.isPresent()) {
            RegistroEntradaSaida registro = registroOptional.get();
            registro.setDataSaida(LocalDateTime.now()); // Define a data de saída como o momento atual
            registroRepository.save(registro);
            return ResponseEntity.ok(registro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
