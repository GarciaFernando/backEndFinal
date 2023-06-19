package com.company.ClinicaOdontologicaV1.controller;


import com.company.ClinicaOdontologicaV1.dto.OdontologoDTO;
import com.company.ClinicaOdontologicaV1.dto.TurnoDTO;
import com.company.ClinicaOdontologicaV1.entity.Odontologo;
import com.company.ClinicaOdontologicaV1.entity.Turno;
import com.company.ClinicaOdontologicaV1.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoService turnoService;


    @PostMapping("/agregar")
    public ResponseEntity<?> agregarTurno(@RequestBody Turno turno){
        turnoService.guardar(turno);
        return ResponseEntity.ok("Turno agregado");
    }
    @GetMapping("/listar")
    public ResponseEntity<List<TurnoDTO>> obtenerTurnos(){
        return ResponseEntity.ok(turnoService.mostrarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarPorId(@PathVariable Long id)throws Exception{
        return ResponseEntity.ok(turnoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        ResponseEntity<?>response = null;
        turnoService.eliminar(id);
        response =ResponseEntity.status(HttpStatus.OK).body("Odontologo "+id+" eliminado.");
        return response;
    }
    @PostMapping("/agregarLista")
    public ResponseEntity<?> agregarLista(@RequestBody List<Turno> listTurno){
        for(Turno t: listTurno){
            turnoService.guardar(t);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Lista agregada");
    }





}
