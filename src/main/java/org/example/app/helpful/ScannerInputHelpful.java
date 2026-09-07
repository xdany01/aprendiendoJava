package org.example.app.helpful;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class ScannerInputHelpful {
    Scanner input;
    int maxIntentos;

    public ScannerInputHelpful() {
        this.input = new Scanner(System.in);
        this.maxIntentos = 3;
    }

    public ScannerInputHelpful(Scanner input) {
        this.input = input;
        this.maxIntentos = 3;
    }

    public ScannerInputHelpful(Scanner input, int maxIntentos) {
        this.input = input;
        this.maxIntentos = maxIntentos;
    }

    /**
     * Método genérico que solicita un valor por consola, valida su formato (con manejo
     * de InputMismatchException) y opcionalmente una regla de negocio, reintentando
     * hasta MAX_INTENTOS veces.
     *
     * @param prompt     texto a mostrar antes de leer
     * @param reader     función que extrae el valor del Scanner (ej: Scanner::nextInt)
     * @param validador  regla de negocio adicional sobre el valor leído
     * @param errorMsg   mensaje si falla la regla de negocio
     * @param porDefecto valor a retornar si se agotan los intentos
     */
    public <T> T solicitarValor(String prompt, Function<Scanner, T> reader,
                                Predicate<T> validador, String errorMsg, T porDefecto) {
        int intentos = 0;

        do {
            IO.print(prompt);
            try {
                T valor = reader.apply(this.input);

                Class<?> clazz = valor.getClass();
                if (clazz != String.class) {
                    this.input.nextLine(); // Limpiar buffer
                }

                if (validador.test(valor)) {
                    return valor;
                }
                IO.println(errorMsg);
                intentos++;
                avisarIntento(intentos);

            } catch (InputMismatchException e) {
                intentos++;
                avisarIntento(intentos);
                this.input.nextLine(); // Limpiar buffer en caso de error
            }
        } while (intentos < this.maxIntentos);

        IO.println("Se excedió el número máximo de intentos. Retornando valor por defecto (" + porDefecto + ")");
        return porDefecto;
    }

    private void avisarIntento(int intentos) {
        if (intentos < this.maxIntentos) {
            IO.println("[" + intentos + "/" + this.maxIntentos + "] Por favor ingrese un valor válido");
        }
    }
}
