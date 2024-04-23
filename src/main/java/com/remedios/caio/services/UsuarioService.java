package com.remedios.caio.services;

import com.remedios.caio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // USER DETAILS

    public UserDetails getByLogin(String login){

        UserDetails user = repository.findByLogin(login);

        if(user == null){
            throw new BadCredentialsException("Usuário inexistente ou senha inválida");
        }

        System.out.println("USUARIO SERVICE - " + user.getUsername());
        return user;
    }
}
