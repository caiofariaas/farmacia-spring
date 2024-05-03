package com.remedios.caio.dtos.usuarios.enums;

import lombok.Getter;

@Getter
public enum UserRole {

    ROLE_ADMIN("admin"),
    ROLE_MANAGER("manager"),
    ROLE_USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }
}
