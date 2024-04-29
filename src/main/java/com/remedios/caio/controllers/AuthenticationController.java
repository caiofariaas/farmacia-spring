package com.remedios.caio.controllers;


import com.remedios.caio.dtos.usuarios.InUsuarioDTO;
import com.remedios.caio.dtos.usuarios.OutUsuarioDTO;
import com.remedios.caio.security.dtos.AuthenticationDTO;
import com.remedios.caio.security.dtos.TokenJwtDTO;
import com.remedios.caio.security.services.AuthenticationService;
import com.remedios.caio.security.services.AuthorizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
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
    @Operation(summary = "Fazer Login!",
            description ="Fazer Login!",
            tags = {"Usuários"},
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse( responseCode = "200",content = @Content(
                            mediaType = "application/json")),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse( responseCode = "400",content = @Content),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse( responseCode = "401",content = @Content),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse( responseCode = "404",content = @Content),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse( responseCode = "500",content = @Content),
            })
    public ResponseEntity<TokenJwtDTO> login(@RequestBody @Valid AuthenticationDTO dados){
        System.out.println("Print controller " + authService.loginAndCreateToken(dados));

        return new ResponseEntity<>(authService.loginAndCreateToken(dados), HttpStatus.OK);
    }

    @PostMapping("/register")
    @Operation(summary = "Cadastro!",
            description ="Cadastro!",
            tags = {"Usuários"},
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse( responseCode = "200",content = @Content(
                            mediaType = "application/json")),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse( responseCode = "400",content = @Content),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse( responseCode = "401",content = @Content),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse( responseCode = "404",content = @Content),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse( responseCode = "500",content = @Content),
            })
    public ResponseEntity<OutUsuarioDTO> register(@RequestBody @Valid InUsuarioDTO dados){
        return new ResponseEntity<>(authorizationService.register(dados), HttpStatus.OK);
    }
}
