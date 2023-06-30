package com.company.ClinicaOdontologicaV1.service.impl;
import com.company.ClinicaOdontologicaV1.dto.OdontologoDTO;
import com.company.ClinicaOdontologicaV1.entity.Odontologo;
import com.company.ClinicaOdontologicaV1.exceptions.ResourceNotFoundException;
import com.company.ClinicaOdontologicaV1.repository.IOdontologoRepository;
import com.company.ClinicaOdontologicaV1.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class OdontologoService implements IOdontologoService {

    private final IOdontologoRepository odontologoRepository;
    private final ObjectMapper mapper;
    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
        this.mapper = new ObjectMapper();
    }

    public void guardar (Odontologo o){
        odontologoRepository.save(o);
        LOGGER.info("Nuevo odontologo registrado con exito.");
    }


    public List<OdontologoDTO> mostrarTodos(){
        List<OdontologoDTO> listaDTO= new ArrayList<>();
        for(Odontologo o : odontologoRepository.findAll()){
            listaDTO.add(mapper.convertValue(o,OdontologoDTO.class));
        }
        LOGGER.info("Se solicito la lista de todos los odontologos.");
        return listaDTO;
    }

    /*
    public List<OdontologoDTO> buscarPorNombre(String nombre){
        List<Odontologo> listaOdontologos = odontologoRepository.buscarOdontologosPorNombre(nombre);
        List<OdontologoDTO> listaDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for(Odontologo o : listaOdontologos){
            listaDTO.add(mapper.convertValue(o,OdontologoDTO.class));
        }
        return listaDTO;
    }*/

    public OdontologoDTO buscarPorId(Long id) throws ResourceNotFoundException {
        Odontologo encontrado =odontologoRepository.findById(id).orElse(null);
        if(encontrado!=null){
            LOGGER.info("Odontologo encontrado: "+encontrado);
            return mapper.convertValue(encontrado,OdontologoDTO.class);
        }else{
            LOGGER.error("El id="+id+" del odontologo no se encuentra en la base de datos.");
            throw new ResourceNotFoundException("Odontologo no encontrado");
        }
    }

    @Override
    public void modificar(Odontologo odontologo) throws ResourceNotFoundException {
        if(buscarPorId(odontologo.getId())!=null){
            guardar(odontologo);
            LOGGER.info("Odontologo "+odontologo.getId()+" modificado con exito.");
        }else{
            LOGGER.error("No se pudo modificar el odontologo de id: "+odontologo.getId());
        }

    }
    @Override
    public void eliminar(Long id) throws ResourceNotFoundException {
        if(buscarPorId(id)!=null){
            odontologoRepository.deleteById(id);
            LOGGER.warn("Odontologo id: "+id+" eliminado con exito.");
        }else{
            LOGGER.error("No se pudo eliminar el odontologo de id: "+id);
        }

    }



}