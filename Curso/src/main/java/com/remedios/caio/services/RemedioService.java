package com.remedios.caio.services;

import com.remedios.caio.dtos.InRemedioDTO;
import com.remedios.caio.entities.Remedio;
import com.remedios.caio.repositories.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemedioService {

    @Autowired
    private RemedioRepository repository;

    public Remedio createRemedio(InRemedioDTO data){
        Remedio remedio = new Remedio(data);

        this.save(remedio);

        return remedio;
    }

    public void save(Remedio remedio){
        this.repository.save(remedio);
    }

    public List<Remedio> getAllRemedios(){
        return this.repository.findAll();
    }
}
