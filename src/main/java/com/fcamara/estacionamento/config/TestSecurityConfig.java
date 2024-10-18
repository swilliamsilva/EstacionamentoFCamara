package com.fcamara.estacionamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class TestSecurityConfig {

    @Bean // Adiciona a anotação @Bean para registrar o SecurityFilterChain
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Desabilita a proteção CSRF (Cross-Site Request Forgery) para testes
        http.csrf(csrf -> csrf.disable()) // Método para desabilitar CSRF no formato lambda

            // Permite todas as requisições sem qualquer tipo de autenticação
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Permite todas as requisições

        return http.build(); // Constrói a configuração de segurança
    }
}
