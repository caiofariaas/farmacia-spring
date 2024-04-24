package com.remedios.caio.dtos.remedios;

import com.remedios.caio.dtos.remedios.enums.Laboratorio;
import com.remedios.caio.dtos.remedios.enums.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record UptRemedioDTO(
        String nome,
        @Enumerated
        Via via,
        @Enumerated
        Laboratorio laboratorio
) {
}
