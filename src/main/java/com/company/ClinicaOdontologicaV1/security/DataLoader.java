package com.company.ClinicaOdontologicaV1.security;

import com.company.ClinicaOdontologicaV1.entity.Rol;
import com.company.ClinicaOdontologicaV1.entity.Usuario;
import com.company.ClinicaOdontologicaV1.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final IUsuarioRepository usuarioRepository;

    @Autowired
    public DataLoader(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordAdmin = bCryptPasswordEncoder.encode("admin");
        String passwordUser = bCryptPasswordEncoder.encode("user");

        usuarioRepository.save(new Usuario("Administrador","admin","admin@clinica.com",passwordAdmin, Rol.ADMIN));
        usuarioRepository.save(new Usuario("Usuario","user","user@clinica.com",passwordUser,Rol.USER));



    }
}
