package org.example.app.practicas.practica05;

import java.util.List;

public record Recipe(String name, List<String> ingredients, int time, Difficulty difficulty) {
}
