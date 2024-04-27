package com.remedios.caio.controllers;


import com.remedios.caio.dtos.usuarios.InUsuarioDTO;
import com.remedios.caio.security.dtos.AuthenticationDTO;
import com.remedios.caio.security.dtos.TokenJwtDTO;
import com.remedios.caio.security.services.AuthenticationService;
import com.remedios.caio.security.services.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/login")
    public ResponseEntity<TokenJwtDTO> login(@RequestBody @Valid AuthenticationDTO dados){
        System.out.println("Print controller " + authService.loginAndCreateToken(dados));

        return new ResponseEntity<>(authService.loginAndCreateToken(dados), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid InUsuarioDTO dados){
        authorizationService.register(dados);

        return ResponseEntity.ok().build();
    }
}
