package com.remedios.caio.services;

import com.remedios.caio.dtos.InRemedioDTO;
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

    // Salva o item no banco!

    public boolean atualizarRemedio(Long id, InRemedioDTO remedio){

        Optional<Remedio> optionalInRemedioDTO = repository.findById(id);

        if(optionalInRemedioDTO.isPresent()){
            Remedio remedio1 = optionalInRemedioDTO.get();
            remedio1.setNome();
        }
    }

    public void save(Remedio remedio){
        this.repository.save(remedio);
    }
}
