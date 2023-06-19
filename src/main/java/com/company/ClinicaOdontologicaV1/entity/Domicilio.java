package com.company.ClinicaOdontologicaV1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "domicilios")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String calle;
    private String localidad;
    private String provincia;

    public Domicilio(String numero, String calle, String localidad, String provincia) {
        this.numero = numero;
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "numero='" + numero + '\'' +
                ", calle='" + calle + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
