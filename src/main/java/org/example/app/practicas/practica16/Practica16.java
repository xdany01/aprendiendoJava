package org.example.app.practicas.practica16;

public class Practica16 {
    public void useVarArg(int ...numbers){
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
