package com.company.ClinicaOdontologicaV1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    private String nombre;
    private String apellido;
    private String matricula;

    @OneToMany(mappedBy = "odontologo",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Turno> turnos;

    public Odontologo(String nombre, String apellido, String matricula, List<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula='" + matricula + '\'' +
                ", turnos=" + turnos +
                '}';
    }
}