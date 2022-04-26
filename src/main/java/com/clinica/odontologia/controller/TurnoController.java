package com.clinica.odontologia.controller;

import com.clinica.odontologia.model.dto.TurnoDTO;
import com.clinica.odontologia.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.crearTurno(turnoDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO buscarTurno(@PathVariable Integer id){

        return turnoService.buscarTurno(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Integer id){

        turnoService.eliminarTurno(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<TurnoDTO> buscarTodos(){

        return turnoService.buscarTodos();
    }

}
