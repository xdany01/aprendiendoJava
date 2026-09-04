package org.example.app.practicas.practica02;

public class Practica02 {
    public void showVariables() {
        int number1 = 10;
        IO.println("int number = " + number1);
        IO.println("Size int -> " + Integer.BYTES);

        float number2 = 10.5f;
        IO.println("float number2 = " + number2);
        IO.println("Size float -> " + Float.BYTES);

        double number3 = 3.1415926535;
        IO.println("double number3 = " + number3);
        IO.println("Size double -> " + Double.BYTES);

        boolean bool = true;
        IO.println("bool = " + bool);
        IO.println("Size bool -> " + Boolean.FALSE);

        char ch = 'a';
        IO.println("char ch = " + ch);
        IO.println("Size char -> " + Character.BYTES);

        String str = "cadena de caracteres";
        IO.println("String str = " + str);
        IO.println("Size String -> " + str);

        var myVar = "Uso de de tipo var";
        IO.println("var myVar = " + myVar);

        final double PI = Math.PI;
        IO.println("Uso de constante:\nfinal double PI = " + PI);
    }
}
