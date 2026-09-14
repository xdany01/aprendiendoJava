package org.example.app.helpful;

/**
 * Logger de consola con salida coloreada usando códigos ANSI ({@link ColorsCode}).
 * <p>
 * Pensado para uso simple en aplicaciones de consola/CLI: imprime mensajes
 * con una etiqueta y un color según su severidad (info, success, warning, error),
 * y permite imprimir títulos/secciones para organizar la salida.
 * <p>
 * Ejemplo de uso:
 * <pre>
 * Logger.title("Iniciando proceso");
 * Logger.info("Conectando a la base de datos...");
 * Logger.success("Conexión establecida");
 * Logger.warning("La caché está vacía, se recalculará");
 * Logger.error("No se pudo guardar el archivo");
 * </pre>
 */
public class Logger {

    // Ancho del prefijo (ej: "[SUCCESS]") para alinear los mensajes en columna
    private static final int LABEL_WIDTH = 9;

    /**
     * Imprime un título de sección, centrado visualmente con líneas decorativas.
     * Útil para separar bloques de salida en consola.
     *
     * @param text el texto del título
     */
    public static void title(String text) {
        String line = "─".repeat(text.length() + 4);
        IO.println(ColorsCode.CYAN + ColorsCode.BOLD + "┌" + line + "┐" + ColorsCode.RESET);
        IO.println(ColorsCode.CYAN + ColorsCode.BOLD + "│  " + text + "  │" + ColorsCode.RESET);
        IO.println(ColorsCode.CYAN + ColorsCode.BOLD + "└" + line + "┘" + ColorsCode.RESET);
    }

    /**
     * Log informativo general (color azul).
     *
     * @param message el mensaje a mostrar
     */
    public static void info(String message) {
        log("INFO", ColorsCode.BLUE, message);
    }

    /**
     * Log de éxito, para confirmar que una operación terminó bien (color verde).
     *
     * @param message el mensaje a mostrar
     */
    public static void success(String message) {
        log("SUCCESS", ColorsCode.GREEN, message);
    }

    /**
     * Log de advertencia, para algo que no es un error pero merece atención (color amarillo).
     *
     * @param message el mensaje a mostrar
     */
    public static void warning(String message) {
        log("WARNING", ColorsCode.YELLOW, message);
    }

    /**
     * Log de error, para fallos o excepciones (color rojo, en negrita para destacar).
     *
     * @param message el mensaje a mostrar
     */
    public static void error(String message) {
        log("ERROR", ColorsCode.RED + ColorsCode.BOLD, message);
    }

    /**
     * Método interno que arma el formato común de todos los logs:
     * {@code [ETIQUETA]  mensaje}, con la etiqueta coloreada y alineada.
     *
     * @param label   etiqueta del tipo de log (INFO, ERROR, etc.)
     * @param color   código ANSI de color a aplicar a la etiqueta
     * @param message mensaje del log
     */
    public static void log(String label, String color, String message) {
        String tag = "[" + label + "]";
        int padding = Math.max(0, LABEL_WIDTH + 2 - tag.length());

        IO.print(color + tag + ColorsCode.RESET);
        IO.print(" ".repeat(padding));
        IO.println(message);
    }
}