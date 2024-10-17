package com.fcamara.estacionamento.controller;

import com.fcamara.estacionamento.dto.JwtResponse;
import com.fcamara.estacionamento.dto.LoginRequest;
import com.fcamara.estacionamento.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Delegar a lógica de autenticação para o AuthService
        String token = authService.authenticateAndGenerateToken(loginRequest);

        // Retorna o token JWT como resposta
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
