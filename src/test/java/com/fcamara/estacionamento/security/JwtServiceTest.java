package com.fcamara.estacionamento.security;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm; // Use o pacote correto
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import javax.crypto.SecretKey;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JwtServiceTest {

    @InjectMocks
    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        jwtService = new JwtService();

        // Escolha o algoritmo de assinatura e gere a chave apropriada
        SecretKey testKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Para HS256
        // Ou se for RS256 ou ES256, utilize a respectiva chave (RS256 geralmente envolve chaves assimétricas)
        // SecretKey testKey = Keys.secretKeyFor(SignatureAlgorithm.ES256); // Exemplo para ES256

        jwtService.setSecretKey(testKey); // Define a chave segura para o teste
    }

    @Test
    void testGenerateToken() {
        String username = "testUser";
        String token = jwtService.generateToken(username);

        assertNotNull(token); // Verifica se o token não é nulo
        assertTrue(token.length() > 0); // Verifica se o token gerado tem algum conteúdo
    }
}
