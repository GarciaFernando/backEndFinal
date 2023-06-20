package com.company.ClinicaOdontologicaV1.service.impl;

import com.company.ClinicaOdontologicaV1.entity.Domicilio;
import com.company.ClinicaOdontologicaV1.repository.IDomicilioRepository;
import com.company.ClinicaOdontologicaV1.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService implements IDomicilioService {
    private final IDomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioService(IDomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public Long guardar(Domicilio domicilio) {
        domicilioRepository.save(domicilio);

        return domicilio.getId();
    }

    @Override
    public Domicilio buscarPorId(Long id) throws Exception {
       Domicilio encontrado =domicilioRepository.findById(id).orElse(null);
        if(encontrado!=null){
            return encontrado;
        }else{
            throw new Exception("Domicilio no encontrado");
        }
    }

    @Override
    public void modificar(Domicilio domicilio) {
        guardar(domicilio);

    }

    @Override
    public void eliminar(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public List<Domicilio> mostrarTodos(){
        return domicilioRepository.findAll();
    }
}
