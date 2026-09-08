package org.example.app.practicas.practica08.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.app.practicas.practica08.model.User;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JsonUserRepository implements IUserRepository {

    private final Path file;
    private final Gson gson = new Gson();

    public JsonUserRepository() {
        this(Path.of(System.getProperty("java.io.tmpdir"), "users.json"));
    }

    public JsonUserRepository(Path file) {
        this.file = file;
    }

    private Map<String, User> loadAll() {
        try {
            if (!Files.exists(file)) return new HashMap<>();
            String json = Files.readString(file);
            Type type = new TypeToken<Map<String, User>>() {
            }.getType();
            Map<String, User> data = gson.fromJson(json, type);
            return data != null ? data : new HashMap<>();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void saveAll(Map<String, User> users) {
        try {
            Files.writeString(file, gson.toJson(users));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(loadAll().get(username));
    }

    @Override
    public boolean existsByUsername(String username) {
        return loadAll().containsKey(username);
    }

    @Override
    public void save(User user) {
        Map<String, User> users = loadAll();
        users.put(user.username(), user);
        saveAll(users);
    }
}
