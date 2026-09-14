package org.example.app.practicas.practica11;

import org.example.app.helpful.ColorsCode;
import org.example.app.helpful.Logger;
import org.example.app.helpful.ScannerInputHelpful;

import java.util.Scanner;

public class Practica11 {
    public void toAverageGrades() {
        Logger.title("Promedio de calificaciones");

        Scanner input = new Scanner(System.in);
        ScannerInputHelpful inputHelpful = new ScannerInputHelpful(input);

        Integer countGrades = inputHelpful.solicitarValor(
                "¿Cuantas calificaciones deseas ingresar? ",
                Scanner::nextInt,
                y -> true,
                "La cantidad ingresada no es valida",
                0
        );

        if (countGrades == 0) {
            IO.print("No se ingreso una cantidad valida");
        }

        int[] grades = new int[countGrades];

        for (int i = 0; i < countGrades; i++) {
            grades[i] = inputHelpful.solicitarValor(
                    "Calificacion[" + i + "]: ",
                    Scanner::nextInt,
                    y -> y >= 0 && y <= 10,
                    "La calificacion ingresada no es valida.\nDebe ser mayor o igual a 0 y menor o igual a 10",
                    0
            );
        }

        int accumulator = 0;
        for (int i = 0; i < countGrades; i++) {
            accumulator += grades[i];
        }
        float average = (float) accumulator / countGrades;

        if (average >= 7) {
            Logger.log("pass", ColorsCode.GREEN, "El promedio de calificaciones ingresada es:" + average);
            return;
        }

        Logger.log("fail", ColorsCode.RED, "El promedio de calificaciones ingresada es: " + average);
    }
}
