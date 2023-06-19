package com.company.ClinicaOdontologicaV1.controller;

import com.company.ClinicaOdontologicaV1.dto.OdontologoDTO;
import com.company.ClinicaOdontologicaV1.entity.Odontologo;
import com.company.ClinicaOdontologicaV1.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
//@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;

    @PostMapping("/agregar")
    public void agregarOdontologo(@RequestBody Odontologo odontologo){
        odontologoService.guardar(odontologo);

    }
    @GetMapping("/listar")
    public List<OdontologoDTO> obtenerOdontologos(){
        List<OdontologoDTO> listaOdontologos= odontologoService.mostrarTodos();
        return listaOdontologos;
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarPorId(@PathVariable Long id)throws Exception{
        return odontologoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        ResponseEntity<String>response = null;
        odontologoService.eliminar(id);
        response =ResponseEntity.status(HttpStatus.OK).body("Odontologo "+id+" eliminado.");
        return response;
    }
    @PostMapping("/agregarLista")
    public ResponseEntity<?> agregarLista(@RequestBody List<Odontologo> listOdontologos){
        for(Odontologo o : listOdontologos){
            odontologoService.guardar(o);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Lista agregada");
    }

}
