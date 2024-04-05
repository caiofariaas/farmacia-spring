package com.remedios.caio.entities;

import com.remedios.caio.dtos.enums.Laboratorio;
import com.remedios.caio.dtos.enums.Via;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "remedios")
@Table(name = "remedios")
public class Remedio {
    private Long id;
    private String nome;
    private Via via;
    private String lote;
    private Double quantidade;
    private String validade;
    private Laboratorio laboratorio;
}
