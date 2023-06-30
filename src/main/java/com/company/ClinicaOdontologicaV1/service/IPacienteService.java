package com.company.ClinicaOdontologicaV1.service;


import com.company.ClinicaOdontologicaV1.dto.PacienteDTO;
import com.company.ClinicaOdontologicaV1.entity.Paciente;
import com.company.ClinicaOdontologicaV1.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    void guardar(Paciente paciente);
    PacienteDTO buscarPorId(Long id) throws ResourceNotFoundException;
    void modificar(Paciente paciente) throws ResourceNotFoundException;
    void eliminar(Long id) throws ResourceNotFoundException;
    List<PacienteDTO> mostrarTodos();
}
