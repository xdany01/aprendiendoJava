package org.example.app;

import org.example.app.practicas.practica01.Practica01;
import org.example.app.practicas.practica02.Practica02;
import org.example.app.practicas.practica03.Practica03;
import org.example.app.practicas.practica04.Practica04;

public class Main {
    static void main() {
//        testPractica01();
//        testPractica02();
//        testPractica03();
        testPractica04();
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
}
