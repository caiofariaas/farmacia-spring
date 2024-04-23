package com.remedios.caio.security.services;

import com.remedios.caio.entities.Usuario;
import com.remedios.caio.security.dtos.AuthenticationDTO;
import com.remedios.caio.security.dtos.TokenJwtDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;


    public TokenJwtDTO loginAndCreateToken(AuthenticationDTO dados){

        String tokenJWT = tokenService.gerarToken((Usuario) manager.authenticate(new UsernamePasswordAuthenticationToken(dados.login(), dados.senha())).getPrincipal());

        return new TokenJwtDTO(tokenJWT);
    }
}
