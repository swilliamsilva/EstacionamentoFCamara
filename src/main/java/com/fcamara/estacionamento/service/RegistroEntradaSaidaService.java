package com.fcamara.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcamara.estacionamento.model.RegistroEntradaSaida;
import com.fcamara.estacionamento.repository.RegistroEntradaSaidaRepository;
import com.fcamara.estacionamento.repository.VeiculoRepository;

@Service
public class RegistroEntradaSaidaService {

    @Autowired
    private RegistroEntradaSaidaRepository registroEntradaSaidaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public RegistroEntradaSaida registrarEntrada(RegistroEntradaSaida registro) {
        // Verificar se o registro ou o veículo são nulos
        if (registro == null || registro.getVeiculo() == null) {
            throw new IllegalArgumentException("O registro ou o veículo não podem ser nulos");
        }

        // Salvar o veículo, caso ainda não esteja salvo
        if (registro.getVeiculo().getId() == null) {
            veiculoRepository.save(registro.getVeiculo());
        }

        // Salvar o registro de entrada
        return registroEntradaSaidaRepository.save(registro);
    }
}
