# Vererbung in Java – einfach erklärt!
## Inhaltsverzeichnis
## 1. Was ist Vererbung?
## 2. Die Grundidee – ein Beispiel
## 3. Schlüsselwörter: extends und super
## 4. Methoden überschreiben (@Override)
## 5. Konstruktoren in der Vererbung
## 6. protected – die goldene Mitte
## 7. final – hier endet die Vererbung
## 8. Abstrakte Klassen
## 9. Object – die Mutter aller Klassen
## 10. Vererbung vs. Schnittstellen (Interfaces)

## FAQ – Häufige Fragen

### 1. Was ist Vererbung?
#### Vererbung (inheritance) ist eines der wichtigsten Konzepte der objektorientierten Programmierung (OOP).
#### Stell dir vor: Du hast eine allgemeine Klasse mit bestimmten Eigenschaften und Methoden. Eine neue Klasse kann diese Eigenschaften und Methoden erben – also automatisch übernehmen – und dann erweitern oder anpassen.

## Warum macht man das?
```Java
✅ Code-Wiederverwendung – schreibe nichts doppelt!
✅ Struktur – zeige, welche Klassen zusammengehören
✅ Erweiterbarkeit – füge neue Funktionen hinzu, ohne Altes zu ändern
```
### 2. Die Grundidee – ein Beispiel
#### Stell dir vor, wir programmieren ein Spiel. Es gibt verschiedene Fahrzeuge: Auto, Motorrad, LKW. Alle haben Gemeinsamkeiten:

* Alle haben einen Hersteller
* Alle haben eine Höchstgeschwindigkeit
* Alle können fahren

### 👉 Statt in jeder Klasse dieselben Attribute und Methoden zu schreiben, machen wir eine allgemeine Klasse Fahrzeug – und lassen Auto, Motorrad und LKW davon erben.

### 📦 Die Basisklasse (Elternklasse, Superklasse)
```java
public class Fahrzeug {
// Attribute
protected String hersteller;
protected int maxGeschwindigkeit;

    // Konstruktor
    public Fahrzeug(String hersteller, int maxGeschwindigkeit) {
        this.hersteller = hersteller;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
    }
    
    // Methode
    public void fahren() {
        System.out.println("Das Fahrzeug fährt...");
    }
}
```
### 🚗 Die Kindklasse (Subklasse)
```java
public class Auto extends Fahrzeug {  // ← extends = erbt von Fahrzeug
private int anzahlTueren;

    public Auto(String hersteller, int maxGeschwindigkeit, int anzahlTueren) {
        super(hersteller, maxGeschwindigkeit);  // ← ruft Konstruktor der Elternklasse auf
        this.anzahlTueren = anzahlTueren;
    }
    
    public void hupe() {
        System.out.println("Hup hup!");
    }
}
```
### ✅ Jetzt können wir alles nutzen:
```java
public class Main {
public static void main(String[] args) {
Auto meinAuto = new Auto("VW", 180, 4);

        // Geerbt von Fahrzeug:
        meinAuto.fahren();           // Ausgabe: Das Fahrzeug fährt...
        System.out.println(meinAuto.hersteller); // VW
        
        // Eigene Methode:
        meinAuto.hupe();             // Ausgabe: Hup hup!
    }
}
```
#### Check: Auto hat automatisch alle Attribute und Methoden von Fahrzeug! 🎉

### 3. Schlüsselwörter: extends und super
#### 🔑 extends
#### Mit extends sagst du: "Diese Klasse ist ein Fahrzeug" (oder was auch immer).

```java
public class Motorrad extends Fahrzeug {
// ...
}
```
#### 🔑 super
Mit super greifst du auf die Elternklasse zu:

super(...) – ruft den Konstruktor der Elternklasse auf

super.methode() – ruft eine Methode der Elternklasse auf

```java
public Motorrad(String hersteller, int maxGeschwindigkeit) {
    super(hersteller, maxGeschwindigkeit);  // MUSS in der ersten Zeile stehen!
}
```
### 4. Methoden überschreiben (@Override)
### Manchmal will die Kindklasse eine geerbte Methode anders machen. Das nennt man überschreiben (override).

```java
public class Fahrzeug {
    public void fahren() {
        System.out.println("Das Fahrzeug fährt...");
    }
}

public class Auto extends Fahrzeug {
    @Override  // ← sagt: Ich überschreibe bewusst!
    public void fahren() {
        System.out.println("Das Auto fährt mit 4 Rädern...");
    }
}

public class Motorrad extends Fahrzeug {
    @Override
    public void fahren() {
        System.out.println("Das Motorrad fährt auf 2 Rädern...");
    }
}
```
### Verwendung:

```java
Fahrzeug f1 = new Fahrzeug();
Fahrzeug f2 = new Auto();
Fahrzeug f3 = new Motorrad();

f1.fahren();  // Das Fahrzeug fährt...
f2.fahren();  // Das Auto fährt mit 4 Rädern...
f3.fahren();  // Das Motorrad fährt auf 2 Rädern...
```
👉 Obwohl alle Fahrzeug-Variablen sind, wird die richtige Methode aufgerufen! Das ist Polymorphie.

### 5. Konstruktoren in der Vererbung
#### Wichtig: Der Konstruktor der Elternklasse wird nicht automatisch vererbt. Die Kindklasse muss ihn aufrufen – mit super(...).

### Regel:
#### Wenn die Elternklasse keinen eigenen Konstruktor hat (nur Standardkonstruktor), macht Java das automatisch.

#### Wenn die Elternklasse einen eigenen Konstruktor hat, muss die Kindklasse super(...) aufrufen.

