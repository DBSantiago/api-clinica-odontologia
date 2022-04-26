package com.clinica.odontologia.service.impl;

import com.clinica.odontologia.model.Paciente;
import com.clinica.odontologia.model.dto.PacienteDTO;
import com.clinica.odontologia.repository.IPacienteRepository;
import com.clinica.odontologia.service.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;

    private void guardarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = new Paciente();

        paciente.setId(pacienteDTO.getId());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setDni(pacienteDTO.getDni());
        paciente.setDomicilio(pacienteDTO.getDomicilio());
        paciente.setFecha(pacienteDTO.getFecha());

        pacienteRepository.save(paciente);

    }

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) {
        this.guardarPaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO buscarPaciente(Integer id) {

        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;

        if(paciente.isPresent()){
            pacienteDTO = new PacienteDTO();
            pacienteDTO.setId(paciente.get().getId());
            pacienteDTO.setNombre(paciente.get().getNombre());
            pacienteDTO.setApellido(paciente.get().getApellido());
            pacienteDTO.setDni(paciente.get().getDni());
            pacienteDTO.setDomicilio(paciente.get().getDomicilio());
            pacienteDTO.setFecha(paciente.get().getFecha());
        }

        return pacienteDTO;
    }

    @Override
    public Set<PacienteDTO> buscarTodos() {

        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        for(Paciente paciente: pacientes){
            PacienteDTO pacienteDTO = new PacienteDTO();

            pacienteDTO.setId(paciente.getId());
            pacienteDTO.setNombre(paciente.getNombre());
            pacienteDTO.setApellido(paciente.getApellido());
            pacienteDTO.setDni(paciente.getDni());
            pacienteDTO.setDomicilio(paciente.getDomicilio());
            pacienteDTO.setFecha(paciente.getFecha());

            pacientesDTO.add(pacienteDTO);
        }

        return pacientesDTO;
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        this.guardarPaciente(pacienteDTO);
    }

    @Override
    public void eliminarPaciente(Integer id) {
        pacienteRepository.deleteById(id);
    }
}
