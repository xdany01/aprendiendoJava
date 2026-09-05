package org.example.app.practicas.practica04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practica04 {
    public void useScanner() {
        Scanner input = new Scanner(System.in);
        IO.println("Ingrese una cadena para continuar: ");
        String cadena = input.nextLine();
        IO.println("Ingreso el valor de: " + cadena);

        IO.println("Ingrese un entero para continuar: ");
        int entero = input.nextInt();
        IO.println("Ingreso el valor: " + entero);

        IO.println("Ingrese el double para continuar: ");
        double enteroDouble = input.nextDouble();
        IO.println("Ingreso el valor de: " + enteroDouble);
        // Se consume el salto de linea
        input.nextLine();
        IO.println("Ingrese un valor para convertir a entero: ");
        String valor = input.nextLine();
        IO.println("Ingreso el valor de: " + Integer.parseInt(valor));
        IO.println("Otras posibles conversiones:");
        IO.println("Float.parseFloat(valor);\nDouble.parseDouble(valor);\nBoolean.parseBoolean(valor);");
    }

    public void useScanner2() {
        EmpleadoForm empleadoForm = new EmpleadoForm();
        empleadoForm.practicaEmpleados();
    }
}
