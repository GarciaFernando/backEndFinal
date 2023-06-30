package com.company.ClinicaOdontologicaV1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pacientes")
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Paciente {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Size(max=30, message= "Apellido maximo 30 caracteres.")
    @NotNull(message = "El apellido no debe ser nulo.")
    @NotBlank(message = "El apellido no debe estar en blanco.")
    private String apellido;
    @Size(max=30, message= "Nombre maximo 30 caracteres.")
    @NotNull(message = "El nombre no debe ser nulo.")
    @NotBlank(message = "El nombre no debe estar en blanco.")
    private String nombre;
    @Pattern(regexp="^[0-9]{1,15}$",message = "El dni solo debe tener caracteres numericos.")
    @NotNull(message = "El dni no debe ser nulo.")
    @NotBlank(message = "El dni no debe estar en blanco.")
    private String dni;
    @Size(max=50,message = "Email maximo 50 caracteres.")
    private String email;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="domicilio_id")
    private Domicilio domicilio;

    //@JsonFormat (shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    public Paciente(String apellido, String nombre, String dni, String email, Domicilio domicilio, LocalDate fechaIngreso) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.domicilio = domicilio;
        this.fechaIngreso = fechaIngreso;
    }

}
