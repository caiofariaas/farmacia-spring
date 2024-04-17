package com.remedios.caio.dtos.remedios;

import com.remedios.caio.dtos.remedios.enums.Laboratorio;
import com.remedios.caio.dtos.remedios.enums.Via;

public record UptRemedioDTO(
        String nome,
        Via via,
        Laboratorio laboratorio
) {
}
