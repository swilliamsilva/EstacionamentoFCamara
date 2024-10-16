package com.fcamara.estacionamento.controller;

import com.fcamara.estacionamento.model.RegistroEntradaSaida;
import com.fcamara.estacionamento.model.Veiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistroEntradaSaidaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveRegistrarEntradaVeiculo() throws Exception {
        // Criando o objeto Veiculo (você pode mockar esse objeto ou criar uma instância real)
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "Preto", "ABC-1234", Veiculo.TipoVeiculo.CARRO);

        // Criando o objeto RegistroEntradaSaida com dados simulados
        RegistroEntradaSaida entrada = new RegistroEntradaSaida(veiculo, LocalDateTime.now(), null);

        // Simulando a requisição POST para registrar a entrada de um veículo
        mockMvc.perform(post("/api/entrada")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(entrada)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.veiculo.placa").value("ABC-1234")); // Verificando a placa do veículo
    }

    @Test
    public void deveRegistrarSaidaVeiculo() throws Exception {
        // Criando o objeto RegistroEntradaSaida com dados simulados para a saída
        RegistroEntradaSaida saida = new RegistroEntradaSaida(null, LocalDateTime.now().minusHours(2), LocalDateTime.now());

        // Simulando a requisição PUT para registrar a saída de um veículo
        mockMvc.perform(put("/api/saida/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(saida)))
                .andExpect(status().isOk());
    }
}
