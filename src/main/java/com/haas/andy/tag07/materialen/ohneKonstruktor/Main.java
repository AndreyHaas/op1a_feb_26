package ohneKonstruktor;

public class Main {
    static void main(String[] args) {
        // Erstellen von 5 Instanzen
        //1.Rotes Auto
        Auto rotesAuto = new Auto();

        rotesAuto.farbe = "Rot";
        rotesAuto.maximaleGeschwindigkeit = 120;
        rotesAuto.momentGeschwindigkeit = 0;
        rotesAuto.lenkradAusrichtung = "geradeaus";

        // 2. Gelbes Auto
        Auto gelbesAuto = new Auto();

        gelbesAuto.farbe = "Gelb";
        gelbesAuto.maximaleGeschwindigkeit = 110;
        gelbesAuto.momentGeschwindigkeit = 0; // Initiale Geschwindigkeit
        gelbesAuto.lenkradAusrichtung = "geradeaus"; // Anfangsrichtung



        // Aufrufen von Methoden
        rotesAuto.beschleunigen(20);

        System.out.println(rotesAuto.farbe);
    }
}
