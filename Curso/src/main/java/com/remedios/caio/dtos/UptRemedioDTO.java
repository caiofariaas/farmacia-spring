package com.remedios.caio.dtos;

import com.remedios.caio.dtos.enums.Laboratorio;
import com.remedios.caio.dtos.enums.Via;

public record UptRemedioDTO(Long id,
                            String nome,
                            Via via,
                            Laboratorio laboratorio) {
}
