package com.evoluum.challenge.model;

public class Cidade {

    private Long id;
    private String nome;
    private MicrorRegiao microrregiao;


    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public MicrorRegiao getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(MicrorRegiao microrregiao) {
        this.microrregiao = microrregiao;
    }
}
