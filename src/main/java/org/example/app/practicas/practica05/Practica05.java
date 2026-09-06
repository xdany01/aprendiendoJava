package org.example.app.practicas.practica05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practica05 {
    public void processRecipe() {
        Scanner sc = new Scanner(System.in);

        IO.println("Receta de cocina");
        IO.print("Nombre: ");
        String name = sc.nextLine();

        List<String> ingredients = readIngredients(sc);
        int time = readCookingTime(sc);
        Difficulty difficulty = readDifficulty(sc);

        Recipe recipe = new Recipe(name, ingredients, time, difficulty);
        IO.println(recipe.toString());
    }

    private List<String> readIngredients(Scanner sc) {
        List<String> ingredients = new ArrayList<>();
        IO.println("Ingrese los ingredientes de a uno:");
        IO.println("(para finalizar ingrese \"q\")");

        while (true) {
            String ingredient = sc.nextLine();
            if (ingredient.equalsIgnoreCase("q")) {
                break;
            }
            ingredients.add(ingredient);
            IO.println("Ingredientes cargados: " + ingredients);
        }
        return ingredients;
    }

    private int readCookingTime(Scanner sc) {
        IO.print("Tiempo de coccion (minutos): ");
        while (!sc.hasNextInt()) {
            IO.println("Ingrese un numero valido.");
            sc.next();
        }
        int time = sc.nextInt();
        sc.nextLine();
        return time;
    }

    private Difficulty readDifficulty(Scanner sc) {
        Difficulty[] values = Difficulty.values();

        IO.println("Ingrese el nivel de dificultad:");
        IO.println("(Ingrese el indice. Ejemplo: \"0\" para " + values[0] + ")");
        for (int i = 0; i < values.length; i++) {
            IO.println(i + "-" + values[i]);
        }

        int index;
        while (true) {
            while (!sc.hasNextInt()) {
                IO.println("Ingrese un numero valido.");
                sc.next();
            }
            index = sc.nextInt();
            if (index >= 0 && index < values.length) {
                break;
            }
            IO.println("Indice invalido, intente de nuevo.");
        }
        sc.nextLine();
        return values[index];
    }
}
