package com.haas.andy.tag04;

public class MethodenBeispiele {
    // Methode ohne Rückgabewert (void) – einfache Begrüßung
    public void begruessung() {
        System.out.println("Hallo! Willkommen zu Java-Methoden.");
    }

    // Methode mit Rückgabewert – Berechnung der Summe von zwei Zahlen
    public int addiere(int zahl1, int zahl2) {
        int summe = zahl1 + zahl2;
        return summe;
    }

    // Methode mit mehreren Parametern – Berechnung des Durchschnitts von drei Zahlen
    public double berechneDurchschnitt(int zahl1, int zahl2, int zahl3) {
        return (zahl1 + zahl2 + zahl3) / 3.0;
    }

    // Überladene Methode: zweite Variante, diese addiert drei Zahlen
    public double addiere(double zahl1, double zahl2, double zahl3) {
        double summe = zahl1 + zahl2 + zahl3;
        return summe;
    }

    public static void main(String[] args) {
        // Erstelle instanz (Objekt) von der Klasse MethodenBeispiel
        MethodenBeispiele beispiel = new MethodenBeispiele();

        // Aufruf von der Instanz Method begruessung()
        beispiel.begruessung();

        // Aufruf von der Instanz Method addiere(int zahl1, int zahl2)
        int ergebniss = beispiel.addiere(3, 5);
        System.out.println("ergebniss: " + ergebniss);

        // Aufruf der Methode mit mehreren Parametern (Durchschnitt)
        double durschnitt = beispiel.berechneDurchschnitt(10, 20, 30);
        System.out.println("durschnitt: " + durschnitt);

        // Aufruf der überladenen Methoden
        double ergebnissDouble = beispiel.addiere(3.4, 5.9, 7.8);
        System.out.println("ergebnissDouble: " + ergebnissDouble);
    }
}