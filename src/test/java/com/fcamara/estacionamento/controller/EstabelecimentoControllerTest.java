package com.fcamara.estacionamento.controller;

import com.fcamara.estacionamento.model.Estabelecimento;
import com.fcamara.estacionamento.repository.EstabelecimentoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class EstabelecimentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EstabelecimentoRepository estabelecimentoRepository;

    @Test
    public void deveCriarEstabelecimentoComSucesso() throws Exception {
        Estabelecimento estabelecimento = new Estabelecimento("Estacionamento Central", "12345678901234", "Rua A", "999999999", 20, 30);

        when(estabelecimentoRepository.save(any(Estabelecimento.class))).thenReturn(estabelecimento);

        mockMvc.perform(post("/api/estabelecimentos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(estabelecimento)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Estacionamento Central"))
                .andExpect(jsonPath("$.cnpj").value("12345678901234"));
    }

    @Test
    public void deveListarEstabelecimentos() throws Exception {
        Estabelecimento estabelecimento1 = new Estabelecimento("Estacionamento 1", "12345678901234", "Rua A", "999999999", 20, 30);
        Estabelecimento estabelecimento2 = new Estabelecimento("Estacionamento 2", "23456789012345", "Rua B", "888888888", 10, 15);
        when(estabelecimentoRepository.findAll()).thenReturn(Arrays.asList(estabelecimento1, estabelecimento2));

        mockMvc.perform(get("/api/estabelecimentos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Estacionamento 1"))
                .andExpect(jsonPath("$[1].nome").value("Estacionamento 2"));
    }

    @Test
    public void deveAtualizarEstabelecimento() throws Exception {
        Estabelecimento estabelecimentoAtualizado = new Estabelecimento("Estacionamento Atualizado", "12345678901234", "Rua B", "888888888", 10, 20);

        when(estabelecimentoRepository.findById(1L)).thenReturn(Optional.of(estabelecimentoAtualizado));
        when(estabelecimentoRepository.save(any(Estabelecimento.class))).thenReturn(estabelecimentoAtualizado);

        mockMvc.perform(put("/api/estabelecimentos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(estabelecimentoAtualizado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Estacionamento Atualizado"));
    }

    @Test
    public void deveDeletarEstabelecimento() throws Exception {
        when(estabelecimentoRepository.findById(1L)).thenReturn(Optional.of(new Estabelecimento()));

        mockMvc.perform(delete("/api/estabelecimentos/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
