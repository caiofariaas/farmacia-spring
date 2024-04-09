package com.remedios.caio.services;

import com.remedios.caio.dtos.InRemedioDTO;
import com.remedios.caio.dtos.UptRemedioDTO;
import com.remedios.caio.entities.Remedio;
import com.remedios.caio.repositories.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemedioService {

    @Autowired
    private RemedioRepository repository;

    // Create Remedio

    public Remedio createRemedio(InRemedioDTO data){
        Remedio remedio = new Remedio(data);

        this.save(remedio);

        return remedio;
    }

    // Retorna todos os Remedios!

    public List<Remedio> getAllRemedios(){
        return this.repository.findAll();
    }

    // Salva o ‘item’ no banco!

    public Remedio atualizarRemedio(Long id, UptRemedioDTO dados){
        Remedio remedio =  repository.getReferenceById(id);
        remedio.atualizarInfo(dados);

        return remedio;
    }

    public void save(Remedio remedio){
        this.repository.save(remedio);
    }
}
