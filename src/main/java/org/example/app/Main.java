package org.example.app;

import org.example.app.helpful.ArrayHelpful;
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
import org.example.app.practicas.practica11.Practica11;
import org.example.app.practicas.practica12.Practica12;

import java.net.URISyntaxException;
import java.util.Arrays;

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
//        testPractica10();
//        testPractica11();
        testPractica12();
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

    static void testPractica11() {
        Practica11 p = new Practica11();
        p.toAverageGrades();
        System.out.println();
    }

    static void testPractica12() {
        Practica12 p = new Practica12();
        int[] primitivos = new int[]{4, 7, 8, 25, 12, 15, 80, 99, 32, 45, 1};

        System.out.println(Arrays.toString(primitivos));

//        Integer[] wrappers = Arrays.stream(primitivos)
//                .boxed()
//                .toArray(Integer[]::new);

//        ArrayHelpful.printStringAsArray(ArrayHelpful.arrayToString(wrappers));

        int[] mergeSortPrimitivos = p.mergeSort(primitivos);

        System.out.println(Arrays.toString(mergeSortPrimitivos));

//        Integer[] mergeSortWrappers = Arrays.stream(mergeSortPrimitivos)
//                .boxed()
//                .toArray(Integer[]::new);

//        ArrayHelpful.printStringAsArray(ArrayHelpful.arrayToString(mergeSortWrappers));
    }


}
