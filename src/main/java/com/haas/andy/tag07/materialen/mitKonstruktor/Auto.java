package com.haas.andy.tag07.materialen.mitKonstruktor;

public class Auto {
    // attributes des Autos
    String farbe;
    int maximaleGeschwindigkeit;
    public int momentGeschwindigkeit;
    String lenkradAusrichtung; //(Z. B- "links". "rechts"


    // Konstruktor mit allen Attributen
    Auto(String farbe, int maximaleGeschwindigkeit, int momentaneGeschwindigkeit) {
        this.farbe = farbe;
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
        this.momentGeschwindigkeit = momentaneGeschwindigkeit;
        this.lenkradAusrichtung = "recht";
    }

    // Erstelle ein Konstruktor zur Initialisierung von Instanzen
    public Auto(String farbe, int maximaleGeschwindigkeit) {
        this.farbe = farbe;
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
        this.momentGeschwindigkeit = 0;
        this.lenkradAusrichtung = "geradeaus";
    }

    // Überlade den ersten Konstruktor
    Auto() {
        this.farbe = "schwarz";
        this.maximaleGeschwindigkeit = 120;
        this.momentGeschwindigkeit = 0;
        this.lenkradAusrichtung = "geradeaus";
    }

    // Methoden
    // beschleunigen(): erhöht die momentane Geschwindigkeit um den angegebenen Wert
    public void beschleunigen(int geschwindigkeit) {
        momentGeschwindigkeit += geschwindigkeit;
        if (momentGeschwindigkeit > maximaleGeschwindigkeit) {
            momentGeschwindigkeit = maximaleGeschwindigkeit; // begrenze die Geschwindigkeit

        }

    }


    // bremsen(): verringert die momentane Geschwindigkeit um den angegebenen Wert
    void bremsen(int geschwindigkeit) {
        momentGeschwindigkeit -= geschwindigkeit;
        if (momentGeschwindigkeit < 0) {
            momentGeschwindigkeit = 0; // verhindert, dass die Geschwindigkeit negativ wird

        }

    }

    // Methode zum Lenken des Autos
    void lenken(String richtung) {
        lenkradAusrichtung = richtung; // ändert die Richtung des Lenkrads
    }


}


