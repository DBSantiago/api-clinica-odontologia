package com.clinica.odontologia.service.impl;


import com.clinica.odontologia.model.Turno;
import com.clinica.odontologia.model.dto.TurnoDTO;
import com.clinica.odontologia.repository.ITurnoRepository;
import com.clinica.odontologia.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    ITurnoRepository turnoRepository;

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {

        Turno turno = new Turno();
        turno.setId(turnoDTO.getId());
        turno.setPaciente(turnoDTO.getPaciente());
        turno.setOdontologo(turnoDTO.getOdontologo());
        turno.setFecha(turnoDTO.getFecha());

        turnoRepository.save(turno);

    }

    @Override
    public TurnoDTO buscarTurno(Integer id) {

        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;

        if(turno.isPresent()){
            turnoDTO = new TurnoDTO();
            turnoDTO.setId(turno.get().getId());
            turnoDTO.setPaciente(turno.get().getPaciente());
            turnoDTO.setOdontologo(turno.get().getOdontologo());
            turnoDTO.setFecha(turno.get().getFecha());
        }

        return turnoDTO;
    }

    @Override
    public Set<TurnoDTO> buscarTodos() {

        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for(Turno turno: turnos){
            TurnoDTO turnoDTO = new TurnoDTO();

            turnoDTO.setId(turno.getId());
            turnoDTO.setPaciente(turno.getPaciente());
            turnoDTO.setOdontologo(turno.getOdontologo());
            turnoDTO.setFecha(turno.getFecha());

            turnosDTO.add(turnoDTO);
        }

        return turnosDTO;
    }

    @Override
    public void eliminarTurno(Integer id) {
        turnoRepository.deleteById(id);
    }
}
