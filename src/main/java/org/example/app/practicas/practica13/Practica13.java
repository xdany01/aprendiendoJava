package org.example.app.practicas.practica13;

import org.example.app.helpful.ArrayHelpful;
import org.example.app.helpful.Logger;

import java.util.Scanner;

public class Practica13 {
    public void showMatriz() {

        IO.println("Ingrese la cantidad de filas de la matriz");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();

        IO.println("Ingrese la cantidad de columnas de filas");
        int cols = sc.nextInt();

        var matriz = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                IO.print("[" + i + "," + j + "] = ");
                matriz[i][j] = sc.nextInt();
                IO.println("");
            }
        }

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
