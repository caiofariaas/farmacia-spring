package com.remedios.caio.security.services;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.remedios.caio.entities.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    // Indica que estamos utilizando o valor definido em 'properties'

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario){
        try {
            return JWT.create()
                    .withIssuer("remedios_api")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(Expirar())
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException e){
            throw new RuntimeException("Erro ao gerar Token", e);
        }
    }

    // Função que retorna a hora atual mais 2 horas
    // usada para determinar ciclo de vida do Token

    private Instant Expirar() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
