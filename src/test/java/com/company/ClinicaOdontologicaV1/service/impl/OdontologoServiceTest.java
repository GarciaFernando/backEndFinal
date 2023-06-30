package com.company.ClinicaOdontologicaV1.service.impl;

import com.company.ClinicaOdontologicaV1.dto.OdontologoDTO;
import com.company.ClinicaOdontologicaV1.entity.Odontologo;
import com.company.ClinicaOdontologicaV1.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OdontologoServiceTest {
    @Autowired
    IOdontologoService odontologoService;

    @Test
    @Order(1)
    public void testAgregarOdontologo()throws Exception{
        Odontologo o = new Odontologo("Fernando","Garcia","1234",null);
        odontologoService.guardar(o);
        assertNotNull(odontologoService.buscarPorId(1L));
    }
    @Test
    @Order(2)
    public void testModificarOdontologo() throws Exception {

        OdontologoDTO odontologoDTO = odontologoService.buscarPorId(1L);
        ObjectMapper mapper = new ObjectMapper();
        odontologoDTO.setNombre("Jorge");

        odontologoService.modificar(mapper.convertValue(odontologoDTO,Odontologo.class));
        OdontologoDTO odontologoDTO01 = odontologoService.buscarPorId(1L);
        assertEquals("Jorge",odontologoDTO01.getNombre());

    }



}