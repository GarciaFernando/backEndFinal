package com.company.ClinicaOdontologicaV1.controller;


import com.company.ClinicaOdontologicaV1.entity.Domicilio;
import com.company.ClinicaOdontologicaV1.service.impl.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/domicilio")
public class DomicilioController {


    @Autowired
    DomicilioService domicilioService;


    @PostMapping("/agregar")
    public ResponseEntity<?> agregarDomicilio(@RequestBody Domicilio domicilio){
        Long id = domicilioService.guardar(domicilio);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Domicilio>> obtenerDomicilio(){
        return ResponseEntity.ok(domicilioService.mostrarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> buscarPorId(@PathVariable Long id)throws Exception{
        return ResponseEntity.ok(domicilioService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id){
        ResponseEntity<?>response = null;
        domicilioService.eliminar(id);
        response =ResponseEntity.status(HttpStatus.OK).body("Domicilio "+id+" eliminado.");
        return response;
    }
    @PostMapping("/agregarLista")
    public ResponseEntity<?> agregarLista(@RequestBody List<Domicilio> listDomicilio){
        for(Domicilio d: listDomicilio){
            domicilioService.guardar(d);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Lista agregada");
    }
}
