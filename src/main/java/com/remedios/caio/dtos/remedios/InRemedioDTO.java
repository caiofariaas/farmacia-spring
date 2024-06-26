package com.remedios.caio.dtos.remedios;

import com.remedios.caio.dtos.remedios.enums.Laboratorio;
import com.remedios.caio.dtos.remedios.enums.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record InRemedioDTO(
        @NotBlank
        String nome,
        @Enumerated
        Via via,
        @NotBlank
        String lote,
        @Positive
        @NotNull
        int quantidade,
        @Future
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio) {
}
