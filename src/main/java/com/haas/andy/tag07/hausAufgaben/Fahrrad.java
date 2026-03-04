package com.haas.andy.tag07.hausAufgaben;

import java.util.StringJoiner;

public class Fahrrad {
    private String marke;
    private String typ;
    private int ganganzahl;
    private double preis;

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getGanganzahl() {
        return ganganzahl;
    }

    public void setGanganzahl(int ganganzahl) {
        this.ganganzahl = ganganzahl;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Fahrrad() {}

    public Fahrrad(String marke, String typ) {
        this.marke = marke;
        this.typ = typ;
    }

    public Fahrrad(String marke, String typ, int ganganzahl, double preis) {
        this.marke = marke;
        this.typ = typ;
        this.ganganzahl = ganganzahl;
        this.preis = preis;
    }

    String zeigeDetails() {
        return "Marke: " + this.marke +
                ", Typ: " + this.typ +
                ", Ganganzahl: " + this.ganganzahl +
                ", Preis: " + this.preis;
    }

    boolean hatVieleGaenge(){
        return this.ganganzahl > 10;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Fahrrad.class.getSimpleName() + "[", "]")
                .add("marke='" + marke + "'")
                .add("typ='" + typ + "'")
                .add("ganganzahl=" + ganganzahl)
                .add("preis=" + preis)
                .toString();
    }
}
