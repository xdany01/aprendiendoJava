package org.example.app.practicas.practica07;

import org.example.app.helpful.Logger;
import org.example.app.helpful.ScannerInputHelpful;

import java.util.Random;
import java.util.Scanner;

public class Practica07 {
    public void generatorID() {
        Logger.title("Generador de ID unico");

        Scanner input = new Scanner(System.in);
        ScannerInputHelpful inputHelpful = new ScannerInputHelpful(input);

        String nombre = inputHelpful.solicitarValor(
                "Nombre: ",
                Scanner::nextLine,
                s -> !s.isEmpty(),
                "El nombre no puede ser vacio",
                ""
        );

        if (nombre.isEmpty()) {
            IO.print("No se ingreso un Nombre valido");
        }

        String apellido = inputHelpful.solicitarValor(
                "Apellido: ",
                Scanner::nextLine,
                s -> !s.isEmpty(),
                "El apellido no puede ser vacio",
                ""
        );

        if (apellido.isEmpty()) {
            IO.print("No se ingreso un Apellido valido");
        }

        Integer anioNacimiento = inputHelpful.solicitarValor(
                "Año de nacimiento:",
                Scanner::nextInt,
                y -> y.toString().length() == 4,
                "El año debe ser de cuatro digitos",
                0
        );

        if (anioNacimiento == 0) {
            IO.print("No se ingreso un año de nacimiento valido");
        }

        String str01 = nombre.toUpperCase().substring(0, 2);
        String str02 = apellido.toUpperCase().substring(0, 2);
        String str03 = anioNacimiento.toString().substring(2,4);
        String code4Digits = generarCodigo4Digitos();

        String IDGenerated = str01 + str02 + str03 + code4Digits;

        IO.print("El ID generado es: " + IDGenerated);
    }

    private String generarCodigo4Digitos() {
        Random random = new Random();
        int randomNumber = random.nextInt(0, 10000);
        String strRandomNumber = String.valueOf(randomNumber);

        if (strRandomNumber.length() == 4) {
            return strRandomNumber;
        }

        return String.format("%04d", randomNumber);
    }
}
