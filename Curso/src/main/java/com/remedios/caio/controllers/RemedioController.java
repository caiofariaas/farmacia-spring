package com.remedios.caio.controllers;

import com.remedios.caio.dtos.OutRemedioDTO;
import com.remedios.caio.dtos.InRemedioDTO;
import com.remedios.caio.entities.Remedio;
import com.remedios.caio.services.RemedioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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

    // Valid mostra que os dados precisam estar validados

    // Transactional - Faz com que se caso algum erro acontecer nesta requisição ela reverte toda a alteração feita
    // evita uma perda de dados indesejada

    @PostMapping
    @Transactional
    public ResponseEntity<Remedio> createRemedio(@RequestBody @Valid InRemedioDTO dados){

        Remedio newRemedio =  service.createRemedio(dados);

        return new ResponseEntity<>(newRemedio, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OutRemedioDTO>> getAllRemedios(){

        List<OutRemedioDTO> remedios = this.service.getAllRemedios().stream().map(OutRemedioDTO::new).toList();

        return new ResponseEntity<>(remedios, HttpStatus.OK);
    }
}
