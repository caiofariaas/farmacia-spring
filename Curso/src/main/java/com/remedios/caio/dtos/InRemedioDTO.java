package com.remedios.caio.dtos;


import com.remedios.caio.dtos.enums.Laboratorio;
import com.remedios.caio.dtos.enums.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record InRemedioDTO(

        @NotBlank
        String nome,

        @Enumerated
        Via via,

        @NotBlank
        String lote,

        int quantidade,

        @Future // Indica que não é possivel entrar com uma data anterior a dada atual
        LocalDate validade,

        @Enumerated
        Laboratorio laboratorio) {
}
