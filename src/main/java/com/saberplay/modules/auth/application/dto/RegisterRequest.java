package com.saberplay.modules.auth.application.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private String role;     // Ejemplo: ADMIN_COLEGIO, ESTUDIANTE
    private String tenantId; // Aquí irá "sagrada_familia"
}
