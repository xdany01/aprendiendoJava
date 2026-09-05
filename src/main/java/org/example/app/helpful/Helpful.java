package org.example.app.helpful;

public class Helpful {
    public static void printStringAsArray(String str) {

        final int MIN_WIDTH = 3;
        final int MAX_INDEX = 9_999_999;
        final String DASH = "═";

        // El último índice no puede superar MAX_INDEX
        if (str.length() - 1 > MAX_INDEX) {
            IO.println(str);
            return;
        }

        // Línea superior
        IO.print(ColorsCode.CYAN + "╔");

        for (int i = 0; i < str.length(); i++) {

            String index = String.valueOf(i);
            int width = Math.max(MIN_WIDTH, index.length());

            IO.print(DASH.repeat(width));
            IO.print("╗");

            if (i < str.length() - 1) {
                IO.print("╔");
            }
        }

        IO.println();

        // Línea del medio
        for (int i = 0; i < str.length(); i++) {

            String index = String.valueOf(i);
            int width = Math.max(MIN_WIDTH, index.length());

            int leftPad = (width - 1) / 2;
            int rightPad = width - 1 - leftPad;

            IO.print("║" + ColorsCode.RESET);
            IO.print(" ".repeat(leftPad));
            IO.print(str.charAt(i));
            IO.print(" ".repeat(rightPad));
            IO.print(ColorsCode.CYAN + "║");
        }

        IO.println();

        // Línea inferior
        for (int i = 0; i < str.length(); i++) {

            String index = String.valueOf(i);
            int width = Math.max(MIN_WIDTH, index.length());
            int dashes = width - index.length();

            IO.print(ColorsCode.CYAN + "╚" + ColorsCode.GREEN);
            IO.print(index);
            IO.print(ColorsCode.CYAN + DASH.repeat(dashes));
            IO.print("╝");
        }

        IO.println(ColorsCode.RESET);
    }
}
