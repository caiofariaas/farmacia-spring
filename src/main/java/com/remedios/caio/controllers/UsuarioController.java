package com.remedios.caio.controllers;

import com.remedios.caio.dtos.usuarios.OutUsuarioDTO;
import com.remedios.caio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
