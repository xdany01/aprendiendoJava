package org.example.app.practicas.practica08.presentation;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.Theme;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.example.app.practicas.practica08.service.IAuthService;

import java.io.IOException;
import java.util.List;

public class LoginTUI {

    private final IAuthService authService;

    public LoginTUI(IAuthService authService) {
        this.authService = authService;
    }

    public void run() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        try {
            WindowBasedTextGUI gui = new MultiWindowTextGUI(screen,
                    new DefaultWindowManager(),
                    new EmptySpace(TextColor.ANSI.DEFAULT));

            showLoginWindow(gui);
        } finally {
            screen.stopScreen();
        }
    }

    private void showLoginWindow(WindowBasedTextGUI gui) {
        BasicWindow window = new BasicWindow("Login");
        window.setHints(List.of(Window.Hint.CENTERED));

        Panel panel = new Panel(new GridLayout(2));

        TextBox usernameBox = new TextBox().setPreferredSize(new TerminalSize(20, 1));
        TextBox passwordBox = new TextBox().setMask('*').setPreferredSize(new TerminalSize(20, 1));
        Label statusLabel = new Label("").setForegroundColor(TextColor.ANSI.RED);

        panel.addComponent(new Label("Usuario:"));
        panel.addComponent(usernameBox);
        panel.addComponent(new Label("Contraseña:"));
        panel.addComponent(passwordBox);

        Button loginButton = new Button("Ingresar", () -> {
            boolean ok = authService.login(usernameBox.getText(), passwordBox.getText());
            if (ok) {
                statusLabel.setForegroundColor(TextColor.ANSI.GREEN);
                statusLabel.setText("¡Login exitoso!");
            } else {
                statusLabel.setForegroundColor(TextColor.ANSI.RED);
                statusLabel.setText("Usuario o contraseña incorrectos");
            }
        });

        Button registerButton = new Button("Registrarse", () -> {
            authService.register(usernameBox.getText(), passwordBox.getText());
            statusLabel.setForegroundColor(TextColor.ANSI.GREEN);
            statusLabel.setText("Usuario creado");
        });

        panel.addComponent(new EmptySpace());
        panel.addComponent(loginButton);
        panel.addComponent(new EmptySpace());
        panel.addComponent(registerButton);
        panel.addComponent(new EmptySpace());
        panel.addComponent(statusLabel);

        window.setComponent(panel);
        gui.addWindowAndWait(window);
    }
}