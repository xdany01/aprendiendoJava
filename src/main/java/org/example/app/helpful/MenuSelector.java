package org.example.app.helpful;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

import java.io.IOException;
import java.util.List;

public class MenuSelector {
    public static int seleccionar(String titulo, List<String> opciones) {
        if (opciones == null || opciones.isEmpty()) {
            throw new IllegalArgumentException("La lista de opciones no puede estar vacía");
        }

        try (Terminal terminal = TerminalBuilder.builder().system(true).build()) {
            terminal.enterRawMode();
            terminal.writer().print("\033[?25l"); // ocultar cursor
            terminal.writer().flush();

            int selected = 0;
            draw(terminal, titulo, opciones, selected);

            while (true) {
                int c = terminal.reader().read(); // bloqueante

                if (c == 27) { // ESC: inicio de secuencia
                    int next1 = terminal.reader().read();

                    // Puede ser '[' (modo normal) o 'O' (modo aplicación/SS3)
                    if (next1 == '[' || next1 == 'O') {
                        int next2 = terminal.reader().read();
                        switch (next2) {
                            case 'A': // flecha arriba
                                selected = (selected - 1 + opciones.size()) % opciones.size();
                                draw(terminal, titulo, opciones, selected);
                                break;
                            case 'B': // flecha abajo
                                selected = (selected + 1) % opciones.size();
                                draw(terminal, titulo, opciones, selected);
                                break;
                            // C (derecha) y D (izquierda) se ignoran
                        }
                    }
                    // ESC solo: podrías usarlo para cancelar devolviendo -1
                } else if (c == 13 || c == 10) { // Enter
                    break;
                } else if (c == 'q' || c == 'Q') {
                    return -1;
                }
            }

            return selected;
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el terminal para el menú", e);
        } finally {
            System.out.print("\033[?25h");
            System.out.flush();
        }
    }

    private static void draw(Terminal terminal, String titulo, List<String> opciones, int selected) {
        terminal.puts(InfoCmp.Capability.clear_screen);
        terminal.writer().print(titulo + "\n\n");

        for (int i = 0; i < opciones.size(); i++) {
            if (i == selected) {
                terminal.writer().println("\033[7m> " + opciones.get(i) + "\033[0m");
            } else {
                terminal.writer().println("  " + opciones.get(i));
            }
        }
        terminal.writer().println("\n[↑↓] navegar   [Enter] seleccionar   [q] salir");
        terminal.writer().flush();
    }
}