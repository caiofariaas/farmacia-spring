package com.remedios.caio.dtos.usuarios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record InUsuarioDTO(
        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        @Size(max = 20)
        String login,

        @Size(min = 6, max = 20)
        @NotBlank
        String senha

) {
}
