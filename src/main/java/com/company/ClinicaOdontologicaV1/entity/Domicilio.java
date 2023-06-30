package com.company.ClinicaOdontologicaV1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "domicilios")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max=10, message= "Numero maximo 10 caracteres.")
    @NotNull(message = "El numero no debe ser nulo.")
    @NotBlank(message = "El numero no debe estar en blanco.")
    private String numero;
    @Size(max=30, message= "Calle maximo 30 caracteres.")
    @NotNull(message = "La calle no debe ser nulo.")
    @NotBlank(message = "La calle no debe estar en blanco.")
    private String calle;
    @Size(max=30, message= "Localidad maximo 30 caracteres.")
    @NotNull(message = "La localidad no debe ser nulo.")
    @NotBlank(message = "La localidad no debe estar en blanco.")
    private String localidad;
    @Size(max=30, message= "Provincia maximo 30 caracteres.")
    @NotNull(message = "La provincia no debe ser nulo.")
    @NotBlank(message = "La provincia no debe estar en blanco.")
    private String provincia;

    public Domicilio(String numero, String calle, String localidad, String provincia) {
        this.numero = numero;
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
