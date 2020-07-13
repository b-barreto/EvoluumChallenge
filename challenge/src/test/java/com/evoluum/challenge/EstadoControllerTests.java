package com.evoluum.challenge;

import com.evoluum.challenge.controller.EstadoController;
import org.junit.jupiter.api.Test;
import java.util.Collection;


import static org.junit.Assert.assertEquals;

public class EstadoControllerTests {

    @Test
    public void testEstadoController() {
        EstadoController estadoController = new EstadoController();
        Collection result = estadoController.list();
        //According to Wikipedia, Brazil has 27 federative units, consisting of 26 states and 1 federal district.
        assertEquals(27,result.size());
    }

}
