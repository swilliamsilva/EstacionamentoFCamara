package com.fcamara.estacionamento.controller;

import com.fcamara.estacionamento.model.Veiculo;
import com.fcamara.estacionamento.model.Veiculo.TipoVeiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveCriarVeiculoComSucesso() throws Exception {
        // Definindo um objeto de Veiculo para ser enviado no POST
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "Preto", "ABC-1234", TipoVeiculo.CARRO);

        mockMvc.perform(post("/api/veiculos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(veiculo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.marca").value("Toyota"))
                .andExpect(jsonPath("$.placa").value("ABC-1234"));
    }

    @Test
    public void deveListarVeiculos() throws Exception {
        mockMvc.perform(get("/api/veiculos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deveAtualizarVeiculo() throws Exception {
        // Definindo um objeto de Veiculo atualizado
        Veiculo veiculo = new Veiculo("Honda", "Civic", "Azul", "DEF-5678", TipoVeiculo.CARRO);

        mockMvc.perform(put("/api/veiculos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(veiculo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.marca").value("Honda"));
    }

    @Test
    public void deveDeletarVeiculo() throws Exception {
        mockMvc.perform(delete("/api/veiculos/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
