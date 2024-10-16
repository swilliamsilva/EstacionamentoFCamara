package com.fcamara.estacionamento.model;

import jakarta.persistence.*;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cnpj;

    private String endereco;
    private String telefone;
    private int vagasMotos;
    private int vagasCarros;

    // Construtor com parâmetros
    public Estabelecimento(String nome, String cnpj, String endereco, String telefone, int vagasMotos, int vagasCarros) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.vagasMotos = vagasMotos;
        this.vagasCarros = vagasCarros;
    }

    // Construtor padrão (sem parâmetros)
    public Estabelecimento() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getVagasMotos() {
        return vagasMotos;
    }

    public void setVagasMotos(int vagasMotos) {
        this.vagasMotos = vagasMotos;
    }

    public int getVagasCarros() {
        return vagasCarros;
    }

    public void setVagasCarros(int vagasCarros) {
        this.vagasCarros = vagasCarros;
    }
}
