package com.evoluum.challenge;

import com.evoluum.challenge.controller.CidadeController;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CidadeControllerTests {

    @Test
    public void testCidadeController() {
        CidadeController cidadeController = new CidadeController();
        List result = (List) cidadeController.listCidades();
        //According to Wikipedia, Brazil has 5570 cities.
        assertEquals(5570,result.size());
    }

}
