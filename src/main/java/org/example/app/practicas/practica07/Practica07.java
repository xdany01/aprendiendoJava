package org.example.app.practicas.practica07;

import org.example.app.helpful.Logger;
import org.example.app.helpful.ScannerInputHelpful;

import java.util.Scanner;

public class Practica07 {
    public void generadoID() {
        Logger.title("Generador de ID unico");
        Scanner input = new Scanner(System.in);
        ScannerInputHelpful inputHelpful = new ScannerInputHelpful(input);
        String nombre = (String) inputHelpful.solicitarValor(
                "Salario: ",
                Scanner::nextLine,
                s -> !s.toString().isEmpty(),
                "El salario debe ser mayor a 0",
                0.0
        );
    }
}
