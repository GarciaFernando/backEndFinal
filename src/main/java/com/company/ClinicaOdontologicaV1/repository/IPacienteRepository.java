package com.company.ClinicaOdontologicaV1.repository;

import com.company.ClinicaOdontologicaV1.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
}
