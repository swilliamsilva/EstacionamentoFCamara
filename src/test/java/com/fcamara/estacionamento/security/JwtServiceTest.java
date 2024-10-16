package com.fcamara.estacionamento.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {

    @InjectMocks
    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        jwtService = new JwtService();
        jwtService.setSecretKey("mySecretKey"); // Usar o setter para simular o valor da chave secreta
    }

    @Test
    void testGenerateToken() {
        String username = "testUser";
        String token = jwtService.generateToken(username);

        assertNotNull(token);
        assertTrue(token.length() > 0);
    }
}
