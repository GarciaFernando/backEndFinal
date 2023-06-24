package com.company.ClinicaOdontologicaV1.service.impl;

import com.company.ClinicaOdontologicaV1.dto.PacienteDTO;
import com.company.ClinicaOdontologicaV1.entity.Domicilio;
import com.company.ClinicaOdontologicaV1.entity.Paciente;
import com.company.ClinicaOdontologicaV1.service.IDomicilioService;
import com.company.ClinicaOdontologicaV1.service.IPacienteService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PacienteServiceTest {

    @Autowired
    IPacienteService pacienteService;
    @Autowired
    IDomicilioService domicilioService;
/*
    @BeforeAll
    public void cargaDatos(){

    }
*/
    @Test
    @Order(1)
    public void testAgregarPaciente() throws Exception {
        Paciente p = new Paciente();
        p.setApellido("Garcia");
        p.setDni("40315587");
        p.setEmail("example@gmail.com");
        p.setNombre("Fernando");
        p.setFechaIngreso(LocalDate.now());
        Domicilio d = new Domicilio(1L,"123","Falsa","Rosario","Santa Fe");
        domicilioService.guardar(d);
        p.setDomicilio(d);

        pacienteService.guardar(p);
        PacienteDTO pDTO = pacienteService.buscarPorId(1L);
        assertNotNull(pDTO);
    }
    @Test
    @Order(2)
    public void testBuscarPorId() throws Exception {
        PacienteDTO pacienteDTO=pacienteService.buscarPorId(1L);
        assertEquals("Garcia",pacienteDTO.getApellido());
        assertEquals("Fernando",pacienteDTO.getNombre());

    }
/*
    @Test
    @Order(3)
    public void testModificar()throws Exception{
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNombre("Jorge");
        paciente.setApellido("Rodriguez");
        pacienteService.modificar(paciente);

        PacienteDTO pacienteDTO=pacienteService.buscarPorId(1L);
        assertEquals("Rodriguez",pacienteDTO.getApellido());
        assertEquals("40315587",pacienteDTO.getDni());

    }*/

    @Test
    @Order(3)
    public void testFechaIngreso() throws Exception {
        Paciente paciente = new Paciente();
        paciente.setApellido("Martinez");
        paciente.setNombre("Alberto");
        paciente.setFechaIngreso(LocalDate.now());
        pacienteService.guardar(paciente);
        PacienteDTO pDto = pacienteService.buscarPorId(2L);
        assertNotNull(pDto.getFechaIngreso());

    }



    @Test
    @Order(4)
    public void testEliminarPaciente() throws Exception {
        pacienteService.eliminar(1L);
        assertThrows(Exception.class,()->pacienteService.buscarPorId(1L));
    }

}