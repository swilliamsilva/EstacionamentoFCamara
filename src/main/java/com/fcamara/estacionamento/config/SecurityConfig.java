package com.fcamara.estacionamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Configuration
public class SecurityConfig {

    // Definir o bean de SecretKey com base na chave secreta que você tem
    @Bean
    public SecretKey secretKey() {
        // Substitua "mySecretKey" pela sua chave secreta Base64 do arquivo de propriedades
        String secret = "9iCcCLY6N+HMOBCzk3S06/z/FZYfcTITygP8j8M/OQs=";  // Use a chave secreta correta aqui
        byte[] decodedKey = Base64.getDecoder().decode(secret);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256");
    }
}
