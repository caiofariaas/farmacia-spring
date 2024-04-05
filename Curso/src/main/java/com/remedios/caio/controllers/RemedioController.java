package com.remedios.caio.controllers;

import com.remedios.caio.dtos.RemedioDTO;
import com.remedios.caio.entities.Remedio;
import com.remedios.caio.repositories.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    // O Autowired instancia um objeto da classe indicada
    // Isso tira a necessidade de declarar um objeto em cada método que desejamos usa-lo

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    public void createRemedio(@RequestBody RemedioDTO dados){

        repository.save(new Remedio(dados));

    }
}
