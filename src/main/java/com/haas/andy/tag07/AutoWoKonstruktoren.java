package com.haas.andy.tag07;

public class AutoWoKonstruktoren {
    String farbe;
    int maximaleGeschwindigkeit;
    int momentGeschwindigkeit;
    String lenkradAusrichtung;

    void beschleunigung(int geschwindigkeit){
        momentGeschwindigkeit+=geschwindigkeit;
        if (momentGeschwindigkeit > maximaleGeschwindigkeit){
            momentGeschwindigkeit=maximaleGeschwindigkeit;
        }
    }

    void bremsen(int geschwindigkeit){
        momentGeschwindigkeit-=geschwindigkeit;
        if (momentGeschwindigkeit < 0){
            momentGeschwindigkeit=0;
        }
    }

    void lenken(String richtung){
        lenkradAusrichtung=richtung;
    }
}
