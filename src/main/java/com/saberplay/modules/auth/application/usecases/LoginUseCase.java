package com.saberplay.modules.auth.application.usecases;

import com.saberplay.modules.auth.application.dto.LoginRequest;
import com.saberplay.modules.auth.domain.ports.UserRepository;
import com.saberplay.modules.auth.infrastructure.adapters.out.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCase {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    
    public String execute(LoginRequest request) {
        return userRepository.findByUsername(request.getUsername())
            .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
            .map(user -> jwtService.generateToken(user.getUsername(), user.getTenantId(), user.getRole()))
            .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
    }
}
