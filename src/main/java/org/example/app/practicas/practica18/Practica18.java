package org.example.app.practicas.practica18;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Practica18 {
    public void readFile(String file) {
        Path path = Paths.get(file);
        try {
            Files.readAllLines(path, StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al leer el archivo. " + e.getMessage());
        }
    }

    public void readFileLineByLine(String file) {
        Path path = Paths.get(file);
//        Files.lines() te da un Stream<String> perezoso.
//        Por dentro usa un BufferedReader (así que sí hay buffering),
//        pero vos no lo manejás directamente.
//        Además te permite usar la API de streams (filter, map, limit, etc.).
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void readFileWithBuffer(String file) {
        Path path = Paths.get(file);
//        BufferedReader te da control explícito:
//        leés con readLine() en un while,
//        decidís cuándo cortar,
//        podés ajustar el tamaño del buffer, etc.
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
