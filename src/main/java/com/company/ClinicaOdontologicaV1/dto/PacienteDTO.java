package com.company.ClinicaOdontologicaV1.dto;


import com.company.ClinicaOdontologicaV1.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private Domicilio domicilio;
    private LocalDate fechaIngreso;
}
