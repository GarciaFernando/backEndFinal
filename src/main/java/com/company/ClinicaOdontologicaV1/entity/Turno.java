package com.company.ClinicaOdontologicaV1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    @NotNull
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="odontologo_id")
    @NotNull
    private Odontologo odontologo;

    private LocalDateTime fecha;

    public Turno(Paciente paciente, Odontologo odontologo, LocalDateTime fecha) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", fecha=" + fecha +
                '}';
    }
}
