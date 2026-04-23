package com.saberplay.modules.auth.application.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
