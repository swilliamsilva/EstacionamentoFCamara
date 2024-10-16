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

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class EstabelecimentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstabelecimentoRepository estabelecimentoRepository;

    @Test
    public void testCriarEstabelecimento() throws Exception {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setNome("Estacionamento XYZ");
        estabelecimento.setCnpj("12.345.678/0001-99");
        estabelecimento.setEndereco("Rua ABC, 123");
        estabelecimento.setTelefone("1234-5678");
        estabelecimento.setVagasMotos(10);
        estabelecimento.setVagasCarros(20);

        // Simula o comportamento do repositório
        when(estabelecimentoRepository.save(any(Estabelecimento.class))).thenReturn(estabelecimento);

        // Executa uma requisição POST e verifica se o retorno está correto
        mockMvc.perform(post("/api/estabelecimentos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(estabelecimento)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Estacionamento XYZ"));
    }
}
