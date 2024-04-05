package com.remedios.caio.dtos;


import com.remedios.caio.dtos.enums.Laboratorio;
import com.remedios.caio.dtos.enums.Via;

public record RemedioDTO(String nome, Via via, String lote,
                         Double quantidade, String validade,
                         Laboratorio laboratorio) {
}
