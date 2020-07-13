package com.evoluum.challenge.controller;

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
@RequestMapping("/estados")
public class EstadoController {

    Logger logger = LoggerFactory.getLogger(EstadoController.class);

    @GetMapping
    @Cacheable(value = "listOfEstados")
    public Object listEstados(){

        logger.info("Calling EstadoController.listEstados()");
        RestTemplate restTemplate = new RestTemplate();

        try {

            ResponseEntity<ArrayList<Estado>> response = restTemplate.exchange(
                    "https://servicodados.ibge.gov.br/api/v1/localidades/estados",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<ArrayList<Estado>>() {
                    });

            logger.info("response.getBody() returned");
            return response.getBody();

        } catch (Exception ex) {

            logger.warn("Error listEstados(), ex: " + ex);
            return "Error";

        }
    }
}
