package com.evoluum.challenge.model;

import com.evoluum.challenge.controller.EstadoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class CidadeCustomized {

    Logger logger = LoggerFactory.getLogger(CidadeCustomized.class);

    private Long idEstado;
    private String siglaEstado;
    private String regiaoNome;
    private String nomeCidade;
    private String nomeMesorregiao;
    private String nomeFormatado;

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public String getRegiaoNome() {
        return regiaoNome;
    }

    public void setRegiaoNome(String regiaoNome) {
        this.regiaoNome = regiaoNome;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getNomeMesorregiao() {
        return nomeMesorregiao;
    }

    public void setNomeMesorregiao(String nomeMesorregiao) {
        this.nomeMesorregiao = nomeMesorregiao;
    }

    public String getNomeFormatado() {
        return nomeFormatado;
    }

    public void setNomeFormatado(String nomeFormatado) {
        this.nomeFormatado = nomeFormatado;
    }

    public ArrayList<CidadeCustomized> customizeCidade(ArrayList<Cidade> cidades ){

        logger.info("Calling CidadeCustomized.customizeCidade(cidades)");

        ArrayList<CidadeCustomized> listOfCidadesCustomized = new ArrayList<>();

        cidades.forEach(cidade -> {
            CidadeCustomized cidadeCustomized = new CidadeCustomized();
            cidadeCustomized.setIdEstado(cidade.getMicrorregiao().getMesorregiao().getUf().getId());
            cidadeCustomized.setSiglaEstado(cidade.getMicrorregiao().getMesorregiao().getUf().getSigla());
            cidadeCustomized.setRegiaoNome(cidade.getMicrorregiao().getMesorregiao().getUf().getRegiao().getNome());
            cidadeCustomized.setNomeCidade(cidade.getNome());
            cidadeCustomized.setNomeMesorregiao(cidade.getMicrorregiao().getMesorregiao().getNome());
            cidadeCustomized.setNomeFormatado(cidadeCustomized.getNomeCidade()+"/"+cidadeCustomized.getSiglaEstado());

            listOfCidadesCustomized.add(cidadeCustomized);
        });

        logger.info("listOfCidadesCustomized returned ");
        return listOfCidadesCustomized;
    }
}
