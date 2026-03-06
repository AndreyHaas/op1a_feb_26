package mitKonstruktor;

import com.haas.andy.tag07.materialen.mitKonstruktor.Auto;

public class Main {
    static void main(String[] args) {
        // Erstellen von 5 Instanzen

        // 1. Rotes Auto
        Auto rotesAuto = new Auto("Rot",120);


        // 2. Gelb
        Auto gelbesAuto = new Auto("Gelb",130);

        Auto blauesAuto = new Auto("Blau",130);


        // Aufrufen von Methoden
        System.out.println("Vor dem Beschleunigen: " + rotesAuto.momentGeschwindigkeit);
        rotesAuto.beschleunigen(20);
        System.out.println("Nach dem Beschleunigen: " + rotesAuto.momentGeschwindigkeit);


    }
}
