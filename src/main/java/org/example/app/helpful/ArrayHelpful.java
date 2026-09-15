package org.example.app.helpful;

public class ArrayHelpful {

    /**
     * Imprime una cadena de texto en formato de tabla ASCII, donde cada carácter
     * se muestra dentro de una celda con bordes, y debajo de cada celda se indica
     * el índice (posición) de ese carácter dentro del string.
     * <p>
     * Ejemplo de salida para "Hi":
     * <pre>
     * ╔═══╗╔═══╗
     * ║ H ║║ i ║
     * ╚0══╝╚1══╝
     * </pre>
     * El ancho de cada celda se ajusta automáticamente para que el número de índice
     * (por ejemplo "10", "100") entre sin desbordar el borde, con un ancho mínimo
     * de {@code MIN_WIDTH} caracteres.
     * <p>
     * Si la longitud del string hace que el último índice supere {@code MAX_INDEX},
     * se aborta el formateo y se imprime el string tal cual, sin tabla, para evitar
     * casos absurdos (strings enormes) o desbordes de formato.
     *
     * @param str la cadena a representar como tabla de caracteres indexados
     */
    public static void printStringAsArray(String str) {

        // Ancho mínimo de cada celda (en caracteres) y límite máximo de índice soportado
        final int MIN_WIDTH = 3;
        final int MAX_INDEX = 9_999_999;
        // Carácter usado para dibujar las líneas horizontales de las celdas
        final String DASH = "═";

        // Si el último índice del string no entra dentro del límite soportado,
        // se hace un fallback: imprimir el string plano sin formato de tabla.
        if (str.length() - 1 > MAX_INDEX) {
            IO.println(str);
            return;
        }

        // --- Línea superior: dibuja el borde de arriba de cada celda (╔═══╗) ---
        IO.print(ColorsCode.CYAN + "╔");

        for (int i = 0; i < str.length(); i++) {

            // El ancho de la celda depende de cuántos dígitos tiene el índice,
            // pero nunca es menor a MIN_WIDTH
            String index = String.valueOf(i);
            int width = Math.max(MIN_WIDTH, index.length());

            IO.print(DASH.repeat(width));
            IO.print("╗");

            // Si no es la última celda, se abre el borde superior de la siguiente
            if (i < str.length() - 1) {
                IO.print("╔");
            }
        }

        IO.println();

        // --- Línea del medio: dibuja el carácter centrado dentro de la celda (║ H ║) ---
        for (int i = 0; i < str.length(); i++) {

            String index = String.valueOf(i);
            int width = Math.max(MIN_WIDTH, index.length());

            // Se calcula el padding izquierdo/derecho para centrar el carácter
            // dentro del ancho de la celda (el -1 es porque el carácter ocupa 1 espacio)
            int leftPad = (width - 1) / 2;
            int rightPad = width - 1 - leftPad;

            IO.print("║" + ColorsCode.RESET);
            IO.print(" ".repeat(leftPad));
            IO.print(str.charAt(i));
            IO.print(" ".repeat(rightPad));
            IO.print(ColorsCode.CYAN + "║");
        }

        IO.println();

        // --- Línea inferior: dibuja el borde de abajo con el índice dentro (╚0══╝) ---
        for (int i = 0; i < str.length(); i++) {

            String index = String.valueOf(i);
            int width = Math.max(MIN_WIDTH, index.length());
            // Cantidad de guiones necesarios para completar el ancho de la celda
            // después de escribir los dígitos del índice
            int dashes = width - index.length();

            IO.print(ColorsCode.CYAN + "╚" + ColorsCode.GREEN);
            IO.print(index);
            IO.print(ColorsCode.CYAN + DASH.repeat(dashes));
            IO.print("╝");
        }

        IO.println(ColorsCode.RESET);
    }

    public static <T> String arrayToString(T[] arr) {
        StringBuilder sb = new StringBuilder();
        for (T item : arr) {
            sb.append(item);
        }
        return sb.toString();
    }

    public static <T> String arrayToString(T[] arr, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }
}
