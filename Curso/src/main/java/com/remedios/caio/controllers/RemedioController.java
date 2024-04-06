package com.remedios.caio.controllers;

import com.remedios.caio.dtos.RemedioDTO;
import com.remedios.caio.entities.Remedio;
import com.remedios.caio.services.RemedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    // O Autowired instancia um objeto da classe indicada
    // Isso tira a necessidade de declarar um objeto em cada método que desejamos usa-lo

    @Autowired
    private RemedioService service;

    @PostMapping
    public ResponseEntity<Remedio> createRemedio(@RequestBody RemedioDTO dados){

        Remedio newRemedio =  service.createRemedio(dados);

        return new ResponseEntity<>(newRemedio, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Remedio>> getAllRemedios(){

        List<Remedio> remedios = this.service.getAllRemedios();
        return new ResponseEntity<>(remedios, HttpStatus.OK);

    }
}
