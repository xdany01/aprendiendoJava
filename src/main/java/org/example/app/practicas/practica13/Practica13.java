package org.example.app.practicas.practica13;

import org.example.app.helpful.ArrayHelpful;
import org.example.app.helpful.Logger;

import java.util.Arrays;

public class Practica13 {
    public void showMatriz() {

        var matriz = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        Logger.title("Recorriendo Matriz con un for tradicional");

        for (var i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        Logger.title("Recorriendo Matriz con forEach");

        for (int[] ints : matriz) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        Logger.title("Imprimiendo Matriz con ArrayHelpful");

        ArrayHelpful.printArray(matriz);

    }
}
