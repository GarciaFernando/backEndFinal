package com.company.ClinicaOdontologicaV1.service;


import com.company.ClinicaOdontologicaV1.dto.PacienteDTO;
import com.company.ClinicaOdontologicaV1.entity.Paciente;
import java.util.List;

public interface IPacienteService {
    void guardar(Paciente paciente);
    PacienteDTO buscarPorId(Long id) throws Exception;
    void modificar(Paciente paciente);
    void eliminar(Long id);
    List<PacienteDTO> mostrarTodos();
}
