package com.company.ClinicaOdontologicaV1.service.impl;


import com.company.ClinicaOdontologicaV1.dto.PacienteDTO;
import com.company.ClinicaOdontologicaV1.entity.Paciente;
import com.company.ClinicaOdontologicaV1.repository.IPacienteRepository;
import com.company.ClinicaOdontologicaV1.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    private final IPacienteRepository pacienteRepository;
    private final ObjectMapper mapper;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
        this.mapper = new ObjectMapper();
    }

    @Override
    public void guardar(Paciente paciente) {
        paciente.setFechaIngreso(LocalDate.now());
        pacienteRepository.save(paciente);
    }

    @Override
    public PacienteDTO buscarPorId(Long id) throws Exception {
        mapper.registerModule(new JavaTimeModule());
        Paciente encontrado =pacienteRepository.findById(id).orElse(null);
        if(encontrado!=null){
            return mapper.convertValue(encontrado,PacienteDTO.class);
        }else{
            throw new Exception("Paciente no encontrado");
        }
    }

    @Override
    public void modificar(Paciente paciente) {
        guardar(paciente);
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public List<PacienteDTO> mostrarTodos() {
        mapper.registerModule(new JavaTimeModule());
        List<PacienteDTO> listaDTO= new ArrayList<>();
        for(Paciente p : pacienteRepository.findAll()){
            System.out.println(p.getDomicilio());
            listaDTO.add(mapper.convertValue(p,PacienteDTO.class));
        }
        return listaDTO;
    }
}