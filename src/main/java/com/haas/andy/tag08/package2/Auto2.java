package com.haas.andy.tag08.package2;

public class Auto2 {

    // Private  attribute des Autos
    public String farbe;
    int maximaleGeschwindigkeit;
    int momentGeschwindigkeit;
    protected String  lenkradAusrichtung;


    // Erstelle ein Konstruktor zur Initialisierung von Instanzen
    Auto2(String farbe, int maximaleGeschwindigkeit){
        this.farbe = farbe;
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
        this.momentGeschwindigkeit = 0;
        this.lenkradAusrichtung = "geradeaus";
    }

    public Auto2() {
    }


    // Methoden
    // beschleunigen(): erhöht die momentane Geschwindigkeit um den angegebenen Wert
    void  beschleunigen(int geschwindigkeit){
        momentGeschwindigkeit += geschwindigkeit;
        if(momentGeschwindigkeit > maximaleGeschwindigkeit) {
            momentGeschwindigkeit = maximaleGeschwindigkeit; // begrenze die Geschwindigkeit

        }

    }


    // bremsen(): verringert die momentane Geschwindigkeit um den angegebenen Wert
    void  bremsen(int geschwindigkeit){
        momentGeschwindigkeit -= geschwindigkeit;
        if(momentGeschwindigkeit < 0) {
            momentGeschwindigkeit = 0; // verhindert, dass die Geschwindigkeit negativ wird

        }

    }

    // Methode zum Lenken des Autos
    void  lenken(String richtung){
        lenkradAusrichtung = richtung; // ändert die Richtung des Lenkrads
    }


}


