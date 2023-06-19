package com.company.ClinicaOdontologicaV1.service;

import com.company.ClinicaOdontologicaV1.entity.Domicilio;
import java.util.List;

public interface IDomicilioService {
    void guardar(Domicilio domicilio);
    Domicilio buscarPorId(Long id) throws Exception;
    void modificar(Domicilio domicilio);
    void eliminar(Long id);
    List<Domicilio> mostrarTodos();
}
