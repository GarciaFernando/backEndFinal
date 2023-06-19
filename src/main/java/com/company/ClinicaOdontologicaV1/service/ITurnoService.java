package com.company.ClinicaOdontologicaV1.service;


import com.company.ClinicaOdontologicaV1.dto.TurnoDTO;
import com.company.ClinicaOdontologicaV1.entity.Turno;
import java.util.List;

public interface ITurnoService {
    void guardar(Turno turno);
    TurnoDTO buscarPorId(Long id) throws Exception;
    void modificar(Turno turno);
    void eliminar(Long id);
    List<TurnoDTO> mostrarTodos();
}
