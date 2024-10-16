package com.fcamara.estacionamento.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType; // Import correto
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Import do método 'get'
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Import do método 'status'

@SpringBootTest
@AutoConfigureMockMvc
public class RelatorioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveGerarRelatorioDeEntradasESaidas() throws Exception {
        // Realizando o teste de GET para o endpoint "/api/relatorios"
        mockMvc.perform(get("/api/relatorios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()); // Verificando se o status HTTP retornado é 200 OK
    }
}
