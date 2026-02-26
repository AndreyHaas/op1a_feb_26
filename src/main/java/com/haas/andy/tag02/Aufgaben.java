package com.haas.andy.tag02;

public class Aufgaben {
    static void main() {
        /* Übung 1: Länge und Groß-/Kleinschreibung
           1. Deklariere einen String `sentence` mit dem Wert "Programmieren macht Spaß!".
           2. Gib die Länge des Strings `sentence` aus.
           3. Konvertiere `sentence` in Großbuchstaben und gib das Ergebnis aus.
           4. Konvertiere `sentence` in Kleinbuchstaben und gib das Ergebnis aus.
        */
        String sentence = "Programmieren macht Spaß!";
        System.out.println("sentence länge ist " + sentence.length() + " Zeichen.");

        /* Übung 2: Zeichen abrufen und Teilstring extrahieren
           1. Deklariere einen String `text` mit dem Wert "Java ist toll!".
           2. Gib das Zeichen an der Position 5 von `text` aus.
           3. Extrahiere den Teilstring von Index 5 bis 8 und gib ihn aus.
        */
        String text = "Java ist toll!";
        System.out.println(text.charAt(5));
        System.out.println(text.substring(5, 8));

        /* Übung 3: Vergleich von Strings
           1. Deklariere zwei Strings `word1` und `word2` mit den Werten "Apfel" und "Apfel".
           2. Vergleiche `word1` und `word2` mit `equals()` und gib das Ergebnis aus.
           3. Erstelle einen neuen String `word3` mit dem Wert "apfel" und vergleiche ihn mit `word1` ohne Beachtung der Groß-/Kleinschreibung.
        */
        String word1 = "Apfel";
        String word2 = "Apfel";
        System.out.println(word1.equals(word2));
        String word3 = "apfel";
        System.out.println(word1.equals(word3));

        /* Übung 4: Enthält und Ersetzen
           1. Deklariere einen String `phrase` mit dem Wert "Willkommen in der Java-Welt!".
           2. Überprüfe, ob `phrase` das Wort "Java" enthält und gib das Ergebnis aus.
           3. Ersetze "Java" in `phrase` durch "Python" und gib den neuen String aus.
        */
        String phrase = "Willkommen in der Java-Welt!";
        System.out.println("enthält das Wort 'Java': " + phrase.contains("Java"));
        String ersetztePhrase = phrase.replace("Java", "Python");
        System.out.println(ersetztePhrase);

        /* Übung 5: Überprüfen auf Präfix und Suffix
           1. Deklariere einen String `title` mit dem Wert "Java Programmieren für Anfänger".
           2. Überprüfe, ob `title` mit "Java" beginnt, und gib das Ergebnis aus.
           3. Überprüfe, ob `title` mit "Anfänger" endet, und gib das Ergebnis aus.
        */
        String title = "Java Programmieren für Anfänger";
        System.out.println("Beginnt 'title' mit Java: " + title.startsWith("Java"));
        System.out.println("Endet 'title' mit Anfänger: " + title.endsWith("Anfänger"));

        /* Übung 6: Leerzeichen entfernen und Wiederholung
           1. Deklariere einen String `messyString` mit dem Wert "   Hallo, Java!   ".
           2. Entferne die führenden und nachfolgenden Leerzeichen mit `trim()` und gib das Ergebnis aus.
           3. Erstelle eine Wiederholung von "Java " und gib den String dreimal hintereinander aus.
        */

        String messyString = "   Hallo, Java!   ";
        System.out.println(messyString.trim());
        System.out.println("Java ".repeat(3).trim());

        /* Übung 7: Formatierte Ausgabe und lexikographischer Vergleich
           1. Deklariere einen String `userName` mit dem Wert "Max".
           2. Erstelle eine formatierte Ausgabe, die sagt: "Hallo Max, Sie haben 3 neue Nachrichten."
           3. Deklariere zwei Strings `fruit1` und `fruit2` mit den Werten "Apfel" und "Banane".
           4. Führe einen lexikographischen Vergleich der beiden Strings durch und gib das Ergebnis aus.
        */
        String userName = "Max";
        int nachrichtenZahl = 3;
        System.out.println("Hallo " + userName + ", Sie haben " + nachrichtenZahl + " neue Nachrichten.");
        System.out.printf("Hallo %s, Sie haben %d neue Nachrichten.%n", userName, nachrichtenZahl);
        String fruit1 = "Apfel";
        String fruit2 = "Banane";
        int lexVergleich = fruit1.compareTo(fruit2);
        System.out.println("lexikographischen Vergleich: " + lexVergleich);


        /* Übung 8: Enthält nur Leerzeichen oder ist leer?
           1. Deklariere einen String `emptyStr` mit "" und einen weiteren String `whiteSpaceStr` mit "   ".
           2. Überprüfe, ob `emptyStr` leer ist, und gib das Ergebnis aus.
           3. Überprüfe, ob `whiteSpaceStr` nur aus Leerzeichen besteht, und gib das Ergebnis aus.
        */
        String emptyStr = "";
        String whiteSpaceStr = "   ";
        System.out.println("emptyString ist leer: " + emptyStr.isEmpty());
        System.out.println("whiteSpaceStr besteht aus Leerzeichen: " + whiteSpaceStr.isBlank());

        /*
            Aufgabe 1 – Altersprüfung
            Schreibe ein Programm:
            Wenn Alter < 6 → „Kind“
            6–17 → „Jugendlich“
            ≥ 18 → „Erwachsen“
        */
        int age = 10;
        if (age < 6) {
            System.out.println("Kind");
        } else if (age >= 6 && age <= 17) {
            System.out.println("Jugendlich");
        } else if (age >= 18) {
            System.out.println("Erwachsen");
        }

        /*
        Erstelle eine Methode:
        public static String berechneNote(int punkte)
        90–100 → A
        80–89 → B
        70–79 → C
        <70 → F
     */
        String note = berechneNote(72);
        System.out.println("note: " + note);
        /*
            Was gibt folgender Code aus?
                for(int i = 1; i <= 3; i++) {
                    for(int j = 1; j <= 2; j++) {
                        System.out.print(i + "" + j + " ");
                }
            }
         */
        // antwort: 11 12 21 22 31 32

        /*
            Gib alle Zahlen von 1–50 aus:
            Gerade Zahlen mit „gerade“
            Ungerade mit „ungerade“
            Nutze continue.
         */
        for (int i = 1; i <= 50; i++) {
            if (i % 2 != 0) {
                System.out.println(i + " ungerade");
                continue;
            }

            System.out.println(i + " gerade");
        }

        /*
            Schreibe ein Programm, das Zahlen von 1–100 ausgibt.
            Beende die Schleife, wenn eine Zahl durch 17 teilbar ist
         */
        for (int i = 1; i <= 100; i++) {
            if (i % 17 == 0) {
                break;
            }

            System.out.println(i);
        }
    }

    public static String berechneNote(int punkte) {
        if (punkte >= 90 && punkte <= 100) {
            return "A";
        } else if (punkte >= 80 && punkte <= 89) {
            return "B";
        } else if (punkte >= 70 && punkte <= 79) {
            return "C";
        } else if (punkte < 70) {
            return "F";
        }

        return "nicht berechnet";
    }
}