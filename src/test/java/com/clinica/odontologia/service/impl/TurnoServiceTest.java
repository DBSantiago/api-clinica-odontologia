package com.clinica.odontologia.service.impl;

import com.clinica.odontologia.model.Domicilio;
import com.clinica.odontologia.model.Odontologo;
import com.clinica.odontologia.model.Paciente;
import com.clinica.odontologia.model.dto.OdontologoDTO;
import com.clinica.odontologia.model.dto.PacienteDTO;
import com.clinica.odontologia.model.dto.TurnoDTO;
import com.clinica.odontologia.service.IOdontologoService;
import com.clinica.odontologia.service.IPacienteService;
import com.clinica.odontologia.service.ITurnoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TurnoServiceTest {

    @Autowired
    ITurnoService turnoService;
    @Autowired
    IPacienteService pacienteService;
    @Autowired
    IOdontologoService odontologoService;

    @Test
    @Order(1)
    void crearTurno() {

        Domicilio domicilio1 = new Domicilio("Calle","1234","Rosario","Santa Fe");
        Date fecha = new Date();

        //Odontologo odontologo1 = new Odontologo("Peter", "Bauman",3358);
        OdontologoDTO odontologoDTO = new OdontologoDTO("Peter", "Bauman",3358);
        odontologoService.crearOdontologo(odontologoDTO);

        //Paciente paciente1 = new Paciente("Barby", "Rodriguez", "12444555", domicilio1, fecha);
        PacienteDTO pacienteDTO = new PacienteDTO("Barby", "Rodriguez", "12444555", domicilio1, fecha);
        pacienteService.crearPaciente(pacienteDTO);

        Paciente paciente = new Paciente();
        paciente.setId(pacienteService.buscarPaciente(1).getId());
        paciente.setNombre(pacienteService.buscarPaciente(1).getNombre());
        paciente.setApellido(pacienteService.buscarPaciente(1).getApellido());
        paciente.setDni(pacienteService.buscarPaciente(1).getDni());
        paciente.setDomicilio(pacienteService.buscarPaciente(1).getDomicilio());
        paciente.setFecha(pacienteService.buscarPaciente(1).getFecha());

        Odontologo odontologo = new Odontologo();
        odontologo.setId(odontologoService.buscarOdontologo(1).getId());
        odontologo.setNombre(odontologoService.buscarOdontologo(1).getNombre());
        odontologo.setApellido(odontologoService.buscarOdontologo(1).getApellido());
        odontologo.setMatricula(odontologoService.buscarOdontologo(1).getMatricula());

        TurnoDTO turnoDTO = new TurnoDTO(paciente, odontologo, fecha);


        turnoService.crearTurno(turnoDTO);

        TurnoDTO turno1 = turnoService.buscarTurno(1);

        Assertions.assertNotNull(turno1);

    }

    @Test
    @Order(2)
    void eliminarTurno() {
        turnoService.eliminarTurno(1);

        Assertions.assertNull(turnoService.buscarTurno(1));
    }

    @Test
    @Order(3)
    void limpiarDatos(){

        odontologoService.eliminarOdontologo(1);

        pacienteService.eliminarPaciente(1);

        Assertions.assertNull(odontologoService.buscarOdontologo(1));
        Assertions.assertNull(pacienteService.buscarPaciente(1));

    }

}