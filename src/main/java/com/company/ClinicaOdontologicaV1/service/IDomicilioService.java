package com.company.ClinicaOdontologicaV1.service;

import com.company.ClinicaOdontologicaV1.entity.Domicilio;
import com.company.ClinicaOdontologicaV1.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IDomicilioService {
    Long guardar(Domicilio domicilio);
    Domicilio buscarPorId(Long id) throws ResourceNotFoundException;
    void modificar(Domicilio domicilio) throws ResourceNotFoundException;
    void eliminar(Long id) throws ResourceNotFoundException;
    List<Domicilio> mostrarTodos();
}
