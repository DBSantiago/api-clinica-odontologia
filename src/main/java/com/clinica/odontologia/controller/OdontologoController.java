package com.clinica.odontologia.controller;

import com.clinica.odontologia.model.dto.OdontologoDTO;
import com.clinica.odontologia.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.crearOdontologo(odontologoDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarOdontologo(@PathVariable Integer id){

        return odontologoService.buscarOdontologo(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){

        odontologoService.modificarOdontologo(odontologoDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Integer id){

        odontologoService.eliminarOdontologo(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<OdontologoDTO> buscarTodos(){

        return odontologoService.buscarTodos();
    }

}
