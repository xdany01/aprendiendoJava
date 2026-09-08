package org.example.app.practicas.practica08.service;

public interface IAuthService {
    void register(String username, String password);

    boolean login(String username, String password);
}
