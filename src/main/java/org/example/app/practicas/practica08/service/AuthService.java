package org.example.app.practicas.practica08.service;

import org.example.app.practicas.practica08.model.User;
import org.example.app.practicas.practica08.repository.IUserRepository;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService implements IAuthService {

    private final IUserRepository userRepository;

    public AuthService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalStateException("El usuario ya existe");
        }
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        userRepository.save(new User(username, hash));
    }

    @Override
    public boolean login(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> BCrypt.checkpw(password, user.passwordHash()))
                .orElse(false);
    }
}
