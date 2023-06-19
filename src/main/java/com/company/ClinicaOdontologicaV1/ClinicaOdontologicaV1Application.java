package com.company.ClinicaOdontologicaV1;

import com.company.ClinicaOdontologicaV1.entity.Domicilio;
import com.company.ClinicaOdontologicaV1.entity.Odontologo;
import com.company.ClinicaOdontologicaV1.entity.Paciente;
import com.company.ClinicaOdontologicaV1.repository.IDomicilioRepository;
import com.company.ClinicaOdontologicaV1.repository.IOdontologoRepository;
import com.company.ClinicaOdontologicaV1.service.IOdontologoService;
import com.company.ClinicaOdontologicaV1.service.impl.OdontologoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class ClinicaOdontologicaV1Application {
	/*@Autowired
	private static IOdontologoRepository odontologoRepository;
	@Autowired
	private static IOdontologoService odontologoService;*/

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaV1Application.class, args);
		/*Odontologo o = new Odontologo("Garcia","Fernando","12345",new ArrayList<>());
		Domicilio d = new Domicilio("123","Castellanos","Rosario","Santa Fe");
		Paciente p = new Paciente("Rodriguez","Carlos","12345678","example@gmail.com",d,null, LocalDate.now());
		odontologoService.guardar(o);*/


	}

}
