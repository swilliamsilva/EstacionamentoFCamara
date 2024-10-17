package com.fcamara.estacionamento.service;

import org.springframework.stereotype.Service;

import com.fcamara.estacionamento.dto.LoginRequest;

import javax.crypto.SecretKey;

@Service
public class AuthService {

    private final SecretKey secretKey;

    public AuthService(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String authenticateAndGenerateToken(LoginRequest loginRequest) {
        // Sua lógica de autenticação e geração do token JWT usando a secretKey
        return "token";
    }
}
