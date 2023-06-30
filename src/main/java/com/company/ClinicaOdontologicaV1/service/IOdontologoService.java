package com.company.ClinicaOdontologicaV1.service;

import com.company.ClinicaOdontologicaV1.dto.OdontologoDTO;
import com.company.ClinicaOdontologicaV1.entity.Odontologo;
import com.company.ClinicaOdontologicaV1.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {
    void guardar(Odontologo odontologo);
    OdontologoDTO buscarPorId(Long id) throws ResourceNotFoundException;
    void modificar(Odontologo odontologo) throws ResourceNotFoundException;
    void eliminar(Long id) throws ResourceNotFoundException;
    List<OdontologoDTO> mostrarTodos();

}
