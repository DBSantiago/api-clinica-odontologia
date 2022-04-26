package com.clinica.odontologia.service.impl;

import com.clinica.odontologia.model.dto.OdontologoDTO;
import com.clinica.odontologia.service.IOdontologoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    //Test para crearOdontologo y buscarOdontologo
    @Test
    @Order(1)
    void crearOdontologo() {
        OdontologoDTO odontologoDTO = new OdontologoDTO("Napoleon", "Bonaparte", 1812);

        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontologoNapoleon = odontologoService.buscarOdontologo(1);
        Assertions.assertNotNull(odontologoNapoleon);
    }

    @Test
    @Order(2)
    void modificarOdontologo() {

        OdontologoDTO odontologoDTO = odontologoService.buscarOdontologo(1);

        odontologoDTO.setApellido("Malaparte");

        odontologoService.modificarOdontologo(odontologoDTO);

        Assertions.assertSame("Malaparte", odontologoService.buscarOdontologo(1).getApellido());

    }

    @Test
    @Order(3)
    void eliminarOdontologo() {
        odontologoService.eliminarOdontologo(1);

        Assertions.assertNull(odontologoService.buscarOdontologo(1));
    }

}