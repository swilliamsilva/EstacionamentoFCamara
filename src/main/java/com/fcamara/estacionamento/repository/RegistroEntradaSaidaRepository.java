package com.fcamara.estacionamento.repository;

import com.fcamara.estacionamento.model.RegistroEntradaSaida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEntradaSaidaRepository extends JpaRepository<RegistroEntradaSaida, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}
