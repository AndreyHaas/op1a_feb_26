package com.haas.andy.tag04;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Erstelle instanz (Objekt) von der Klasse MethodenBeispiel
        MethodenBeispiele beispiel =  new MethodenBeispiele();

        // Aufruf von der Instanz Method begruessung()
        beispiel.begruessung();

        // Aufruf von der Instanz Method addiere(int zahl1, int zahl2)
        int ergebniss = beispiel.addiere(3,5);
        System.out.println("ergebniss: "+ ergebniss);

        // Aufruf der Methode mit mehreren Parametern (Durchschnitt)
        double durschnitt = beispiel.berechneDurchschnitt(10,20,30);
        System.out.println("durschnitt: "+ durschnitt);

        // Aufruf der überladenen Methoden
        double ergebnissDouble = beispiel.addiere(3.4,5.9,7.8);
        System.out.println("ergebnissDouble: "+ ergebnissDouble);

    }
}