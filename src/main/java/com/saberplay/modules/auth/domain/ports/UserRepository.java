package com.saberplay.modules.auth.domain.ports;

import com.saberplay.modules.auth.domain.model.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    void save(User user);
}
