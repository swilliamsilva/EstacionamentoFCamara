package com.fcamara.estacionamento.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private SecretKey secretKey;

    // Gera o token JWT usando a chave e o algoritmo de assinatura
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas de validade
                .signWith(secretKey) // Usa a chave gerada
                .compact();
    }

    // Método setter para facilitar a injeção de uma chave de teste ou chave externa
    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }
}
