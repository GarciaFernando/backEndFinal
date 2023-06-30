package com.company.ClinicaOdontologicaV1.service.impl;

import com.company.ClinicaOdontologicaV1.entity.Domicilio;
import com.company.ClinicaOdontologicaV1.exceptions.ResourceNotFoundException;
import com.company.ClinicaOdontologicaV1.repository.IDomicilioRepository;
import com.company.ClinicaOdontologicaV1.service.IDomicilioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DomicilioService implements IDomicilioService {
    private final IDomicilioRepository domicilioRepository;
    private static final Logger LOGGER = Logger.getLogger(DomicilioService.class);

    @Autowired
    public DomicilioService(IDomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public Long guardar(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
        LOGGER.info("Nuevo domicilio registrado con exito.");
        return domicilio.getId();
    }

    @Override
    public Domicilio buscarPorId(Long id) throws ResourceNotFoundException{
       Domicilio encontrado =domicilioRepository.findById(id).orElse(null);
        if(encontrado!=null){
            LOGGER.info("Domicilio encontrado: "+encontrado);
            return encontrado;
        }else{
            LOGGER.error("El id="+id+" del domicilio no se encuentra en la base de datos.");
            throw new ResourceNotFoundException("Domicilio no encontrado");
        }
    }

    @Override
    public void modificar(Domicilio domicilio) throws ResourceNotFoundException {
        if(buscarPorId(domicilio.getId())!=null){
            guardar(domicilio);
            LOGGER.info("Domicilio "+domicilio.getId()+" modificado con exito.");
        }else {
            LOGGER.error("No se pudo modificar el domicilio de id: "+domicilio.getId());
        }


    }

    @Override
    public void eliminar(Long id) throws ResourceNotFoundException {
        if(buscarPorId(id)!=null){
            domicilioRepository.deleteById(id);
            LOGGER.warn("Domicilio id: "+id+" eliminado con exito.");
        }else{
            LOGGER.error("No se pudo eliminar el domicilio de id: "+id);
        }

    }

    @Override
    public List<Domicilio> mostrarTodos(){
        LOGGER.info("Se solicito la lista de todos los domicilios.");
        return domicilioRepository.findAll();
    }
}
