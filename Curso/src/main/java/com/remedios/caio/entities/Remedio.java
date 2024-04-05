package com.remedios.caio.entities;

import com.remedios.caio.dtos.RemedioDTO;
import com.remedios.caio.dtos.enums.Laboratorio;
import com.remedios.caio.dtos.enums.Via;
import jakarta.persistence.*;
import lombok.*;

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
    private Double quantidade;
    private String validade;

    @Enumerated(EnumType.STRING)
    private Via via;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    public Remedio(RemedioDTO dados) {
        this.nome = dados.nome();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();;
        this.validade = dados.validade();
        this.via = dados.via();
        this.laboratorio = dados.laboratorio();
    }
}
