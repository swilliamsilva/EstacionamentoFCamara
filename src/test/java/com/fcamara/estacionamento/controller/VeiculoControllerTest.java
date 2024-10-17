package com.fcamara.estacionamento.controller;

import com.fcamara.estacionamento.model.TipoVeiculo;  // Importe a enum TipoVeiculo
import com.fcamara.estacionamento.model.Veiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveCriarVeiculoComSucesso() throws Exception {
        // Agora usamos TipoVeiculo diretamente
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "Preto", "ABC-1234", TipoVeiculo.CARRO);

        mockMvc.perform(post("/api/veiculos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(veiculo)))
                .andExpect(status().isOk());
    }
}
