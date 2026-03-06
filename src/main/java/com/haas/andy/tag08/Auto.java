package com.haas.andy.tag08;

public class Auto {

    // Private  attribute des Autos
    private String farbe;
    private int maximaleGeschwindigkeit;
    private int momentGeschwindigkeit;
    String lenkradAusrichtung; //(Z. B- "links". "rechts"

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public int getMaximaleGeschwindigkeit() {
        return maximaleGeschwindigkeit;
    }

    public void setMaximaleGeschwindigkeit(int maximaleGeschwindigkeit) {
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
    }

    public int getMomentGeschwindigkeit() {
        return momentGeschwindigkeit;
    }

    public void setMomentGeschwindigkeit(int momentGeschwindigkeit) {
        this.momentGeschwindigkeit = momentGeschwindigkeit;
    }





    // Erstelle ein Konstruktor zur Initialisierung von Instanzen
    Auto(String farbe, int maximaleGeschwindigkeit){
        this.farbe = farbe;
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
        this.momentGeschwindigkeit = 0;
        this.lenkradAusrichtung = "geradeaus";
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


