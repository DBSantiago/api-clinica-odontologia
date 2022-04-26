package com.clinica.odontologia.service.impl;

import com.clinica.odontologia.model.Domicilio;
import com.clinica.odontologia.model.dto.DomicilioDTO;
import com.clinica.odontologia.model.dto.PacienteDTO;
import com.clinica.odontologia.service.IDomicilioService;
import com.clinica.odontologia.service.IPacienteService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PacienteServiceTest {

    @Autowired
    IPacienteService pacienteService;

    @Test
    @Order(1)
    void crearPaciente() {

        Domicilio domicilio = new Domicilio("Francia","1412","Domremy","Catalina");
        Date fecha = new Date();
        PacienteDTO pacienteDTO = new PacienteDTO("Juana", "De Arco", "1234567", domicilio, fecha);
        pacienteService.crearPaciente(pacienteDTO);

        PacienteDTO pacienteJuana = pacienteService.buscarPaciente(1);

        Assertions.assertNotNull(pacienteJuana);

    }

    @Test
    @Order(2)
    void modificarPaciente(){

        PacienteDTO pacienteDTO = pacienteService.buscarPaciente(1);

        pacienteDTO.setNombre("Juanita");

        pacienteService.modificarPaciente(pacienteDTO);

        Assertions.assertSame("Juanita", pacienteService.buscarPaciente(1).getNombre());

    }


    @Test
    @Order(3)
    void eliminarPaciente() {

        pacienteService.eliminarPaciente(1);

        Assertions.assertNull(pacienteService.buscarPaciente(1));

    }
}