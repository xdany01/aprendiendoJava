package org.example.app.practicas.practica08.presentation;

import org.example.app.helpful.Logger;
import org.example.app.helpful.ScannerInputHelpful;
import org.example.app.practicas.practica08.model.TypeForm;
import org.example.app.practicas.practica08.service.IAuthService;

import java.util.Scanner;

public class Login {

    private final IAuthService authService;

    public Login(IAuthService authService) {
        this.authService = authService;
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        ScannerInputHelpful inputHelpful = new ScannerInputHelpful(input);

        Logger.title("Login/Register");

        TypeForm[] typeFormValues = TypeForm.values();

        for (int i = 0; i < typeFormValues.length; i++) {
            IO.println(i + "-" + typeFormValues[i]);
        }

        int option = inputHelpful.solicitarValor(
                "Seleccione una opcion:",
                Scanner::nextInt,
                o -> o >= 0 && o < typeFormValues.length,
                "La opcion ingresada no es valida",
                0
        );

        String username = inputHelpful.solicitarValor(
                "Ingrese el nombre del usuario:",
                Scanner::nextLine,
                u -> !u.isEmpty(),
                "El usuario no puede ser vacio",
                ""
        );

        if (username.isEmpty()) {
            IO.println("El usuario ingresado no es valido");
            return;
        }

        String password = inputHelpful.solicitarValor(
                "Ingrese la contraseña:",
                Scanner::nextLine,
                u -> !u.isEmpty(),
                "La contraseña no puede ser vacio",
                ""
        );

        if (password.isEmpty()) {
            IO.println("La contraseña ingresada no es valida");
            return;
        }

        if (option == 1) {
            authService.register(username, password);
            Logger.success("Usuario registrado correctamente");
            return;
        }

        boolean valid = authService.login(username, password);

        if (valid) {
            Logger.success("¡Usuario login exitoso!");
        } else {
            Logger.error("Usuario o contraseña incorrectos");
        }

    }
}
