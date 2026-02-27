package com.haas.andy.tag03;

import java.util.Arrays;

public class ArraysAufgaben {
    public static void main(String[] args) {
     /*
        Erstellen Sie ein Array mit 10 Elementen.
        Speichern Sie die Werte 5, 10, 15, …, 50.
     */

        int[] array = new int[10];
        int zahl = 5;

        for (int i = 0; i < array.length; i++) {
            array[i] = zahl;
            zahl += 5;
        }

        System.out.println(Arrays.toString(array));

        /*Durchschnitt berechnen*/
        int[] werte = {4, 8, 15, 16, 23, 42};
        int summe = 0;

        for (int wert : werte) {
            summe += wert;
        }

        System.out.println("Durchschnitt: " + summe / werte.length);
    }
}
