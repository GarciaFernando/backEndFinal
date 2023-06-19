package com.company.ClinicaOdontologicaV1.repository;


import com.company.ClinicaOdontologicaV1.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {/*
@Query("select o from odontologos o order by o.nombre")
List<Odontologo> mostrarTodos();

@Query("select o from odontologos o where o.nombre=?1 order by o.nombre")
List<Odontologo> buscarOdontologosPorNombre(String nombre);
*/
}
