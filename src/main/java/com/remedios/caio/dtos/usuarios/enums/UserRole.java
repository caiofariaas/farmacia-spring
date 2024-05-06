package com.remedios.caio.dtos.usuarios.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
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

    @JsonCreator
    public static UserRole fromString(String value){
        for(UserRole role : UserRole.values()){
            if(role.name().equalsIgnoreCase(value)){
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role: " + value);
    }
}
