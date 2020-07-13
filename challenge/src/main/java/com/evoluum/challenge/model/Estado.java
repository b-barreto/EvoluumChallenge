package com.evoluum.challenge.model;

public class Estado {
    private Long id;
    private String sigla;
    private String nome;
    private Regiao regiao;

    public Estado() {

    }

    public Long getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }
}
