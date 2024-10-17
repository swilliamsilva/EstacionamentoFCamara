package com.fcamara.estacionamento.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RelatorioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveGerarRelatorioDeEntradasESaidas() throws Exception {
        mockMvc.perform(get("/api/relatorios")
                .contentType("application/json"))
                .andExpect(status().isOk()); // Espera que o status seja 200 (OK)
    }
}
