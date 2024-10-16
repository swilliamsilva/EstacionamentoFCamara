package com.fcamara.estacionamento.controller;

import com.fcamara.estacionamento.security.JwtService;
import com.fcamara.estacionamento.dto.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private JwtService jwtService;  // Simulação do JwtService para gerar um token fictício

    @Test
    public void deveLogarComSucessoEGerarJWT() throws Exception {
        // Criando o objeto LoginRequest usando o construtor padrão
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("password");

        // Simulando a geração de um token JWT fictício
        when(jwtService.generateToken("admin")).thenReturn("fake-jwt-token");

        // Fazendo a requisição POST para o login e verificando o retorno
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())  // Verifica se o status HTTP retornado é 200 OK
                .andExpect(jsonPath("$.token").value("fake-jwt-token"));  // Verifica se o campo 'token' existe na resposta
    }
}
