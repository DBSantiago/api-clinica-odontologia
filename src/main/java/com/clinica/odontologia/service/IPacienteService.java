package com.clinica.odontologia.service;

import com.clinica.odontologia.model.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO buscarPaciente(Integer id);
    Set<PacienteDTO> buscarTodos();
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Integer id);

}
