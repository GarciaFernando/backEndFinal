package com.company.ClinicaOdontologicaV1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "odontologos")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Odontologo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Size(max=30, message= "Nombre maximo 30 caracteres.")
    @NotNull(message = "El nombre no debe ser nulo.")
    @NotBlank(message = "El nombre no debe estar en blanco.")
    private String nombre;
    @Size(max=30, message= "Apellido maximo 30 caracteres.")
    @NotNull(message = "El apellido no debe ser nulo.")
    @NotBlank(message = "El apellido no debe estar en blanco.")
    private String apellido;
    @Size(max=15, message= "Matricula maximo 15 caracteres.")
    @NotNull(message = "La matricula no debe ser nulo.")
    @NotBlank(message = "La matricula no debe estar en blanco.")
    private String matricula;

    @OneToMany(mappedBy = "odontologo",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Turno> turnos;

    public Odontologo(String nombre, String apellido, String matricula, List<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.turnos = turnos;
    }

}