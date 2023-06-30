package com.company.ClinicaOdontologicaV1.service;


import com.company.ClinicaOdontologicaV1.dto.TurnoDTO;
import com.company.ClinicaOdontologicaV1.entity.Turno;
import com.company.ClinicaOdontologicaV1.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {
    void guardar(Turno turno);
    TurnoDTO buscarPorId(Long id) throws ResourceNotFoundException;
    void modificar(Turno turno);
    void eliminar(Long id) throws ResourceNotFoundException;
    List<TurnoDTO> mostrarTodos();
}
