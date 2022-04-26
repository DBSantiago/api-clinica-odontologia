package com.clinica.odontologia.service.impl;


import com.clinica.odontologia.model.Odontologo;
import com.clinica.odontologia.model.dto.OdontologoDTO;
import com.clinica.odontologia.model.dto.PacienteDTO;
import com.clinica.odontologia.repository.IOdontologoRepository;
import com.clinica.odontologia.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    IOdontologoRepository odontologoRepository;

    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = new Odontologo();
        odontologo.setId(odontologoDTO.getId());
        odontologo.setNombre(odontologoDTO.getNombre());
        odontologo.setApellido(odontologoDTO.getApellido());
        odontologo.setMatricula(odontologoDTO.getMatricula());

        odontologoRepository.save(odontologo);
    }

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO buscarOdontologo(Integer id) {

        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;

        if(odontologo.isPresent()){
            odontologoDTO = new OdontologoDTO();
            odontologoDTO.setId(odontologo.get().getId());
            odontologoDTO.setNombre(odontologo.get().getNombre());
            odontologoDTO.setApellido(odontologo.get().getApellido());
            odontologoDTO.setMatricula(odontologo.get().getMatricula());
        }

        return odontologoDTO;
    }

    @Override
    public Set<OdontologoDTO> buscarTodos() {

        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for(Odontologo odontologo: odontologos){
            OdontologoDTO odontologoDTO = new OdontologoDTO();

            odontologoDTO.setId(odontologo.getId());
            odontologoDTO.setNombre(odontologo.getNombre());
            odontologoDTO.setApellido(odontologo.getApellido());
            odontologoDTO.setMatricula(odontologo.getMatricula());

            odontologosDTO.add(odontologoDTO);
        }

        return odontologosDTO;
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Integer id) {
        odontologoRepository.deleteById(id);
    }
}
