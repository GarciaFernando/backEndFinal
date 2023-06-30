package com.company.ClinicaOdontologicaV1.service.impl;

import com.company.ClinicaOdontologicaV1.dto.TurnoDTO;
import com.company.ClinicaOdontologicaV1.entity.Turno;
import com.company.ClinicaOdontologicaV1.exceptions.ResourceNotFoundException;
import com.company.ClinicaOdontologicaV1.repository.ITurnoRepository;
import com.company.ClinicaOdontologicaV1.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    private final ITurnoRepository turnoRepository;
    private final ObjectMapper mapper;
    private static final Logger LOGGER = Logger.getLogger(TurnoService.class);

    @Autowired
    public TurnoService(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
        this.mapper = new ObjectMapper();
    }

    @Override
    public void guardar(Turno turno) {
        turnoRepository.save(turno);
        LOGGER.info("Nuevo turno registrado con exito.");
    }

    public TurnoDTO buscarPorId(Long id)throws ResourceNotFoundException {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); // Se utiliza para solucionar el error "SerializationFeature.FAIL_ON_EMPTY_BEANS)"

        Turno turno = turnoRepository.findById(id).orElse(null);
        if(turno!=null){
            LOGGER.info("turno encontrado: "+turno);
            return mapper.convertValue(turnoRepository.findById(id),TurnoDTO.class);
        }else {
            LOGGER.error("El id="+id+" del turno no se encuentra en la base de datos.");
            throw new ResourceNotFoundException("Turno no encontrado");
        }

    }
    //Metodo no utilizado por la logica de "Sacar un turno", considero que es muy raro modificar un turno. Si se quiere modificar, se elimina y se saca un nuevo turno.
    public void modificar(Turno turno){
        guardar(turno);
    }

    public void eliminar(Long id) throws ResourceNotFoundException {
        if(buscarPorId(id)!=null){
            turnoRepository.deleteById(id);
            LOGGER.warn("turno id: "+id+" eliminado con exito.");
        }else{
            LOGGER.error("No se pudo eliminar el turno de id: "+id);
        }

    }

    @Override
    public List<TurnoDTO> mostrarTodos(){
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); // Se utiliza para solucionar el error "SerializationFeature.FAIL_ON_EMPTY_BEANS)"
        List<TurnoDTO> listaDTO = new ArrayList<>();
        for(Turno turno : turnoRepository.findAll()){
            listaDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        LOGGER.info("Se solicito la lista de todos los turnos.");
        return listaDTO;
    }
}
