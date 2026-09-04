package org.example.app;


import org.example.app.practicas.practica01.Practica01;
import org.example.app.practicas.practica02.Practica02;

public class Main {
    static void main() {
//        testPractica01();
        testPractica02();
    }

    static void testPractica01() {
        Practica01 p = new Practica01();
        p.sayHello();
    }

    static void testPractica02() {
        Practica02 p = new Practica02();
        p.showVariables();
    }
}
