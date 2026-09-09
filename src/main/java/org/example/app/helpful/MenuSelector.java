package org.example.app.helpful;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;
import java.util.List;

/**
 * Helper reusable para mostrar una lista de opciones navegable con flechas
 * (↑/↓) y confirmar con Enter, resaltando la opción actual. Pensado como
 * equivalente "sin widgets" a un menú de botones, siguiendo el mismo
 * espíritu que ScannerInputHelpful pero para selección en vez de texto.
 */
public class MenuSelector {

    /**
     * Muestra el menú y bloquea hasta que el usuario confirma una opción con Enter.
     *
     * @param titulo   texto que se muestra arriba de las opciones
     * @param opciones lista de opciones a mostrar (se muestran en el mismo orden)
     * @return índice (0-based) de la opción elegida
     */
    public static int seleccionar(String titulo, List<String> opciones) {
        if (opciones == null || opciones.isEmpty()) {
            throw new IllegalArgumentException("La lista de opciones no puede estar vacía");
        }

        try (Terminal terminal = TerminalBuilder.builder().system(true).build()) {
            terminal.enterRawMode();
            terminal.writer().print("\033[?25l"); // ocultar cursor real mientras se navega
            terminal.writer().flush();

            int selected = 0;
            draw(terminal, titulo, opciones, selected);

            NonBlockingReader reader = terminal.reader();
            while (true) {
                int c = reader.read();

                if (c == 27) { // ESC o el inicio de una secuencia de flecha
                    int next1 = reader.read(50);
                    if (next1 == '[') {
                        int next2 = reader.read(50);
                        if (next2 == 'A') { // flecha arriba
                            selected = (selected - 1 + opciones.size()) % opciones.size();
                            draw(terminal, titulo, opciones, selected);
                        } else if (next2 == 'B') { // flecha abajo
                            selected = (selected + 1) % opciones.size();
                            draw(terminal, titulo, opciones, selected);
                        }
                        // izquierda/derecha (C/D) se ignoran, no aplican a una lista vertical
                    }
                    // ESC solo (sin '[' después) no hace nada acá; si querés que
                    // cancele el menú, se puede agregar un valor de retorno especial (ej: -1)
                } else if (c == 13 || c == 10) { // Enter
                    break;
                }
            }

            return selected;
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el terminal para el menú", e);
        } finally {
            // Restaurar el cursor visible al salir (el terminal en sí ya se
            // restaura solo por el try-with-resources al cerrar Terminal)
            System.out.print("\033[?25h");
            System.out.flush();
        }
    }

    private static void draw(Terminal terminal, String titulo, List<String> opciones, int selected) {
        StringBuilder sb = new StringBuilder();
        sb.append("\033[H\033[2J"); // cursor a origen + limpiar pantalla
        sb.append(titulo).append("\n\n");

        for (int i = 0; i < opciones.size(); i++) {
            if (i == selected) {
                sb.append("\033[7m> ").append(opciones.get(i)).append("\033[0m\n"); // resaltado (video inverso)
            } else {
                sb.append("  ").append(opciones.get(i)).append("\n");
            }
        }

        sb.append("\n[↑↓] navegar   [Enter] seleccionar\n");
        terminal.writer().print(sb);
        terminal.writer().flush();
    }
}