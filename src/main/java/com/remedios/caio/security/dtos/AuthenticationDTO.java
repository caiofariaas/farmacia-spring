package com.remedios.caio.security.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank
        String login,
        @NotBlank
        String senha) {
}
