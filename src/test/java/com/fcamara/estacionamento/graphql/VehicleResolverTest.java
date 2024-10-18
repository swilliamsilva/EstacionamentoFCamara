package com.fcamara.estacionamento.graphql;

import com.fcamara.estacionamento.model.Vehicle;
import com.fcamara.estacionamento.model.VehicleResolver;
import com.fcamara.estacionamento.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class VehicleResolverTest {

    @Mock
    private VehicleService vehicleService;

    @InjectMocks
    private VehicleResolver vehicleResolver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllVehicles() {
        // Mockando a lista de veículos
        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", "Branco", "ABC1234", "Carro");
        Vehicle vehicle2 = new Vehicle("Honda", "Civic", "Preto", "XYZ9876", "Carro");
        List<Vehicle> vehicles = Arrays.asList(vehicle1, vehicle2);

        // Definindo o comportamento do mock
        when(vehicleService.findAll()).thenReturn(vehicles);

        // Executando o método de resolver e validando a saída
        List<Vehicle> result = vehicleResolver.veiculos();
        assertEquals(2, result.size());
        assertEquals("Toyota", result.get(0).getMarca());

        // Verificando se o método do serviço foi chamado
        verify(vehicleService, times(1)).findAll();
    }

    @Test
    void testFindVehicleById() {
        // Mockando um veículo
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", "Branco", "ABC1234", "Carro");

        // Definindo o comportamento do mock
        when(vehicleService.findById(anyLong())).thenReturn(vehicle);

        // Executando o método de resolver e validando a saída
        Vehicle result = vehicleResolver.veiculo(1L);
        assertEquals("Toyota", result.getMarca());

        // Verificando se o método do serviço foi chamado
        verify(vehicleService, times(1)).findById(1L);
    }

    @Test
    void testCreateVehicle() {
        // Mockando o retorno do serviço
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", "Branco", "ABC1234", "Carro");
        when(vehicleService.create(anyString(), anyString(), anyString(), anyString(), anyString()))
            .thenReturn(vehicle);

        // Executando o método de resolver e validando a saída
        Vehicle result = vehicleResolver.criarVeiculo("Toyota", "Corolla", "Branco", "ABC1234", "Carro");
        assertEquals("Toyota", result.getMarca());

        // Verificando se o método do serviço foi chamado
        verify(vehicleService, times(1)).create(anyString(), anyString(), anyString(), anyString(), anyString());
    }

    @Test
    void testUpdateVehicle() {
        // Mockando o retorno do serviço
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", "Branco", "ABC1234", "Carro");
        when(vehicleService.update(anyLong(), anyString(), anyString(), anyString(), anyString(), anyString()))
            .thenReturn(vehicle);

        // Executando o método de resolver e validando a saída
        Vehicle result = vehicleResolver.atualizarVeiculo(1L, "Toyota", "Corolla", "Branco", "ABC1234", "Carro");
        assertEquals("Toyota", result.getMarca());

        // Verificando se o método do serviço foi chamado
        verify(vehicleService, times(1))
            .update(anyLong(), anyString(), anyString(), anyString(), anyString(), anyString());
    }

    @Test
    void testDeleteVehicle() {
        // Mockando o retorno do serviço
        when(vehicleService.delete(anyLong())).thenReturn(true);

        // Executando o método de resolver e validando a saída
        boolean result = vehicleResolver.deletarVeiculo(1L);
        assertEquals(true, result);

        // Verificando se o método do serviço foi chamado
        verify(vehicleService, times(1)).delete(anyLong());
    }
}
