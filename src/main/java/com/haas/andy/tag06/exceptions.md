Exceptions in Java - Das vollständige Handbuch 🚨
## Inhaltsverzeichnis
1. [Was sind Exceptions?](#Was-sind-exceptions)
2. [Exception-Hierarchie](#exception-hierarchie)
3. [Checked vs. Unchecked Exceptions](#checked-vs-unchecked-exceptions)
4. [Exceptions behandeln - try-catch](#exceptions-behandeln---try-catch)
5. [finally-Block](#finally-block)
6. [Exceptions auslösen - throw](#exceptions-auslösen---throw)
7. [Exceptions deklarieren - throws](#exceptions-deklarieren---throws)
8. [Eigene Exceptions schreiben](#eigene-exceptions-schreiben)
9. [try-with-resources](#try-with-resources-ab-java-7)
10. [Best Practices](#best-practices)
11. [Häufige Exceptions](#häufige-exceptions)
12. [Zusammenfassung](#zusammenfassung-)



## Was sind Exceptions?
### Exceptions (Ausnahmen) sind unerwartete Ereignisse, die während der Programmausführung auftreten und den normalen Programmfluss unterbrechen.

```java
public class Beispiel {
public static void main(String[] args) {
int zahl = 10 / 0;  // 🚨 ArithmeticException!
System.out.println("Das wird nie erreicht");
    }
}
Ausgabe:
Exception in thread "main" java.lang.ArithmeticException: / by zero
```
## Exception-Hierarchie
```java
   java.lang.Object
   └── java.lang.Throwable
   ├── java.lang.Error (Systemfehler, nicht behandeln)
   │       ├── OutOfMemoryError
   │       ├── StackOverflowError
   │       └── ...
   └── java.lang.Exception (behandelbare Ausnahmen)
   ├── java.lang.RuntimeException (unchecked)
   │       ├── NullPointerException
   │       ├── ArithmeticException
   │       ├── IndexOutOfBoundsException
   │       └── ...
   └── checked Exceptions
   ├── IOException
   ├── SQLException
   └── ...
   2.1 Throwable
   Das Mutter aller Exceptions und Errors.
```
### 2.2 Error
Schwere Systemfehler, die von der Anwendung nicht behandelt werden sollten.

```java
// 💀 Davon sollte man sich nicht erholen wollen
OutOfMemoryError
StackOverflowError
```
### 2.3 Exception
Behandelbare Ausnahmen - darum kümmern wir uns!

## Checked vs. Unchecked Exceptions
### 3.1 Checked Exceptions (Geprüfte Ausnahmen)
#### Müssen behandelt oder deklariert werden

#### Compiler zwingt uns dazu!

#### Sinnvoll für vorhersehbare Fehler

```java
// Datei lesen - muss behandelt werden!
public void dateiLesen() {
// ❌ Compiler-Fehler!
FileReader reader = new FileReader("datei.txt");
}

// ✅ Richtig: try-catch oder throws
public void dateiLesen() {
try {
    FileReader reader = new FileReader("datei.txt");
} catch (FileNotFoundException e) {
    System.out.println("Datei nicht gefunden!");
}
}
```
#### Unchecked Exceptions (Ungeprüfte Ausnahmen)
#### Müssen nicht behandelt werden
#### Meist Programmierfehler

Erben von RuntimeException

```java
// NullPointer - unchecked, muss nicht behandelt werden
public void getLaenge(String text) {
// ❌ Kann knallen, aber Compiler zwingt nicht zur Behandlung
int laenge = text.length();  // NullPointer möglich!
}

// ✅ Aber behandeln kann man trotzdem
public void getLaenge(String text) {
if (text != null) {
int laenge = text.length();
} else {
System.out.println("Text ist null!");
}
}
```
### 3.3 Vergleichstabelle
```java
Aspekt	                    Checked Exceptions	                    Unchecked Exceptions
Behandlungspflicht	    ✅ Ja (Compiler erzwingt)	            ❌ Nein (optional)
Basisklasse	            Exception (außer RuntimeException)      RuntimeException
Beispiele	            IOException, SQLException	            NullPointerException, 
                                                                    ArithmeticException
Ursache	                Äußere Umstände (Datei weg, 
                        Netzwerk aus)	                            Programmierfehler
```
## Exceptions behandeln - try-catch
   ### 4.1 Einfaches try-catch
   ```java
   try {
   // Code, der eine Exception werfen KÖNNTE
   int ergebnis = 10 / 0;
   System.out.println("Das wird nie ausgeführt");
   } catch (ArithmeticException e) {
   // Was passiert, wenn DIE BESTIMMTE Exception fliegt
   System.out.println("Fehler: Division durch Null!");
   e.printStackTrace();  // Stacktrace ausgeben (für Debugging)
   }
   ```
   ### 4.2 Mehrere catch-Blöcke
```java
try {
    int[] zahlen = new int[5];
    zahlen[10] = 10 / 0;  // Zwei Fehler möglich!
} catch (ArithmeticException e) {
    System.out.println("Mathe-Fehler: " + e.getMessage());
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array-Fehler: " + e.getMessage());
} catch (Exception e) {  // Fängt ALLE anderen Exceptions
    System.out.println("Irgendein anderer Fehler");
}
```
### 4.3 Multi-catch (ab Java 7)
```java
try {
// gefährlicher Code
} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
// Gleiche Behandlung für beide Exception-Typen
System.out.println("Mathe- oder Array-Fehler: " + e.getMessage());
}
```
### 4.4 Exception-Objekt auswerten
```java
try {
FileReader reader = new FileReader("datei.txt");
} catch (FileNotFoundException e) {
// Wichtige Methoden des Exception-Objekts
System.out.println(e.getMessage());      // Fehlermeldung
System.out.println(e.toString());         // Typ + Meldung
e.printStackTrace();                       // Ganzen Stacktrace
System.out.println(e.getCause());         // Ursache (falls vorhanden)
}
```
## finally-Block
#### Der finally-Block wird immer ausgeführt (außer JVM crasht).

```java
FileReader reader = null;
try {
    reader = new FileReader("datei.txt");
// Datei lesen...
} catch (IOException e) {
    System.out.println("Fehler beim Lesen");
} finally {
// Wird IMMER ausgeführt (mit oder ohne Exception)
if (reader != null) {
try {
    reader.close();  // Ressourcen freigeben
} catch (IOException e) {
    System.out.println("Fehler beim Schließen");
}
}
    System.out.println("Aufräumen abgeschlossen");
}
```
Ablauf:

#### Ohne Exception: try → finally
#### Mit Exception: try (bis Fehler) → catch → finally

## Exceptions auslösen - throw
   Mit throw können wir selbst Exceptions werfen.

### 6.1 Einfaches throw
```java
public void checkAlter(int alter) {
if (alter < 0) {
    throw new IllegalArgumentException("Alter darf nicht negativ sein!");
}

if (alter < 18) {
    throw new ArithmeticException("Zu jung für diese Aktion!");
}
    System.out.println("Zugang gewährt");
}
```
```java
// Verwendung
checkAlter(-5);  // 💥 IllegalArgumentException
```
### 6.2 throw mit eigenem Text
```java
throw new NullPointerException("Die Variable 'name' ist null - das darf nicht passieren!");
```
## Exceptions deklarieren - throws
### Mit throws sagen wir: "Diese Methode kann eine Exception werfen, der Aufrufer muss sich kümmern."

#### 7.1 checked Exception deklarieren
```java
// throws sagt: Aufpassen! Diese Methode kann knallen!
public void dateiLesen() throws FileNotFoundException {
FileReader reader = new FileReader("datei.txt");
// ... Code
}

// Der Aufrufer MUSS jetzt behandeln
public void aufrufer() {
try {
    dateiLesen();
} catch (FileNotFoundException e) {
        System.out.println("Datei nicht da!");
    }
}
```
#### 7.2 Mehrere Exceptions deklarieren
```java
public void gefaehrlicheMethode() throws IOException, SQLException {
// Code, der beide Exceptions werfen kann
}
```
#### 7.3 Unchecked Exceptions deklarieren (optional)
```java
public void test(String text) throws NullPointerException {
// throws ist optional, da unchecked
    System.out.println(text.length());
}
```
## Eigene Exceptions schreiben
### 8.1 Eigene checked Exception
```java
// Eigene Exception (checked)
public class ZuWenigGeldException extends Exception {

// Konstruktoren
public ZuWenigGeldException() {
    super();  // Standardkonstruktor
}

public ZuWenigGeldException(String message) {
   super(message);  // Mit Fehlermeldung
}

public ZuWenigGeldException(String message, Throwable cause) {
    super(message, cause);  // Mit Meldung und Ursache
    }
}
```
### 8.2 Eigene unchecked Exception
```java
// Eigene unchecked Exception
public class UngueltigerWertException extends RuntimeException {

public UngueltigerWertException(String message) {
    super(message);
}
}
```
### 8.3 Verwendung eigener Exceptions
```java
public class Konto {

private double kontostand;

public void abheben(double betrag) throws ZuWenigGeldException {
   if (betrag <= 0) {
    throw new UngueltigerWertException("Betrag muss positiv sein!");
   }
   if (betrag > kontostand) {
    throw new ZuWenigGeldException("Nicht genug Geld! Maximal: " + kontostand);
   }
    kontostand -= betrag;
   }
}

// Verwendung
Konto k = new Konto();
try {
k.abheben(1000);
} catch (ZuWenigGeldException e) {
System.out.println("Fehler: " + e.getMessage());
}
```
## try-with-resources (ab Java 7)
### Automatisches Schließen von Ressourcen (alles, was AutoCloseable implementiert).

#### 9.1 Vor try-with-resources (alt)
```java
BufferedReader reader = null;
try {
reader = new BufferedReader(new FileReader("datei.txt"));
String line = reader.readLine();
} catch (IOException e) {
e.printStackTrace();
} finally {
if (reader != null) {
try {
reader.close();  // Manuelles Schließen
} catch (IOException e) {
e.printStackTrace();
}
}
}
```
#### 9.2 Mit try-with-resources (modern)
```java
// Ressourcen werden AUTOMATISCH geschlossen!
try (BufferedReader reader = new BufferedReader(new FileReader("datei.txt"))) {
String line = reader.readLine();
System.out.println(line);
} catch (IOException e) {
e.printStackTrace();
}  // Kein finally nötig! reader.close() wird automatisch aufgerufen
```
#### 9.3 Mehrere Ressourcen
```java
try (BufferedReader reader = new BufferedReader(new FileReader("eingabe.txt"));
BufferedWriter writer = new BufferedWriter(new FileWriter("ausgabe.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        writer.write(line);
        writer.newLine();
    }
} catch (IOException e) {
    e.printStackTrace();
}
```
## Best Practices
```java
    ✅ DO's
    // 1. Spezifisch fangen, nicht einfach "Exception"
    try {
        // Code
    } catch (FileNotFoundException e) {  // ✅ Spezifisch
        // Behandlung
    } catch (IOException e) {            // ✅ Auch OK
        // Behandlung
    }
// 2. Sinnvolle Fehlermeldungen
throw new IllegalArgumentException("Alter muss zwischen 0 und 150 liegen");  // ✅

// 3. Exceptions loggen (nicht nur printStackTrace)
catch (IOException e) {
logger.error("Fehler beim Lesen der Datei: " + filename, e);  // ✅
}

// 4. finally für Aufräumarbeiten nutzen (oder try-with-resources)
finally {
if (connection != null) {
connection.close();  // ✅
}
}

// 5. Early Exit - Fehler früh erkennen
public void setAlter(int alter) {
if (alter < 0 || alter > 150) {
throw new IllegalArgumentException("Ungültiges Alter");  // ✅ Früh prüfen
}
this.alter = alter;
}

❌ DON'Ts
java
// 1. Leere catch-Blöcke (Exceptions verschlucken!)
try {
// Code
} catch (Exception e) {
// ❌ Nichts tun - FEHLER!
}

// 2. Zu allgemein fangen
try {
// Code
} catch (Exception e) {  // ❌ Fängt ALLES - schlecht!
// Behandlung
}

// 3. throws Exception (zu allgemein)
public void doSomething() throws Exception {  // ❌ Sagt nichts aus!
// Code
}

// 4. Exception werfen, wo nicht nötig
public int add(int a, int b) throws Exception {  // ❌ Unnötig!
return a + b;
}

// 5. System.exit() im catch
catch (Exception e) {
System.exit(1);  // ❌ Zu drastisch!
}
```
## Häufige Exceptions
```java
    Exception	                    Wann?	                                        Beispiel
    NullPointerException	        Aufruf auf null-Referenz	                String s = null; s.length();
    ArithmeticException     	    Division durch Null	                                int x = 10 / 0;
    ArrayIndexOutOfBoundsException	Ungültiger Array-Index	                        int[] a = new int[5]; a[10] = 1;
    NumberFormatException	        String kann nicht in Zahl konvertiert werden	Integer.parseInt("abc");
    IllegalArgumentException	    Ungültiges Methodenargument	                        selbst geworfen
    FileNotFoundException	        Datei existiert nicht	                        new FileReader("nichtda.txt");
    IOException	                    Allgemeiner Ein-/Ausgabefehler	                Lesen/Schreiben fehlgeschlagen
    ClassCastException	            Ungültiger Cast	                                Object o = "String"; 
                                                                                        Integer i = (Integer) o;
```
## Zusammenfassung 📝
```java
Konzept	                        Syntax	                                    Beschreibung
try-catch	                try { ... } catch (Exception e) { ... }	    Exception fangen und behandeln
finally	                        finally { ... }	                            Wird immer ausgeführt
throw	                        throw new Exception("...");	                Exception selbst werfen
throws	                        void meth() throws Exception	            Exception deklarieren
try-with-resources	        try (Resource r = new Resource())	        Auto-Closing
eigene Exception	        class MyEx extends Exception	            Eigene Exception-Klasse
```
### Merksätze 🧠
#### 1. "Checked oder unchecked?" - Wenn's von außen kommt → checked, wenn's mein Fehler ist → unchecked

#### 2. "Catch oder throws?" - Wenn ich es behandeln kann → catch, wenn der Aufrufer entscheiden soll → throws

#### 3. "Nie leere catch-Blöcke!" - Schluckte Fehler sind die schlimmsten Fehler

#### 4. "try-with-resources ist dein Freund" - Spart Code und verhindert vergessene close()

## Exceptions sind deine Freunde - sie helfen dir, Fehler zu erkennen und zu behandeln! 🚀