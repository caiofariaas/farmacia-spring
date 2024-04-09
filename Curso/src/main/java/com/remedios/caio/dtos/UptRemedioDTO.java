package com.remedios.caio.dtos;

import com.remedios.caio.dtos.enums.Laboratorio;
import com.remedios.caio.dtos.enums.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record UptRemedioDTO(
        String nome,
        Via via,
        Laboratorio laboratorio
) {
}
