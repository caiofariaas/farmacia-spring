package com.remedios.caio.security;


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

            var algorithm = Algorithm.HMAC256(secret);
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
