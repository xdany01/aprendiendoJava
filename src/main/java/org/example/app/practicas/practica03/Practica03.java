package org.example.app.practicas.practica03;

import org.example.app.helpful.Helpful;

public class Practica03 {
    public void useString() {
        IO.println("Declaracion de variables");
        String str1 = "Hello World";
        IO.println("str1 = " + str1);

        String str2 = "Hello World";
        IO.println("str2 = " + str2);

        String str3 = new String("Hello World");
        IO.println("str3 = " + str3);

        IO.println();

        IO.println("Comparacion de Strings");
        boolean bool1 = str1 == str2;
        IO.println("str1 == str2 -> " + bool1);
        boolean bool2 = str1.equals(str2);
        IO.println("str1.equal(str2) -> " + bool2);
        boolean bool3 = str1 == str3;
        IO.println("str1 == str3 -> " + bool3);
        boolean bool4 = str1.equals(str3);
        IO.println("str1.equals(str3) -> " + bool4);
        IO.println("Conclision:\n'==' -> compara referencia\n'equal' -> compara contenido");
        IO.println("Nota:\nPara clases propias sobreescribir 'equal'\ny 'hashcode' para la comparacion");

        IO.println();

        IO.println("Algunos metodos de la clase Strings");
        Helpful.printStringAsArray(str1);

        String strLowerCase = str1.toLowerCase();
        IO.println("str1.toLowerCase() -> " + strLowerCase);

        String strUpperCase = str1.toUpperCase();
        IO.println("str1.toUpperCase() -> " + strUpperCase);

        char ch = str1.charAt(1);
        IO.println("str1.charAt(1) -> " + ch);

        int strLong = str1.length();
        IO.println("Obtener la longitud de una cadena\nstr1.length() -> " + strLong);

        String strTrim = str1.trim();
        IO.println("Limpiar espacios al inicio y final de la cadena\nstr1.trim() -> " + strTrim);

        String strSubstr1 = str1.substring(6);
        IO.println("str1.substring(5) -> " + strSubstr1);
        String strSubstr2 = str1.substring(6, 8);
        IO.println("str1.substring(5, 8) -> " + strSubstr2);

        int indexCharO = str1.indexOf("o");
        IO.println("str1.indexOf(\"o\") -> " + indexCharO);
        int lastIndexCharO = str1.lastIndexOf("o");
        IO.println("str1.lastIndexOf(\"o\") -> " + lastIndexCharO);

        String strReplace = str1.replace("World", "Everyone");
        IO.println("str1.replace(\"World\", \"Everyone\") -> " + strReplace);

        String hello = "Hola";
        String world = "Mundo";
        String sayHello = hello.concat(" ").concat(world);
        IO.println("uso de concat -> " + sayHello);

        StringBuilder builder = new StringBuilder();
        builder.append(hello);
        builder.append(" ");
        builder.append(world);
        IO.println("uso de StringBuilder -> " + builder.toString());

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hello);
        stringBuffer.append(" ");
        stringBuffer.append(world);
        IO.println("uso de StringBuffer -> " + stringBuffer.toString());

        String strJoin = String.join(" ", hello, world);
        IO.println("String.join(\" \", hello, world) -> " + strJoin);

        String name = "Daniel Nunez";
        String company = "Compania Acme";
        String domain = "com.ar";

        String emailPart1 = processEmailString(name, ".");
        String emailPart2 = processEmailString(company, "");
        String emailComplete = emailPart1 + "@" + emailPart2 + "." + domain;

        IO.println("Process email -> " + emailComplete);

    }

    private String processEmailString(String str, String repl) {
        return str.trim().toLowerCase().replace(" ", repl);
    }
}
