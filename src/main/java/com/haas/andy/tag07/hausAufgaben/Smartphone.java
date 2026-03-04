package com.haas.andy.tag07.hausAufgaben;

import java.util.StringJoiner;

public class Smartphone {
    private String marke;
    private String modell;
    private int speicher;
    private double preis;

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getSpeicher() {
        return speicher;
    }

    public void setSpeicher(int speicher) {
        this.speicher = speicher;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Smartphone() {}

    public Smartphone(String marke, String modell) {
        this.marke = marke;
        this.modell = modell;
    }

    public Smartphone(String marke, String modell, int speicher, double preis) {
        this.marke = marke;
        this.modell = modell;
        this.speicher = speicher;
        this.preis = preis;
    }

    String zeigeDetails() {
        return "Marke: " + getMarke() +
                ", Modell :" + getModell() +
                ", Speicher: " + getSpeicher() +
                ", Preis: " + getPreis();
    }

    double preisNachRabatt(double rabattProzent){
        return rabattProzent * this.preis;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Smartphone.class.getSimpleName() + "[", "]")
                .add("marke='" + marke + "'")
                .add("modell='" + modell + "'")
                .add("speicher=" + speicher)
                .add("preis=" + preis)
                .toString();
    }
}
