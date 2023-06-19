package com.company.ClinicaOdontologicaV1.service;

import com.company.ClinicaOdontologicaV1.dto.OdontologoDTO;
import com.company.ClinicaOdontologicaV1.entity.Odontologo;
import java.util.List;

public interface IOdontologoService {
    void guardar(Odontologo odontologo);
    OdontologoDTO buscarPorId(Long id) throws Exception;
    void modificar(Odontologo odontologo);
    void eliminar(Long id);
    List<OdontologoDTO> mostrarTodos();

}
