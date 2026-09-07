package org.example.app.helpful;

/**
 * Clase de constantes con códigos de escape ANSI para dar formato a texto
 * impreso en consola (colores de texto, colores de fondo y estilos).
 * <p>
 * Se usa concatenando el código antes del texto a formatear, y luego
 * {@code RESET} al final para volver al formato por defecto de la terminal.
 * <p>
 * Ejemplo de uso:
 * <pre>
 * System.out.println(ColorsCode.RED + "Error!" + ColorsCode.RESET);
 * System.out.println(ColorsCode.BOLD + ColorsCode.CYAN + "Título" + ColorsCode.RESET);
 * </pre>
 * <b>Nota:</b> estos códigos solo funcionan en terminales que soportan
 * secuencias ANSI (la mayoría de terminales Linux/Mac, y en Windows a partir
 * de Windows 10 con la consola moderna o Windows Terminal). En consolas que
 * no los interpretan, se van a ver como caracteres raros en vez de color.
 */
public class ColorsCode {

    /** Restaura el formato por defecto (colores y estilos). Siempre usar al final. */
    public static final String RESET = "\u001B[0m";

    // --- Colores de texto ---
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // --- Colores de fondo ---
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String MAGENTA_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    // --- Estilos de texto ---
    /** Texto en negrita. */
    public static final String BOLD = "\u001B[1m";
    /** Texto en cursiva (no todas las terminales lo soportan). */
    public static final String ITALIC = "\u001B[3m";
    /** Texto subrayado. */
    public static final String UNDERLINING = "\u001B[4m";
    /** Invierte los colores de texto y fondo. */
    public static final String INVERT = "\u001B[7m";
}
