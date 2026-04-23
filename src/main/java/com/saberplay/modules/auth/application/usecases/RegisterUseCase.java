package com.saberplay.modules.auth.application.usecases;

import com.saberplay.modules.auth.application.dto.RegisterRequest;
import com.saberplay.modules.auth.domain.model.User;
import com.saberplay.modules.auth.domain.ports.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void execute(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setTenantId(request.getTenantId()); // Vinculación SaaS
        userRepository.save(user);
    }
}
