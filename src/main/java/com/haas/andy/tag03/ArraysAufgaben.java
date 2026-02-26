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


        /*
         Maximum in 2D-Array
         */
        int[][] zahlen = {
                {3, 7, 2}, 
                {9, 4, 1}, 
                {6, 8, 5}
        };

        int max = zahlen[0][0];

        for (int i = 0; i < zahlen.length; i++) {
            for (int j = 0; j < zahlen[i].length; j++) {
                if (zahlen[i][j] > max) {
                    max = zahlen[i][j];
                }
            }
        }

//        int max = Arrays.stream(zahlen)
//                .flatMapToInt(Arrays::stream)
//                .max()
//                .getAsInt();

        System.out.println("Maximum: " + max);

        /*
            Multiplikationstabelle.
            Erstellen Sie ein 10x10-Array und speichern Sie darin eine Multiplikationstabelle.
         */
        int[][] tabelle = new int[10][10];

        for (int i = 0; i < tabelle.length; i++) {
            for (int j = 0; j < tabelle[i].length; j++) {
                tabelle[i][j] = (i + 1) * (j + 1);
            }
        }

        System.out.println("10x10 Multiplikationstabelle:");
        System.out.println("========================================");

        for (int[] ints : tabelle) {
            for (int anInt : ints) {
                System.out.printf("%4d", anInt);
            }
            System.out.println();
        }

        /*
            Diagonalsumme
            Berechnen Sie bei einer 3x3-Matrix die Summe der Hauptdiagonale.
        */
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int summ = hauptdiagonaleSummeBerechnung(matrix);
        System.out.println("Hauptdiagonale Summe läutet: " + summ);
    }

    public static int hauptdiagonaleSummeBerechnung(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Matrix muss quadratisch sein!");
        }

        int summe = 0;

        for (int i = 0; i < matrix.length; i++) {
            summe += matrix[i][i];
        }

        return summe;
    }
}
