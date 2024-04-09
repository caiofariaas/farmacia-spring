package com.remedios.caio.controllers;

import com.remedios.caio.dtos.InRemedioDTO;
import com.remedios.caio.dtos.OutRemedioDTO;
import com.remedios.caio.dtos.UptRemedioDTO;
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
    public ResponseEntity<OutRemedioDTO> create(@RequestBody @Valid InRemedioDTO dados){
        return new ResponseEntity<>(service.create(dados) , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OutRemedioDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<OutRemedioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid UptRemedioDTO dados){
        return new ResponseEntity<>(service.atualizar(id, dados), HttpStatus.OK);
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public ResponseEntity<OutRemedioDTO> inativar(@PathVariable Long id){
        return new ResponseEntity<>(service.inativar(id), HttpStatus.OK);
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity<OutRemedioDTO> ativar(@PathVariable Long id){
        return new ResponseEntity<>(service.ativar(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<OutRemedioDTO> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.deletar(id), HttpStatus.NO_CONTENT);
    }
}
