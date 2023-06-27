package com.company.ClinicaOdontologicaV1.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    private String apellido;
    private String nombre;
    private String dni;
    private String email;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="domicilio_id")
    private Domicilio domicilio;

    //@OneToOne
    //@JoinColumn(name = "turno_id")
    //private Turno turno;

    //@JsonFormat (shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    public Paciente(String apellido, String nombre, String dni, String email, Domicilio domicilio, /*Turno turno,*/ LocalDate fechaIngreso) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.domicilio = domicilio;
        //this.turno = turno;
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", domicilio=" + domicilio +
                //", turno=" + turno +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}