```java
public class Fahrzeug {
    public Fahrzeug(String hersteller) {  // ← eigener Konstruktor
        this.hersteller = hersteller;
    }
}

public class Auto extends Fahrzeug {
    public Auto(String hersteller) {
        super(hersteller);  // ← MUSS! Sonst Compiler-Fehler
    }
}
```
### 6. protected – die goldene Mitte
#### In Java gibt es Zugriffsmodifikatoren:
```java
Modifikator     Zugriff in      Zugriff im       Zugriff in   Zugriff
                eigener Klasse	gleichen Paket	 Kindklasse   überall
private	        ✅	        ❌	         ❌          ❌
(keiner)	✅	        ✅	         ❌          ❌
protected	✅	        ✅	         ✅          ❌
public	        ✅	        ✅	         ✅          ✅
```
### protected ist perfekt für Vererbung:

#### In der Kindklasse kannst du darauf zugreifen (auch wenn sie in einem anderen Paket ist)

### Außerhalb nicht

```java
public class Fahrzeug {
    protected int maxGeschwindigkeit;  // ← Nur Familie und gleiches Paket
}
```
### 7. final – hier endet die Vererbung
#### final bei Klassen: Keine Vererbung erlaubt
```java
public final class EndClass {
   // Diese Klasse kann NIEMAND erweitern!
}
```
   final bei Methoden: Überschreiben verboten
```java
public class Fahrzeug {
   public final void starten() {
    // Kindklassen DÜRFEN diese Methode NICHT überschreiben
   }
}
```
### 8. Abstrakte Klassen
#### Manchmal will man eine Klasse, von der niemand ein Objekt machen kann – sie dient nur als Bauplan.

```java
public abstract class Tier {  // ← abstrakt = keine Objekte erlaubt!
    protected String name;

    public Tier(String name) {
        this.name = name;
    }
    
    public abstract void geraeuschMachen();  // ← abstrakt = muss in Kindklasse implementiert werden!
}

public class Hund extends Tier {
    public Hund(String name) {
        super(name);
    }

    @Override
    public void geraeuschMachen() {  // ← MUSS implementiert werden!
        System.out.println(name + " bellt: Wuff!");
    }
}
```
### Verwendung:
```java
// Tier t = new Tier("Balu");  // ❌ Geht nicht! (abstrakt)
Hund h = new Hund("Balu");     // ✅
h.geraeuschMachen();           // Balu bellt: Wuff!
```
### 9. Object – die Mutter aller Klassen
#### In Java hat jede Klasse eine Elternklasse – auch wenn du nichts hinschreibst! Diese Elternklasse heißt Object.
```java
public class MeinKlasse {  // ← extends Object (automatisch!)
    // ...
}
```
### Object bringt wichtige Methoden mit:
### * toString() – String-Repräsentation des Objekts
### * equals() – Vergleich mit anderem Objekt
### * hashCode() – Hashwert für Collections
### getClass() – Klasse des Objekts

```java
Auto a = new Auto();
System.out.println(a.toString());  // ← kommt von Object!
```
### 10. Vererbung vs. Schnittstellen (Interfaces)
```Java
Vererbung (extends)	        Interface (implements)
Eine Klasse erweitern	        Mehrere Interfaces implementieren
"ist ein" (is-a)	        "kann" (can-do)
Kann Attribute haben	        Nur abstrakte Methoden (vor Java 8)
Kann Implementierungen haben	Nur Methodensignaturen (vor Java 8)
```
```java
// Vererbung: Auto IST EIN Fahrzeug
public class Auto extends Fahrzeug { ... }

// Interface: Auto KANN schwimmen (Amphibienfahrzeug)
public class Auto implements Schwimmfaehig { ... }
```
### Mehrfachvererbung von Klassen gibt es in Java nicht! Aber mehrere Interfaces sind erlaubt:

```java
public class Auto extends Fahrzeug implements Schwimmfaehig, Fliegfaehig { ... }
```
### 11. FAQ – Häufige Fragen
### ❓ Kann eine Klasse von mehreren Klassen erben?
#### Nein! Java hat keine Mehrfachvererbung für Klassen. Aber: Mehrere Interfaces sind erlaubt.

### ❓ Was ist der Unterschied zwischen Überschreiben und Überladen?
#### Überschreiben (override): Kindklasse macht geerbte Methode neu (gleicher Name, gleiche Parameter)

#### Überladen (overload): Mehrere Methoden mit gleichem Namen, aber verschiedenen Parametern

### ❓ Wann nimmt man Vererbung, wann Interfaces?
#### Vererbung: Wenn eine echte "ist ein"-Beziehung besteht
#### Interface: Wenn verschiedene Klassen eine Fähigkeit teilen

### 🎯 Zusammenfassung – das Wichtigste in Kürze
```Java
Konzept	                    Code	                    Bedeutung
Vererbung                   class Kind extends Eltern       Kind erbt von Eltern
Konstruktor aufrufen        super(...)	                    Ruft Eltern-Konstruktor auf
Überschreiben	            @Override	                    Methode neu machen
Abstrakte Klasse            abstract class	            Keine Objekte, nur Bauplan
Abstrakte Methode           abstract void methode();        Muss in Kindklasse implementiert werden
Finale Klasse	            final class	                    Kann nicht vererbt werden
Alle Klassen erben von	    Object	                    Die Mutter aller Klassen
```

### 💡 Merksätze
#### "extends" – die Klasse ist eine erweiterte Version der Elternklasse
#### "super" – der Eltern-Anruf (wie "Superman" – der Vater)
#### "@Override" – ich mach's anders als mein Vater
#### "abstract" – nur ein Bauplan, keine echten Objekte
#### "final" – Schluss, hier erbt keiner mehr!

## Vererbung ist wie ein Stammbaum: Kinder erben von Eltern, können aber eigene Sachen dazulernen! 🧬