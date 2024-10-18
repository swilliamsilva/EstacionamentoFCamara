package com.fcamara.estacionamento.model;

import com.fcamara.estacionamento.service.VehicleService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final VehicleService vehicleService;

    public VehicleResolver(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Query Resolvers
    public List<Vehicle> veiculos() {
        return vehicleService.findAll();
    }

    public Vehicle veiculo(Long id) {
        return vehicleService.findById(id);
    }

    // Mutation Resolvers
    public Vehicle criarVeiculo(String marca, String modelo, String cor, String placa, String tipo) {
        return vehicleService.create(marca, modelo, cor, placa, tipo);
    }

    public Vehicle atualizarVeiculo(Long id, String marca, String modelo, String cor, String placa, String tipo) {
        return vehicleService.update(id, marca, modelo, cor, placa, tipo);
    }

    public Boolean deletarVeiculo(Long id) {
        return vehicleService.delete(id);
    }
}
