package com.clinica.odontologia.service;

import com.clinica.odontologia.model.dto.DomicilioDTO;

import java.util.Set;

public interface IDomicilioService {

    void crearDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO buscarDomicilio(Integer id);
    Set<DomicilioDTO> buscarTodos();
    void modificarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(Integer id);

}
