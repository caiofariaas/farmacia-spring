package com.remedios.caio.security.services;

import com.remedios.caio.entities.Usuario;
import com.remedios.caio.exceptions.NotFoundException;
import com.remedios.caio.security.dtos.AuthenticationDTO;
import com.remedios.caio.security.dtos.TokenJwtDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager manager;

    // TRATAR EXCEÇÕES

    public TokenJwtDTO loginAndCreateToken(AuthenticationDTO dados){
        try {
            Authentication autenticacao = manager.authenticate(new UsernamePasswordAuthenticationToken(dados.login(), dados.senha()));
            Usuario usuario = (Usuario) autenticacao.getPrincipal();
            String tokenJWT = tokenService.gerarToken(usuario);

            return new TokenJwtDTO(tokenJWT);
        }
        catch (BadCredentialsException e){
            throw new BadCredentialsException("Credenciais incorretas. Verifique seu login e senha.");

        }
        catch (AuthenticationException e){
            throw new RuntimeException("Erro durante a autenticação.");
        }
    }
}
