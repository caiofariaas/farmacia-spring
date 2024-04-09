package com.remedios.caio.services;

import com.remedios.caio.dtos.InRemedioDTO;
import com.remedios.caio.dtos.OutRemedioDTO;
import com.remedios.caio.dtos.RemedioDTO;
import com.remedios.caio.dtos.UptRemedioDTO;
import com.remedios.caio.entities.Remedio;
import com.remedios.caio.repositories.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class RemedioService {

    @Autowired
    private RemedioRepository repository;


    public RemedioDTO create(InRemedioDTO data){
        Remedio remedio = new Remedio(data);

        this.repository.save(remedio);

        return new RemedioDTO(remedio);
    }

    public List<OutRemedioDTO> getAll(){
        return this.repository.findAllByAtivoTrue().stream().map(OutRemedioDTO::new).toList();
    }

    public OutRemedioDTO atualizar(Long id, UptRemedioDTO dados){
        Remedio remedio =  this.repository.getReferenceById(id);
        remedio.atualizarInfo(dados);

        return new OutRemedioDTO(remedio);
    }

    public OutRemedioDTO inativar(Long id){
        Remedio remedio = this.repository.getReferenceById(id);
        remedio.setAtivo(false);

        return new OutRemedioDTO(remedio);
    }

    public OutRemedioDTO ativar(Long id){
        Remedio remedio = this.repository.getReferenceById(id);
        remedio.setAtivo(true);

        return  new OutRemedioDTO(remedio);
    }

    public RemedioDTO detalhar(Long id){
        Remedio remedio = this.repository.getReferenceById(id);

        return new RemedioDTO(remedio);
    }

    public OutRemedioDTO deletar(Long id){
        Remedio remedio = this.repository.getReferenceById(id);
        this.repository.deleteById(id);

        return new OutRemedioDTO(remedio);
    }
}