package com.company.ClinicaOdontologicaV1.repository;

import com.company.ClinicaOdontologicaV1.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno,Long> {
}
