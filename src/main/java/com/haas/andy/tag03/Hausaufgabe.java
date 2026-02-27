package com.haas.andy.tag03;

import java.util.Arrays;
import java.util.Random;

public class Hausaufgabe {

    static class Uebung1 {
        static void main() {
            int[] zahlen = new int[5];
            zahlen[0] = 10;
            zahlen[1] = 20;
            zahlen[2] = 30;
            zahlen[3] = 40;
            zahlen[4] = 50;

            System.out.println("Array-Elemente:");

            for (int i = 0; i < zahlen.length; i++) {
                System.out.println("zahlen[" + i + "] = " + zahlen[i]);
            }
        }
    }

    static class Uebung2 {
        static void main() {
            double[] zahlen = new double[10];

            for (int i = 0; i < zahlen.length; i++) {
                zahlen[i] = i * 2.5;
            }

            double summe = 0;

            for (int i = 0; i < zahlen.length; i++) {
                summe += zahlen[i];
            }

            double durchschnitt = summe / zahlen.length;

            System.out.println("Array-Werte:");

            for (double wert : zahlen) {
                System.out.print(wert + " ");
            }

            System.out.println("\nDurchschnitt: " + durchschnitt);
        }
    }

    static class Uebung3 {
        static void main() {
            int[] zahlen = new int[10];
            Random random = new Random();

            for (int i = 0; i < zahlen.length; i++) {
                zahlen[i] = random.nextInt(100) + 1;
            }

            int min = zahlen[0];
            int max = zahlen[0];

            for (int i = 1; i < zahlen.length; i++) {
                if (zahlen[i] < min) {
                    min = zahlen[i];
                }

                if (zahlen[i] > max) {
                    max = zahlen[i];
                }
            }

            System.out.println("Zufallszahlen:");

            for (int zahl : zahlen) {
                System.out.print(zahl + " ");
            }

            System.out.println("\nMinimum: " + min);
            System.out.println("Maximum: " + max);
        }
    }

    static class Uebung4 {
        static void main() {
            int[] zahlen = {45, 23, 78, 12, 89, 34, 56, 91, 67, 8};

            System.out.println("Unsoriertes Array:");

            for (int zahl : zahlen) {
                System.out.print(zahl + " ");
            }

            Arrays.sort(zahlen);

            System.out.println("\nSortiertes Array:");

            for (int zahl : zahlen) {
                System.out.print(zahl + " ");
            }
        }
    }

    static class Uebung5 {
        static void main() {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            System.out.println("3x3 Matrix:");

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }

                System.out.println(); // Neue Zeile nach jeder Reihe
            }
        }
    }

    static class Uebung6 {
        static void main() {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            System.out.println("Matrix:");

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }

                System.out.println();
            }

            int summe = 0;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    summe += matrix[i][j];
                }
            }

            System.out.println("Summe aller Elemente: " + summe);
        }
    }
}