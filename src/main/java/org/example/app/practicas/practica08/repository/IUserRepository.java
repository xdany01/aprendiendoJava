package org.example.app.practicas.practica08.repository;

import org.example.app.practicas.practica08.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    void save(User user);
}
