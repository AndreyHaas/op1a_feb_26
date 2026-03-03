package com.haas.andy.tag05;

import java.util.*;

public class CollectionBeispiele {
    static void main(String[] args) {

        // ===============================
        // 1. LISTEN (ArrayList)
        // ===============================
        System.out.println("ArrayList");
        // Erstellen einer ArrayList und Hinzufügen von Elementen
        ArrayList<String> autoListe = new ArrayList<>();
        autoListe.add("BMW");
        autoListe.add("Audi");


        autoListe.add(1,"Ford");

        // Ausgabe der Liste
        System.out.println("Inhalt der ArrayList: " + autoListe);// Inhalt der ArrayList: [BMW, Ford, Audi]

        // Zugriff auf das erste Element
        System.out.println("Zweite Element: " + autoListe.get(1)); // BMW
        // alternative zum zugriff auf den ersten Element
        System.out.println("Erste Element: " + autoListe.getFirst()); // BMW
        System.out.println("letzte Element: " + autoListe.getLast());//Audi

        // Größe der Liste
        System.out.println("Größe der Liste: " + autoListe.size()); // 3

        // Entfernen eines elements
        autoListe.remove("Audi");
        autoListe.remove(1);

        System.out.println("Inhalt der ArrayList nach Entfernen von audi: " + autoListe);

    }
}
