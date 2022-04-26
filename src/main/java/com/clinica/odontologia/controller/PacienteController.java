package com.clinica.odontologia.controller;

import com.clinica.odontologia.model.dto.PacienteDTO;
import com.clinica.odontologia.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.crearPaciente(pacienteDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPaciente(@PathVariable Integer id){

        return pacienteService.buscarPaciente(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){

        pacienteService.modificarPaciente(pacienteDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Integer id){

        pacienteService.eliminarPaciente(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<PacienteDTO> buscarTodos(){

        return pacienteService.buscarTodos();
    }

}
