package org.example.app.practicas.practica14;

import org.example.app.helpful.Logger;

public class Practica14 {
    private double[][] add(double[][] matrizA, double[][] matrizB) {
        if (canAdd(matrizA, matrizB)) {
            Logger.error("Error las matrices no son cuadradas");
            return null;
        }

        int filas = matrizA.length;
        int columnas = matrizA[0].length;

        double[][] resultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        return resultado;
    }

    private double[][] subtract(double[][] matrizA, double[][] matrizB) {
        if (canAdd(matrizA, matrizB)) {
            Logger.error("Error las matrices no son cuadradas");
            return null;
        }

        int filas = matrizA.length;
        int columnas = matrizA[0].length;

        double[][] resultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizA[i][j] - matrizB[i][j];
            }
        }

        return resultado;
    }

    private double[][] multiplyByScalar(double[][] matriz, int escalar) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        double[][] resultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz[i][j] * escalar;
            }
        }

        return resultado;
    }

    private double[][] multiply(double[][] matrizA, double[][] matrizB) {
        if (canMultiply(matrizA, matrizB)) {
            Logger.error("Error las matrices no se pueden multiplicar");
            return null;
        }
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;

        double[][] resultado = new double[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return resultado;
    }

    private double[][] transpose(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        double[][] resultado = new double[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[j][i] = matriz[i][j];
            }
        }

        return resultado;
    }

    public double determinant(double[][] matriz) {
        if (!isSquare(matriz)) {
            Logger.error("La matriz no es cuadrada");
            throw new IllegalArgumentException("La matriz no es cuadrada");
        }

        if (matriz.length != 2) {
            throw new IllegalArgumentException("La matriz debe ser 2x2");
        }

        return matriz[0][0] * matriz[1][1]
                - matriz[0][1] * matriz[1][0];
    }

    public double[][] division(double[][] matrizA, double[][] matrizB) {
        if (!isSquare(matrizB)) {
            throw new IllegalArgumentException(
                    "La matriz divisora debe ser cuadrada"
            );
        }

        double[][] inversa = inverse(matrizB);

        return multiply(matrizA, inversa);
    }

    public double cofactor(double[][] matriz, int fila, int columna) {
        if (!isSquare(matriz)) {
            throw new IllegalArgumentException("La matriz no es cuadrada");
        }

        double[][] submatriz = getSubMatrix(matriz, fila, columna);

        double determinant = determinant(submatriz);

        if ((fila + columna) % 2 != 0) {
            determinant *= -1;
        }

        return determinant;
    }

    private double[][] getSubMatrix(double[][] matriz, int filaEliminar, int columnaEliminar) {
        int size = matriz.length;
        double[][] resultado = new double[size - 1][size - 1];

        int filaResultado = 0;

        for (int i = 0; i < size; i++) {
            if (i == filaEliminar) {
                continue;
            }

            int columnaResultado = 0;

            for (int j = 0; j < size; j++) {
                if (j == columnaEliminar) {
                    continue;
                }

                resultado[filaResultado][columnaResultado] = matriz[i][j];
                columnaResultado++;
            }

            filaResultado++;
        }

        return resultado;
    }

    public double[][] adjugate(double[][] matriz) {
        if (!isSquare(matriz)) {
            throw new IllegalArgumentException("La matriz no es cuadrada");
        }

        int size = matriz.length;
        double[][] resultado = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                resultado[j][i] = cofactor(matriz, i, j);
            }
        }

        return resultado;
    }

    public double[][] inverse(double[][] matriz) {
        if (!isSquare(matriz)) {
            throw new IllegalArgumentException("La matriz no es cuadrada");
        }

        double determinant = determinant(matriz);

        if (determinant == 0) {
            throw new IllegalArgumentException(
                    "La matriz no tiene inversa porque su determinante es 0"
            );
        }

        double[][] adjugate = adjugate(matriz);

        int size = matriz.length;
        double[][] resultado = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                resultado[i][j] = adjugate[i][j] / determinant;
            }
        }

        return resultado;
    }

    private boolean canMultiply(double[][] matrizA, double[][] matrizB) {
        return matrizA[0].length == matrizB.length;
    }

    private boolean canAdd(double[][] matrizA, double[][] matrizB) {
        if (isSquare(matrizA) && isSquare(matrizB)) {
            return !sameSize(matrizA, matrizB);
        }
        return true;
    }

    private boolean isSquare(double[][] matriz) {
        return matriz.length > 0 && matriz.length == matriz[0].length;
    }

    private boolean sameSize(double[][] matrizA, double[][] matrizB) {
        return matrizA.length == matrizB.length
                && matrizA[0].length == matrizB[0].length;
    }
}
