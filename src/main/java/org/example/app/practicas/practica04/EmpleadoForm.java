package org.example.app.practicas.practica04;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmpleadoForm {

    private static final int MAX_INTENTOS = 3;

    public void practicaEmpleados() {
        Scanner input = new Scanner(System.in);
        IO.println("Ingrese los datos del empleado");
        IO.print("Nombre: ");
        String nombre = input.nextLine();

        Integer edad = solicitarValor(
                input,
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

        Double salary = solicitarValor(
                input,
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

        Boolean isBoss = solicitarValor(
                input,
                "Es Jefe: ",
                Scanner::nextBoolean,
                b -> true, // no hay regla de negocio, cualquier boolean vale
                "",
                false
        );

        Empleado e = new Empleado(nombre, edad, salary, isBoss);
        IO.println(e.toString());
    }

    /**
     * Método genérico que solicita un valor por consola, valida su formato (con manejo
     * de InputMismatchException) y opcionalmente una regla de negocio, reintentando
     * hasta MAX_INTENTOS veces.
     *
     * @param input      Scanner de entrada
     * @param prompt     texto a mostrar antes de leer
     * @param reader     función que extrae el valor del Scanner (ej: Scanner::nextInt)
     * @param validador  regla de negocio adicional sobre el valor leído
     * @param errorMsg   mensaje si falla la regla de negocio
     * @param porDefecto valor a retornar si se agotan los intentos
     */
    private <T> T solicitarValor(Scanner input, String prompt, Function<Scanner, T> reader,
                                 Predicate<T> validador, String errorMsg, T porDefecto) {
        int intentos = 0;

        do {
            IO.print(prompt);
            try {
                T valor = reader.apply(input);
                input.nextLine(); // Limpiar buffer

                if (validador.test(valor)) {
                    return valor;
                }
                IO.println(errorMsg);
                intentos++;
                avisarIntento(intentos);

            } catch (InputMismatchException e) {
                intentos++;
                avisarIntento(intentos);
                input.nextLine(); // Limpiar buffer en caso de error
            }
        } while (intentos < MAX_INTENTOS);

        IO.println("Se excedió el número máximo de intentos. Retornando valor por defecto (" + porDefecto + ")");
        return porDefecto;
    }

    private void avisarIntento(int intentos) {
        if (intentos < MAX_INTENTOS) {
            IO.println("[" + intentos + "/" + MAX_INTENTOS + "] Por favor ingrese un valor válido");
        }
    }
}