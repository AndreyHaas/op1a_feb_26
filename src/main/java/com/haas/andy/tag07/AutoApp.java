package com.haas.andy.tag07;

public class AutoApp {
    static void main() {
        AutoWoKonstruktoren rotesAuto = new AutoWoKonstruktoren();
        rotesAuto.farbe = "Rot";
        AutoWoKonstruktoren gruenesAuto = new AutoWoKonstruktoren();
        gruenesAuto.farbe = "Grün";
        AutoWoKonstruktoren schwarzesAuto = new AutoWoKonstruktoren();
        schwarzesAuto.farbe = "Schwarz";
        AutoWoKonstruktoren gelbAuto = new AutoWoKonstruktoren();
        gelbAuto.farbe = "Gelb";

        AutoMitKonstruktoren rotAutoMitKonstruktoren = new AutoMitKonstruktoren("Rot", "geradeaus");
        System.out.println(rotAutoMitKonstruktoren);
    }
}
