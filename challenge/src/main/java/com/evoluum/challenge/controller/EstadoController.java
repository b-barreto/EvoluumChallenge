package com.evoluum.challenge.controller;

import com.evoluum.challenge.model.Estado;
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

    @GetMapping
    public Collection<Estado> list(){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ArrayList<Estado>> response = restTemplate.exchange(
                "https://servicodados.ibge.gov.br/api/v1/localidades/estados",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ArrayList<Estado>>() {});

        return response.getBody();

    }
}
