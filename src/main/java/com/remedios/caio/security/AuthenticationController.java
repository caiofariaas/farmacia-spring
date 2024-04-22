package com.remedios.caio.security;

import com.remedios.caio.exceptions.NotFoundException;
import com.remedios.caio.security.dtos.AuthenticationDTO;
import com.remedios.caio.security.dtos.TokenJwtDTO;
import com.remedios.caio.security.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO dados) {
        try {
            TokenJwtDTO tokenJwtDTO = authService.loginAndCreateToken(dados);
            return new ResponseEntity<>(tokenJwtDTO, HttpStatus.OK);
        }
        catch (BadCredentialsException e) {
            return new ResponseEntity<>(Collections.singletonMap("message", e.getMessage()) , HttpStatus.UNAUTHORIZED);
        }
        catch (AuthenticationException e){
            return new ResponseEntity<>(Collections.singletonMap("message", e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(Collections.singletonMap("message", e.getMessage()) , HttpStatus.NOT_FOUND);
        }
    }
}
