package com.fcamara.estacionamento.service;

import com.fcamara.estacionamento.dto.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class AuthService {
    
    private final SecretKey secretKey;

    public AuthService(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String authenticateAndGenerateToken(LoginRequest loginRequest) {
        // Supondo que a autenticação seja bem-sucedida, você pode então gerar o token JWT

        // Defina a data de expiração do token (por exemplo, 1 hora a partir de agora)
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600000); // 1 hora em milissegundos

        // Gerar o token JWT utilizando a secretKey
        return Jwts.builder()
                .setSubject(loginRequest.getUsername())  // Definir o nome de usuário no token
                .setIssuedAt(now)  // Definir a data de criação
                .setExpiration(expiryDate)  // Definir a data de expiração
                .signWith(secretKey, SignatureAlgorithm.HS256)  // Usar a secretKey para assinar o token
                .compact();
    }
}
