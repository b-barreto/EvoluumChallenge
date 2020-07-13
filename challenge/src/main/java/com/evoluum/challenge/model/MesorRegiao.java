package com.evoluum.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MesorRegiao {

    private Long id;
    private String nome;
    @JsonProperty("UF")
    private Estado uf;

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public Estado getUf() {
        return this.uf;
    }
}
