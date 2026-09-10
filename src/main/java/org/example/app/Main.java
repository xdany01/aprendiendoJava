package org.example.app;

import org.example.app.practicas.practica01.Practica01;
import org.example.app.practicas.practica02.Practica02;
import org.example.app.practicas.practica03.Practica03;
import org.example.app.practicas.practica04.Practica04;
import org.example.app.practicas.practica05.Practica05;
import org.example.app.practicas.practica06.Practica06;
import org.example.app.practicas.practica07.Practica07;
import org.example.app.practicas.practica08.presentation.Login;
import org.example.app.practicas.practica08.repository.IUserRepository;
import org.example.app.practicas.practica08.repository.JsonUserRepository;
import org.example.app.practicas.practica08.service.AuthService;
import org.example.app.practicas.practica08.service.IAuthService;
import org.example.app.practicas.practica09.Practica09;
import org.example.app.practicas.practica10.Practica10;

import java.net.URISyntaxException;

public class Main {
    static void main() {
//        testPractica01();
//        testPractica02();
//        testPractica03();
//        testPractica04();
//        testPractica05();
//        testPractica06();
//        testPractica07();
//        testPractica08();
//        testPractica09();
        testPractica10();
    }

    static void testPractica01() {
        Practica01 p = new Practica01();
        p.sayHello();
    }

    static void testPractica02() {
        Practica02 p = new Practica02();
        p.showVariables();
    }

    static void testPractica03() {
        Practica03 p = new Practica03();
        p.useString();
    }

    static void testPractica04() {
        Practica04 p = new Practica04();
//        p.useScanner();
        p.useScanner2();
    }

    static void testPractica05() {
        Practica05 p = new Practica05();
        p.processRecipe();
    }

    static void testPractica06() {
        Practica06 p = new Practica06();
        p.stringFormat();
    }

    static void testPractica07() {
        Practica07 p = new Practica07();
        p.generatorID();
    }

    static void testPractica08() {
//        Path file = Path.of(System.getProperty("user.dir"), "practica08-users.json"); // path del proyecto
//        IUserRepository userRepository = new JsonUserRepository(file);
        IUserRepository userRepository = new JsonUserRepository(); // path por defecto temp del sistema
        IAuthService authService = new AuthService(userRepository);
        Login login = new Login(authService);
        login.run();
    }

    static void testPractica09() {
        Practica09 p = new Practica09();
        p.showRootPath();
        p.showUserHomePath();
        p.showTempPath();

        try {
            p.showExecutionPath();
            p.showJarPath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    static void testPractica10() {
        Practica10 p = new Practica10();
        p.printTriangle();
        System.out.println();
        p.printTriangleInverse();
        System.out.println();
        p.printTriangleEquilateral();
        System.out.println();
        p.printTriangleEquilateralInverse();
        System.out.println();
        p.printTriangleRight();
        System.out.println();
        p.printTriangleLeft();
        System.out.println();
        p.printTriangleEmpty();
        System.out.println();
        p.printRectangle();
        System.out.println();
        p.printDiamond();
        System.out.println();
        p.printCross();
        System.out.println();
        p.printHeart();
        System.out.println();
    }
}
