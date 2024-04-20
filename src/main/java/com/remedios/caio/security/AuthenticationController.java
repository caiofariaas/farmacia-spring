package com.remedios.caio.security;

import com.remedios.caio.security.dtos.AuthenticationDTO;
import com.remedios.caio.security.dtos.TokenJwtDTO;
import com.remedios.caio.security.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<TokenJwtDTO> login(@RequestBody @Valid AuthenticationDTO dados){
        return ResponseEntity.ok(authService.loginAndCreateToken(dados));
    }
}
