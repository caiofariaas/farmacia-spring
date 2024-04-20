package com.remedios.caio.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.remedios.caio.entities.Usuario;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    public String gerarToken(Usuario usuario){
        try {

            var algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("remedios_api")
                    .withSubject(usuario.getLogin())
//                    .withClaim("id", usuario.getId())
                    .withExpiresAt(dataExpirar())
                    .sign(algorithm);

        } catch (JWTCreationException e){
            throw new RuntimeException("Erro ao gerar Token", e);
        }
    }

    private Instant dataExpirar() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }

}
