package com.fcamara.estacionamento.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    public String generateToken(String username) {
        // Converte a chave secreta em bytes
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        // Cria uma SecretKeySpec a partir dos bytes da chave
        SecretKey key = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());

        // Gera o token JWT usando a chave e o algoritmo de assinatura
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas de validade
                .signWith(SignatureAlgorithm.HS256, key) // Agora a assinatura está correta
                .compact();
    }

    // Adicionar setter para secretKey para facilitar o teste
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}

