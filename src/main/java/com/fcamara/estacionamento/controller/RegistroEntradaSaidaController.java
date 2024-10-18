package com.fcamara.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcamara.estacionamento.model.RegistroEntradaSaida;
import com.fcamara.estacionamento.service.RegistroEntradaSaidaService;

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
