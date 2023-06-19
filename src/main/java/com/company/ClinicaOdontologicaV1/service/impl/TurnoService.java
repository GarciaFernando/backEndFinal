package com.company.ClinicaOdontologicaV1.service.impl;

import com.company.ClinicaOdontologicaV1.dto.TurnoDTO;
import com.company.ClinicaOdontologicaV1.entity.Turno;
import com.company.ClinicaOdontologicaV1.repository.ITurnoRepository;
import com.company.ClinicaOdontologicaV1.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    private final ITurnoRepository turnoRepository;
    private final ObjectMapper mapper;

    @Autowired
    public TurnoService(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
        this.mapper = new ObjectMapper();
    }

    @Override
    public void guardar(Turno turno) {
        System.out.println(turno.getOdontologo());
        turnoRepository.save(turno);
    }

    public TurnoDTO buscarPorId(Long id)throws Exception{
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); // Se utiliza para solucionar el error "SerializationFeature.FAIL_ON_EMPTY_BEANS)"

        Turno turno = turnoRepository.findById(id).orElse(null);
        if(turno!=null){
            return mapper.convertValue(turnoRepository.findById(id),TurnoDTO.class);
        }else {
            throw new Exception("Turno no encontrado");
        }

    }
    public void modificar(Turno turno){
        guardar(turno);
    }

    public void eliminar(Long id){
        turnoRepository.deleteById(id);
    }

    @Override
    public List<TurnoDTO> mostrarTodos(){
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); // Se utiliza para solucionar el error "SerializationFeature.FAIL_ON_EMPTY_BEANS)"
        List<TurnoDTO> listaDTO = new ArrayList<>();
        for(Turno turno : turnoRepository.findAll()){
            listaDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        return listaDTO;
    }
}
