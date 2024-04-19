package com.remedios.caio.services;

import com.remedios.caio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // USER DETAILS

    // TODO
    //  VERIFICAR NECESSIDADE DE DTO

    public UserDetails getByLogin(String login){
        return repository.findByLogin(login);
    }

}
