package com.remedios.caio.dtos.usuarios;

import com.remedios.caio.dtos.usuarios.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record PrivilegeDTO(
        @Enumerated(EnumType.STRING)
        UserRole role
) {
}
