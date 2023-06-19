package com.company.ClinicaOdontologicaV1.controller;

import com.company.ClinicaOdontologicaV1.dto.PacienteDTO;
import com.company.ClinicaOdontologicaV1.entity.Odontologo;
import com.company.ClinicaOdontologicaV1.entity.Paciente;
import com.company.ClinicaOdontologicaV1.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/agregar")
    public ResponseEntity<?>agregarPaciente(@RequestBody Paciente paciente){
        pacienteService.guardar(paciente);
        return ResponseEntity.ok("Paciente agregado");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PacienteDTO>> obtenerPacientes(){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.mostrarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO>buscarPorId(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        ResponseEntity<String>response = null;
        pacienteService.eliminar(id);
        response =ResponseEntity.status(HttpStatus.OK).body("Paciente "+id+" eliminado.");
        return response;
    }

    @PostMapping("/agregarLista")
    public ResponseEntity<?> agregarLista(@RequestBody List<Paciente> listPaciente){
        for(Paciente p : listPaciente){
            pacienteService.guardar(p);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Lista agregada");
    }















/*
    @GetMapping("/email")
    public String getPacienteByEmail(@RequestParam(name="name",required = false,defaultValue = "example@gmail.com")String email, Model model){
        Paciente paciente = pacienteService.buscarPacientePorEmail(email);
        if(paciente==null) return "No se encontro paciente";
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());

        return "index";
    }*/
}
