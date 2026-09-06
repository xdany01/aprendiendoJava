package org.example.app.practicas.practica06;

public class Practica06 {
    public void stringFormat() {
        IO.println("Formateo de cadenas");
        var nombre = "Daniel";
        var edad = 32;
        var salario = 1500.5;

        var mensaje = String.format("Nombre: %s\nEdad:%d\nSalario: %.2f", nombre, edad, salario);
        IO.println(mensaje);

        mensaje = """
                \nDetalle persona
                Nombre: %s
                """.formatted(nombre);
        IO.println(mensaje);

        IO.print("System.out.printf -> ");
        System.out.printf("Salario: %.2f", salario);
    }
}
