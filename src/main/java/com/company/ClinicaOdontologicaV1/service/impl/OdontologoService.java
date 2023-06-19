package com.company.ClinicaOdontologicaV1.service.impl;
import com.company.ClinicaOdontologicaV1.dto.OdontologoDTO;
import com.company.ClinicaOdontologicaV1.entity.Odontologo;
import com.company.ClinicaOdontologicaV1.repository.IOdontologoRepository;
import com.company.ClinicaOdontologicaV1.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OdontologoService implements IOdontologoService {

    private final IOdontologoRepository odontologoRepository;
    private final ObjectMapper mapper;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
        this.mapper = new ObjectMapper();
    }

    public void guardar (Odontologo o){
        odontologoRepository.save(o);
    }


    public List<OdontologoDTO> mostrarTodos(){
        List<OdontologoDTO> listaDTO= new ArrayList<>();
        for(Odontologo o : odontologoRepository.findAll()){
            listaDTO.add(mapper.convertValue(o,OdontologoDTO.class));
        }
        return listaDTO;
    }
    /*
    public List<OdontologoDTO> buscarPorNombre(String nombre){
        List<Odontologo> listaOdontologos = odontologoRepository.buscarOdontologosPorNombre(nombre);
        List<OdontologoDTO> listaDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for(Odontologo o : listaOdontologos){
            listaDTO.add(mapper.convertValue(o,OdontologoDTO.class));
        }
        return listaDTO;
    }*/

    public OdontologoDTO buscarPorId(Long id) throws Exception {
        Odontologo encontrado =odontologoRepository.findById(id).orElse(null);
        if(encontrado!=null){
            return mapper.convertValue(encontrado,OdontologoDTO.class);
        }else{
            throw new Exception("Odontologo no encontrado");
        }
    }

    @Override
    public void modificar(Odontologo odontologo) {
        guardar(odontologo);
    }
    @Override
    public void eliminar(Long id) {
        odontologoRepository.deleteById(id);
    }



}