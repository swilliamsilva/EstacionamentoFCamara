package com.fcamara.estacionamento.dto;

public class LoginRequest {
    private String username;
    private String password;

    // Construtor vazio (necessário para deserialização)
    public LoginRequest() {}

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
