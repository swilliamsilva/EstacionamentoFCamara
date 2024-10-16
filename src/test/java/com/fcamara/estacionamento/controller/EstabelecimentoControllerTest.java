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

    // MockBean para simular o repositório de Estabelecimento
    @MockBean
    private EstabelecimentoRepository estabelecimentoRepository;

    @Test
    public void deveCriarEstabelecimentoComSucesso() throws Exception {
        // Definindo um estabelecimento de exemplo
        Estabelecimento estabelecimento = new Estabelecimento("Estacionamento Central", "12345678901234", "Rua A", "999999999", 20, 30);

        // Simulando o comportamento do método save() do repositório
        when(estabelecimentoRepository.save(any(Estabelecimento.class))).thenReturn(estabelecimento);

        // Enviando a requisição POST para criar o estabelecimento
        mockMvc.perform(post("/api/estabelecimentos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(estabelecimento)))
                .andExpect(status().isOk()) // Verifica se o status é 200 OK
                .andExpect(jsonPath("$.nome").value("Estacionamento Central")) // Verifica o campo 'nome'
                .andExpect(jsonPath("$.cnpj").value("12345678901234")); // Verifica o campo 'cnpj'
    }

    @Test
    public void deveListarEstabelecimentos() throws Exception {
        // Simulando o comportamento do método findAll() do repositório
        mockMvc.perform(get("/api/estabelecimentos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deveAtualizarEstabelecimento() throws Exception {
        // Definindo um estabelecimento de exemplo para atualizar
        Estabelecimento estabelecimentoAtualizado = new Estabelecimento("Estacionamento Atualizado", "12345678901234", "Rua B", "888888888", 10, 20);

        // Simulando a busca do estabelecimento por ID
        when(estabelecimentoRepository.findById(1L)).thenReturn(Optional.of(estabelecimentoAtualizado));

        // Simulando a atualização do estabelecimento
        when(estabelecimentoRepository.save(any(Estabelecimento.class))).thenReturn(estabelecimentoAtualizado);

        // Enviando a requisição PUT para atualizar o estabelecimento
        mockMvc.perform(put("/api/estabelecimentos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(estabelecimentoAtualizado)))
                .andExpect(status().isOk()) // Verifica se o status é 200 OK
                .andExpect(jsonPath("$.nome").value("Estacionamento Atualizado")); // Verifica se o nome foi atualizado
    }

    @Test
    public void deveDeletarEstabelecimento() throws Exception {
        // Simulando a busca do estabelecimento por ID antes da exclusão
        when(estabelecimentoRepository.findById(1L)).thenReturn(Optional.of(new Estabelecimento()));

        // Enviando a requisição DELETE para excluir o estabelecimento
        mockMvc.perform(delete("/api/estabelecimentos/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()); // Verifica se o status é 200 OK
    }
}
