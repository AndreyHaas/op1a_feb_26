package com.haas.andy.tag03;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class VerschahtelteArray {
    static void main() {
        // =====================================
        // 1. Einführung: 1-Dimensionales Array
        // =====================================
        // Wir starten mit einem einfachen 1-dimensionalen Array und erweitern dieses später zu mehrdimensionalen Arrays.
        int[] schulnoten2018 = new int[]{4, 3, 2, 1}; // Beispiel: Schulnoten für das Jahr 2018
        System.out.println("Die 3. Note im Jahr 2018 war: " + schulnoten2018[2]); // Ausgabe der 3. Note (Index 2)

        // =====================================
        // 2. Einführung: 2-Dimensionales Array
        // =====================================
        // Hier erweitern wir unser Array um eine zweite Dimension, um Noten aus mehreren Jahren zu speichern.

        int[][] schulKariere = new int[][]{
                {3, 4, 5, 6}, // Jahr 1 (Index 0)
                {2, 1, 5, 4}, // Jahr 2 (Index 1)
                {4, 3, 2, 1}
        };
        System.out.println("2. Note im Jahr 1 war: " + schulKariere[0][1]); // Ausgabe: Note im 1. Jahr, 2. Prüfung

        // =====================================
        // 3. Einführung: 3-Dimensionales Array
        // =====================================
        // Erweiterung um eine dritte Dimension, z.B. für Noten mehrerer Schüler über mehrere Jahre.
        int[][][] schulStatistik = new int[][][]{
                // Schüler1

                {
                        {3, 4, 5, 6}, // Schüler1,Jahr 1 (Index 0)
                        {2, 1, 5, 4}, // Schüler1,Jahr 2 (Index 1)
                        {4, 3, 2, 1}  // Schüler1, Jahr 3
                },

                // Schüler2

                {
                        {2, 1, 2, 6}, // Jahr 1 (Index 0)
                        {4, 1, 5, 4}, // Jahr 2 (Index 1)
                        {6, 3, 2, 1}, // Jahr 3 (Index 1)
                }
        };

        System.out.println("Schüler 1 / Jahr 3 /");
// =====================================
        // 3. Einführung: 3-Dimensionales Array
        // =====================================
        // Erweiterung um eine dritte Dimension, z.B. für Noten mehrerer Schüler über mehrere Jahre.
        int[][][] schulStatistik1 = new int[][][]{// Schüler1
                {{3, 4, 5, 6}, // Schüler1,Jahr 1 (Index 0)
                        {2, 1, 5, 4}, // Schüler1,Jahr 2 (Index 1)
                        {4, 3, 2, 1}  // Schüler1, Jahr 3
                },

                // Schüler2

                {{2, 1, 2, 6}, // Jahr 1 (Index 0)
                        {4, 1, 5, 4}, // Jahr 2 (Index 1)
                        {6, 3, 2, 1}, // Jahr 3 (Index 1)
                }
        };

        System.out.println("Schüler 1 / Jahr 3 / Prüfung 4: " + schulStatistik[0][2][3]); // Zugriff auf spezifische Note

        // =====================================
        // 4. Nutzung von Arrays.deepToString()
        // =====================================
        // Diese Methoden helfen, die Inhalte von Arrays direkt auszugeben.
        System.out.println(Arrays.deepToString(schulStatistik)); // Ausgabe des kompletten 3D-Arrays


        // =====================================
        // 5. Größe von mehrdimensionalen Arrays
        // =====================================
        // Länge jeder Dimension des Arrays ausgeben.
        System.out.println("Anzahl der Schüler: " + schulStatistik.length);        // -> 2 (Schüler)

        System.out.println("Anzahl der Jahre der Schüler 1: " + schulStatistik[0].length);       // -> 3 (Jahre)

        System.out.println("Anzahl der Prüfungen der Schüler 1 in ersten Jahr: " + schulStatistik[0][0].length); // 4 (Prüfungen pro Jahr)

        // =====================================
        // 6. Ausgabe eines 3D-Arrays mit for-Schleife
        // =====================================
        // Strukturierte Ausgabe des Arrays,
        // =====================================
        //     // 7. Nachträgliche Initialisierung eines 2D-Arrays
        //     // =====================================
        //     // Erstellen eines 2D-Arrays mit 3 Klassen a verschiedenen Größen für jede Klasse.
        String[][] schuelerArray = new String[3][]; // 3 Klassen
        schuelerArray[0] = new String[20];// Klasse 1 mit 20 Schülern
        schuelerArray[1] = new String[15];// Klasse 2 mit 15 Schülern
        schuelerArray[2] = new String[25];// Klasse 3 mit 25 Schülern

        // =====================================
        // 8. Füllen und Ausgabe eines 2D-Arrays mit verschachtelten Schleifen
        // =====================================

        for (int klasse = 0; klasse < schuelerArray.length; klasse++) {


            for (int schueler = 0; schueler < schuelerArray[klasse].length; schueler++) {
                schuelerArray[klasse][schueler] = "Schüler " + (schueler + 1) + " in Klasse " + (klasse + 1);
            }

        }
        System.out.println("Schüler-Array:");
        System.out.println(Arrays.deepToString(schuelerArray));

        // =====================================
        // 9. Beispiel eines 3D-Arrays: Schule, Klassen und Schüler
        // =====================================

        String[][][] schulenArray = {
                // 1.st Schule
                {     // Klasse 1 á 10 Schueler*innen, Klasse 2 á 20 Schueler*innen, Klasse 3 á 12 Schueler*innen,
                        new String[10], new String[20], new String[12]
                },

                // 2.nd Schule
                {
                        new String[11], new String[21], new String[13], new String[23]
                }
        };

        for (int schule = 0; schule < schulenArray.length; schule++) {
            for (int klasse = 0; klasse < schulenArray[schule].length; klasse++) {
                for (int schueler = 0; schueler < schulenArray[schule][klasse].length; schueler++) {

                }
            }
        }

        // Hausaufgabe

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

        System.out.println("Maximum: " + max);
        int max1 = Arrays.stream(zahlen)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElseThrow(() -> new NoSuchElementException("Array is empty"));

        System.out.println("Maximum with stream: " + max1);

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

        System.out.println("Pythagoras tabelle:");
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