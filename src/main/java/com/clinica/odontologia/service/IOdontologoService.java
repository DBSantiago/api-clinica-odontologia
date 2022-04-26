package com.clinica.odontologia.service;

import com.clinica.odontologia.model.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO buscarOdontologo(Integer id);
    Set<OdontologoDTO> buscarTodos();
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Integer id);

}
