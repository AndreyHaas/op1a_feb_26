package ohneKonstruktor;

public class Auto {

    // attributes des Autos
    String farbe;
    int maximaleGeschwindigkeit;
    int momentGeschwindigkeit;
    String lenkradAusrichtung; //(Z. B- "links". "rechts"

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
