package com.remedios.caio.controllers;

import com.remedios.caio.dtos.remedios.InRemedioDTO;
import com.remedios.caio.dtos.remedios.OutRemedioDTO;
import com.remedios.caio.dtos.remedios.RemedioDTO;
import com.remedios.caio.dtos.remedios.UptRemedioDTO;
import com.remedios.caio.services.RemedioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/remedios")
@SecurityRequirement(name = "bearer-key")
public class RemedioController {

    @Autowired
    private RemedioService service;

    // Valid mostra que os dados precisam estar validados

    // Transactional - Faz com que se caso algum erro acontecer nesta requisição ela reverte toda a alteração feita
    // evita uma perda de dados indesejada

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastre um Remédio!",
            description ="Cadastre um Remédio!",
            tags = {"Remedios"})
    public ResponseEntity<RemedioDTO> create(@RequestBody @Valid InRemedioDTO dados, UriComponentsBuilder uriBuilder){

        RemedioDTO remedio =  service.create(dados);

        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.id()).toUri();

        return ResponseEntity.created(uri).body(remedio);
    }

    @GetMapping
    @Operation(summary = "Buscar todos os Remédios!",
            description ="Buscar todos os Remédios!",
            tags = {"Remedios"})
    public ResponseEntity<List<OutRemedioDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalhar Remédio por ID!",
            description ="Detalhar Remédio por ID!",
            tags = {"Remedios"})
    public ResponseEntity<RemedioDTO>detalhar(@PathVariable Long id){
        return new ResponseEntity<>(service.detalhar(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @Transactional
    @Operation(summary = "Atualizar Remédio!",
            description ="Atualizar Remédio!",
            tags = {"Remedios"})
    public ResponseEntity<OutRemedioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid UptRemedioDTO dados){
        return new ResponseEntity<>(service.atualizar(id, dados), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Deletar Remédio!",
            description ="Deletar Remédio!",
            tags = {"Remedios"})
    public ResponseEntity<OutRemedioDTO> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.deletar(id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    @Operation(summary = "Inativar Remédio!",
            description ="Inativar Remédio!",
            tags = {"Remedios"})
    public ResponseEntity<OutRemedioDTO> inativar(@PathVariable Long id){
        return new ResponseEntity<>(service.inativar(id), HttpStatus.OK);
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    @Operation(summary = "Ativar Remédio!",
            description ="Ativar Remédio!",
            tags = {"Remedios"})
    public ResponseEntity<OutRemedioDTO> ativar(@PathVariable Long id){
        return new ResponseEntity<>(service.ativar(id), HttpStatus.OK);
    }
}
