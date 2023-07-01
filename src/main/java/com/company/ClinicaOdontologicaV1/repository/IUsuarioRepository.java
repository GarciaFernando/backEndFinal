package com.company.ClinicaOdontologicaV1.repository;

import com.company.ClinicaOdontologicaV1.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);

}
