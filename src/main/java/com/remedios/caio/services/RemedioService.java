package com.remedios.caio.services;

import com.remedios.caio.dtos.remedios.InRemedioDTO;
import com.remedios.caio.dtos.remedios.OutRemedioDTO;
import com.remedios.caio.dtos.remedios.RemedioDTO;
import com.remedios.caio.dtos.remedios.UptRemedioDTO;
import com.remedios.caio.entities.Remedio;
import com.remedios.caio.exceptions.NotFoundException;
import com.remedios.caio.repositories.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Remedio remedio = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Medicine not found!"));
        remedio.atualizarInfo(dados);

        return new OutRemedioDTO(remedio);
    }

    public OutRemedioDTO inativar(Long id){
        Remedio remedio = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Medicine not found!"));
        remedio.setAtivo(false);

        return new OutRemedioDTO(remedio);
    }

    public OutRemedioDTO ativar(Long id){
        Remedio remedio = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Medicine not found!"));
        remedio.setAtivo(true);

        return  new OutRemedioDTO(remedio);
    }

    public RemedioDTO detalhar(Long id){
        return new RemedioDTO(this.repository.findById(id).orElseThrow(() -> new NotFoundException("Medicine not found!")));
    }

    public OutRemedioDTO deletar(Long id){
        Remedio remedio = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Medicine not found!"));
        this.repository.deleteById(id);

        return new OutRemedioDTO(remedio);
    }
}
