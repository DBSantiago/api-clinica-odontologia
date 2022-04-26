package com.clinica.odontologia.service;

import com.clinica.odontologia.model.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {

    void crearTurno(TurnoDTO turnoDTO);
    TurnoDTO buscarTurno(Integer id);
    Set<TurnoDTO> buscarTodos();
    void eliminarTurno(Integer id);

}
