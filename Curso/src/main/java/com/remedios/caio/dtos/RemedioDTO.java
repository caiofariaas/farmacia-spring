package com.remedios.caio.dtos;

import com.remedios.caio.dtos.enums.Laboratorio;
import com.remedios.caio.dtos.enums.Via;
import com.remedios.caio.entities.Remedio;

import java.time.LocalDate;

public record RemedioDTO(
        Long id,
        String nome,
        Via via,
        String lote,
        int quantidade,
        LocalDate validade,
        Laboratorio laboratorio,
        Boolean ativo

) {
    public RemedioDTO(Remedio remedio) {

        this(remedio.getId(), remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getQuantidade(), remedio.getValidade(), remedio.getLaboratorio(), remedio.getAtivo());
    }
}
