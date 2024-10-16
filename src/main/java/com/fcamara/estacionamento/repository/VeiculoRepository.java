package com.fcamara.estacionamento.repository;

import com.fcamara.estacionamento.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    // Você pode adicionar consultas personalizadas aqui, se necessário
}
