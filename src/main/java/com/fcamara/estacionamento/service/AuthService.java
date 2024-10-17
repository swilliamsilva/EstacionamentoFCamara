package com.fcamara.estacionamento.service;

import com.fcamara.estacionamento.dto.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class AuthService {

    private final SecretKey jwtSecretKey;

    public AuthService(SecretKey jwtSecretKey) {
        this.jwtSecretKey = jwtSecretKey;
    }

    public String authenticateAndGenerateToken(LoginRequest loginRequest) {
        // Simulação de autenticação, verificar username e password
        if ("admin".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            // Geração do token JWT
            return Jwts.builder()
                    .setSubject(loginRequest.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dia de expiração
                    .signWith(jwtSecretKey, SignatureAlgorithm.HS256)
                    .compact();
        }
        // Caso falhe na autenticação, pode-se lançar uma exceção personalizada
        throw new RuntimeException("Credenciais inválidas!");
    }
}
