package com.remedios.caio.security.services;

import com.remedios.caio.dtos.usuarios.InUsuarioDTO;
import com.remedios.caio.dtos.usuarios.OutUsuarioDTO;
import com.remedios.caio.entities.Usuario;
import com.remedios.caio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthorizationService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public OutUsuarioDTO register(InUsuarioDTO dados){

        Usuario usuario = new Usuario(dados, passwordEncoder.encode(dados.senha()));

        usuarioService.save(usuario);

        return new OutUsuarioDTO(usuario);
    }
}