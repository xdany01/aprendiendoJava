package org.example.app.practicas.practica04;

import org.example.app.helpful.ScannerInputHelpful;

import java.util.Scanner;

public class EmpleadoForm {

    public void practicaEmpleados() {
        Scanner input = new Scanner(System.in);
        IO.println("Ingrese los datos del empleado");
        IO.print("Nombre: ");
        String nombre = input.nextLine();

        ScannerInputHelpful inputHelpful = new ScannerInputHelpful(input);

        Integer edad = inputHelpful.solicitarValor(
                "Edad: ",
                Scanner::nextInt,
                e -> e >= 18 && e <= 100,
                "La edad debe estar entre 18 y 100 años",
                0
        );
        if (edad == 0) {
            IO.println("No se ingreso un valor valido para la edad del empleado");
            return;
        }

        Double salary = inputHelpful.solicitarValor(
                "Salario: ",
                Scanner::nextDouble,
                s -> s > 0,
                "El salario debe ser mayor a 0",
                0.0
        );
        if (salary == 0) {
            IO.println("No se ingreso un valor valido para el salario del empleado");
            return;
        }

        Boolean isBoss = inputHelpful.solicitarValor(
                "Es Jefe: ",
                Scanner::nextBoolean,
                b -> true, // no hay regla de negocio, cualquier boolean vale
                "",
                false
        );

        Empleado e = new Empleado(nombre, edad, salary, isBoss);
        IO.println(e.toString());
    }
}