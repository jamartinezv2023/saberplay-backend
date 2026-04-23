package com.saberplay.modules.auth.infrastructure.adapters.in.rest;

import com.saberplay.modules.auth.application.dto.LoginRequest;
import com.saberplay.modules.auth.application.dto.RegisterRequest;
import com.saberplay.modules.auth.application.usecases.LoginUseCase;
import com.saberplay.modules.auth.application.usecases.RegisterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginUseCase loginUseCase;
    private final RegisterUseCase registerUseCase;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        registerUseCase.execute(request);
        return ResponseEntity.ok(Map.of("message", "Usuario registrado exitosamente"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = loginUseCase.execute(request);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
