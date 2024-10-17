package com.fcamara.estacionamento.controller;

import com.fcamara.estacionamento.model.RegistroEntradaSaida;
import com.fcamara.estacionamento.model.Veiculo;
import com.fcamara.estacionamento.repository.RegistroEntradaSaidaRepository;
import com.fcamara.estacionamento.repository.VeiculoRepository;
import com.fcamara.estacionamento.service.RegistroEntradaSaidaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegistroEntradaSaidaController {

    @Autowired
    private RegistroEntradaSaidaService registroEntradaSaidaService;

    @PostMapping("/entrada")
    public ResponseEntity<RegistroEntradaSaida> registrarEntrada(@RequestBody RegistroEntradaSaida registro) {
        // Usar o serviço para salvar o registro de entrada
        RegistroEntradaSaida registroSalvo = registroEntradaSaidaService.registrarEntrada(registro);
        return ResponseEntity.ok(registroSalvo);
    }
}
