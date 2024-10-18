package com.fcamara.estacionamento.service;

import com.fcamara.estacionamento.model.Vehicle;
import com.fcamara.estacionamento.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Método para listar todos os veículos
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    // Método para encontrar veículo pelo ID
    public Vehicle findById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return vehicle.orElse(null);
    }

    // Método para criar um novo veículo
    public Vehicle create(String marca, String modelo, String cor, String placa, String tipo) {
        Vehicle vehicle = new Vehicle(marca, modelo, cor, placa, tipo);
        return vehicleRepository.save(vehicle);
    }

    // Método para atualizar um veículo
    public Vehicle update(Long id, String marca, String modelo, String cor, String placa, String tipo) {
        Optional<Vehicle> existingVehicle = vehicleRepository.findById(id);
        if (existingVehicle.isPresent()) {
            Vehicle vehicle = existingVehicle.get();
            vehicle.setMarca(marca != null ? marca : vehicle.getMarca());
            vehicle.setModelo(modelo != null ? modelo : vehicle.getModelo());
            vehicle.setCor(cor != null ? cor : vehicle.getCor());
            vehicle.setPlaca(placa != null ? placa : vehicle.getPlaca());
            vehicle.setTipo(tipo != null ? tipo : vehicle.getTipo());
            return vehicleRepository.save(vehicle);
        }
        return null;
    }

    // Método para deletar um veículo
    public boolean delete(Long id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
