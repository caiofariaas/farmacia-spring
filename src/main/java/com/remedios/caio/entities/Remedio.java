package com.remedios.caio.entities;

import com.remedios.caio.dtos.remedios.InRemedioDTO;
import com.remedios.caio.dtos.remedios.UptRemedioDTO;
import com.remedios.caio.dtos.remedios.enums.Laboratorio;
import com.remedios.caio.dtos.remedios.enums.Via;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Table(name = "remedios")
@Entity(name = "remedios")
public class Remedio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String lote;
    private int quantidade;
    private LocalDate validade;
    private Boolean ativo;
    @Enumerated(EnumType.STRING)
    private Via via;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;


    public Remedio(InRemedioDTO dados) {
        this.nome = dados.nome();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();;
        this.validade = dados.validade();
        this.via = dados.via();
        this.laboratorio = dados.laboratorio();
        this.ativo = true;
    }

    // TODO Tratar Exceptions
    public void atualizarInfo(UptRemedioDTO dados) {
        if(!dados.nome().isBlank()){
            this.nome = dados.nome();
        }
        if(dados.via() != null){
            this.via = dados.via();
        }
        if(dados.laboratorio() != null){
            this.laboratorio = dados.laboratorio();
        }
    }
}
