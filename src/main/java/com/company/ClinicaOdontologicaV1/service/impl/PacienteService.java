package com.company.ClinicaOdontologicaV1.service.impl;


import com.company.ClinicaOdontologicaV1.dto.PacienteDTO;
import com.company.ClinicaOdontologicaV1.entity.Paciente;
import com.company.ClinicaOdontologicaV1.exceptions.ResourceNotFoundException;
import com.company.ClinicaOdontologicaV1.repository.IPacienteRepository;
import com.company.ClinicaOdontologicaV1.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    private final IPacienteRepository pacienteRepository;
    private final ObjectMapper mapper;
    private static final Logger LOGGER = Logger.getLogger(PacienteService.class);

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
        this.mapper = new ObjectMapper();
    }

    @Override
    public void guardar(Paciente paciente) {
        paciente.setFechaIngreso(LocalDate.now());
        pacienteRepository.save(paciente);
        LOGGER.info("Nuevo paciente registrado con exito.");
    }

    @Override
    public PacienteDTO buscarPorId(Long id) throws ResourceNotFoundException {
        mapper.registerModule(new JavaTimeModule());
        Paciente encontrado =pacienteRepository.findById(id).orElse(null);
        if(encontrado!=null){
            LOGGER.info("paciente encontrado: "+encontrado);
            return mapper.convertValue(encontrado,PacienteDTO.class);
        }else{
            LOGGER.error("El id="+id+" del paciente no se encuentra en la base de datos.");
            throw new ResourceNotFoundException("Paciente no encontrado");
        }
    }

    @Override
    public void modificar(Paciente paciente) throws ResourceNotFoundException {
        if(buscarPorId(paciente.getId())!=null){
            LOGGER.info("paciente "+paciente.getId()+" modificado con exito.");
            guardar(paciente);
        }else{
            LOGGER.error("No se pudo modificar el paciente de id: "+paciente.getId());
        }
    }

    @Override
    public void eliminar(Long id) throws ResourceNotFoundException {
        if(buscarPorId(id)!=null){
            pacienteRepository.deleteById(id);
            LOGGER.warn("paciente id: "+id+" eliminado con exito.");
        }else{
            LOGGER.error("No se pudo eliminar el paciente de id: "+id);
        }

    }

    @Override
    public List<PacienteDTO> mostrarTodos() {
        mapper.registerModule(new JavaTimeModule());
        List<PacienteDTO> listaDTO= new ArrayList<>();
        for(Paciente p : pacienteRepository.findAll()){
            System.out.println(p.getDomicilio());
            listaDTO.add(mapper.convertValue(p,PacienteDTO.class));
        }
        LOGGER.info("Se solicito la lista de todos los pacientes.");
        return listaDTO;
    }
}