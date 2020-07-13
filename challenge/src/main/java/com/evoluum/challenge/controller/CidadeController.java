package com.evoluum.challenge.controller;

import com.evoluum.challenge.model.Cidade;
import com.evoluum.challenge.model.CidadeCustomized;
import com.evoluum.challenge.model.Estado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    Logger logger = LoggerFactory.getLogger(CidadeController.class);

    @GetMapping
    @Cacheable(value = "listOfCidades")
    public Object listCidades(){
    logger.info("Calling CidadeController.listCidades()");


        RestTemplate restTemplate = new RestTemplate();

        EstadoController estadoController = new EstadoController();
        Collection<Estado> listOfEsdados = (Collection<Estado>) estadoController.listEstados();
        ArrayList<Cidade> listOfCidades = new ArrayList<>();

        try {

            listOfEsdados.forEach(estado -> {
                ResponseEntity<ArrayList<Cidade>> response = restTemplate.exchange(
                        "https://servicodados.ibge.gov.br/api/v1/localidades/estados/"
                                + estado.getId() + "/municipios",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ArrayList<Cidade>>() {
                        });

                listOfCidades.addAll(response.getBody());
            });

            CidadeCustomized cidadeCustomized = new CidadeCustomized();

            return cidadeCustomized.customizeCidade(listOfCidades);

        } catch (Exception ex) {
            logger.warn("Error listCidades(), ex: " + ex);
            return "Error";
        }

    }
}
