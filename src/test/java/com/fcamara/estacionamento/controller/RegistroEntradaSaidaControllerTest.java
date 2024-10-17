package com.fcamara.estacionamento.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fcamara.estacionamento.model.RegistroEntradaSaida;
import com.fcamara.estacionamento.model.Veiculo;
import com.fcamara.estacionamento.model.TipoVeiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistroEntradaSaidaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveRegistrarEntradaVeiculo() throws Exception {
        // Crie um veículo
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("Toyota");
        veiculo.setModelo("Corolla");
        veiculo.setCor("Preto");
        veiculo.setPlaca("ABC-1234");
        veiculo.setTipo(TipoVeiculo.CARRO);

        // Crie o registro de entrada
        RegistroEntradaSaida registro = new RegistroEntradaSaida();
        registro.setVeiculo(veiculo);
        registro.setDataEntrada(LocalDateTime.now());

        // Execute o teste
        mockMvc.perform(post("/api/entrada")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registro)))
                .andExpect(status().isOk());
    }
}
