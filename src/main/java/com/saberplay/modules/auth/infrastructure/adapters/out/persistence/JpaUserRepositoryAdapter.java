package com.saberplay.modules.auth.infrastructure.adapters.out.persistence;

import com.saberplay.modules.auth.domain.model.User;
import com.saberplay.modules.auth.domain.ports.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaUserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository repository;

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username)
                .map(entity -> new User(
                    entity.getId(), 
                    entity.getUsername(), 
                    entity.getEmail(), 
                    entity.getPassword(), 
                    entity.getRole(),
                    entity.getTenantId()
                ));
    }

    @Override
    public void save(User user) {
        UserEntity entity = new UserEntity();
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setRole(user.getRole());
        entity.setTenantId(user.getTenantId());
        repository.save(entity);
    }
}
