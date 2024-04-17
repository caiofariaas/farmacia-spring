package com.remedios.caio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UsuarioService service;


    // Este método é utilizado para carregar os detalhes do usuário a partir de um nome de usuário fornecido.
    //

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return service.getByLogin(login);
    }
}
