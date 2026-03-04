package com.haas.andy.tag07;

import java.util.StringJoiner;

public class AutoMitKonstruktoren {
    String farbe;
    int maximaleGeschwindigkeit;
    int momentGeschwindigkeit;
    String lenkradAusrichtung;

    public AutoMitKonstruktoren() {}

    public AutoMitKonstruktoren(String farbe) {
        this.farbe = farbe;
    }

    public AutoMitKonstruktoren(String farbe, int maximaleGeschwindigkeit) {
        this.farbe = farbe;
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
    }

    public AutoMitKonstruktoren(String farbe,
                                int maximaleGeschwindigkeit,
                                int momentGeschwindigkeit) {
        this.farbe = farbe;
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
        this.momentGeschwindigkeit = momentGeschwindigkeit;
    }

    public AutoMitKonstruktoren(String farbe,
                                int maximaleGeschwindigkeit,
                                int momentGeschwindigkeit,
                                String lenkradAusrichtung) {
        this.farbe = farbe;
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
        this.momentGeschwindigkeit = momentGeschwindigkeit;
        this.lenkradAusrichtung = lenkradAusrichtung;
    }

    public AutoMitKonstruktoren(int maximaleGeschwindigkeit,
                                int momentGeschwindigkeit) {
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
        this.momentGeschwindigkeit = momentGeschwindigkeit;
    }

    public AutoMitKonstruktoren(int momentGeschwindigkeit, String lenkradAusrichtung) {
        this.momentGeschwindigkeit = momentGeschwindigkeit;
        this.lenkradAusrichtung = lenkradAusrichtung;
    }

    public AutoMitKonstruktoren(String farbe, String lenkradAusrichtung) {
        this.farbe = farbe;
        this.lenkradAusrichtung = lenkradAusrichtung;
    }

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

    @Override
    public String toString() {
        return new StringJoiner(", ", AutoMitKonstruktoren.class.getSimpleName() + "[", "]")
                .add("farbe='" + farbe + "'")
                .add("maximaleGeschwindigkeit=" + maximaleGeschwindigkeit)
                .add("momentGeschwindigkeit=" + momentGeschwindigkeit)
                .add("lenkradAusrichtung='" + lenkradAusrichtung + "'")
                .toString();
    }
}

