package com.remedios.caio.controllers;

import com.remedios.caio.dtos.usuarios.InUsuarioDTO;
import com.remedios.caio.dtos.usuarios.OutUsuarioDTO;
import com.remedios.caio.dtos.usuarios.UsuarioDTO;
import com.remedios.caio.services.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<OutUsuarioDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDTO> create(@RequestBody @Valid InUsuarioDTO dados, UriComponentsBuilder uriBuilder){
        UsuarioDTO usuario = service.create(dados);

        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.id()).toUri();

        return ResponseEntity.created(uri).body(usuario);
    }
}
