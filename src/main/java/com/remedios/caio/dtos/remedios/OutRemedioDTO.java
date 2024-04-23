package com.remedios.caio.dtos.remedios;

// Criamos um DTO excluisivo para um GET ALL,
// se fizermos esta requisição utilizando diretamente a classe de remédios,
// não poderiamos filtrar as informações que queremos mostrar

import com.remedios.caio.dtos.remedios.enums.Laboratorio;
import com.remedios.caio.dtos.remedios.enums.Via;
import com.remedios.caio.entities.Remedio;

import java.time.LocalDate;

public record OutRemedioDTO(
        Long id,
        String nome,
        Via via,
        Laboratorio laboratorio,
        LocalDate validade
) {

    public OutRemedioDTO(Remedio remedio) {
        this(remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLaboratorio(),
                remedio.getValidade());
    }
}
