package com.clinica.odontologia.service.impl;


import com.clinica.odontologia.model.Domicilio;
import com.clinica.odontologia.model.dto.DomicilioDTO;


import com.clinica.odontologia.repository.IDomicilioRepository;
import com.clinica.odontologia.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {

    @Autowired
    IDomicilioRepository domicilioRepository;

    private void guardarDomicilio(DomicilioDTO domicilioDTO){

        Domicilio domicilio = new Domicilio();
        domicilio.setId(domicilioDTO.getId());
        domicilio.setCalle(domicilioDTO.getCalle());
        domicilio.setNumero(domicilioDTO.getNumero());
        domicilio.setLocalidad(domicilioDTO.getLocalidad());
        domicilio.setProvincia(domicilioDTO.getProvincia());

        domicilioRepository.save(domicilio);
    }

    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public DomicilioDTO buscarDomicilio(Integer id) {

        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;

        if(domicilio.isPresent()){
            domicilioDTO = new DomicilioDTO();
            domicilioDTO.setId(domicilio.get().getId());
            domicilioDTO.setCalle(domicilio.get().getCalle());
            domicilioDTO.setNumero(domicilio.get().getNumero());
            domicilioDTO.setLocalidad(domicilio.get().getLocalidad());
            domicilioDTO.setProvincia(domicilio.get().getProvincia());
        }

        return domicilioDTO;
    }

    @Override
    public Set<DomicilioDTO> buscarTodos() {

        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domiciliosDTO = new HashSet<>();

        for(Domicilio domicilio: domicilios){
            DomicilioDTO domicilioDTO = new DomicilioDTO();

            domicilioDTO.setId(domicilio.getId());
            domicilioDTO.setCalle(domicilio.getCalle());
            domicilioDTO.setNumero(domicilio.getNumero());
            domicilioDTO.setLocalidad(domicilio.getLocalidad());
            domicilioDTO.setProvincia(domicilio.getProvincia());

            domiciliosDTO.add(domicilioDTO);
        }

        return domiciliosDTO;
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public void eliminarDomicilio(Integer id) {
        domicilioRepository.deleteById(id);
    }
}
