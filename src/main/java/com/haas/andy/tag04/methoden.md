# Methoden in Java - eine vollständige Anleitung

## 📝 Inhaltsverzeichnis
1. [Was ist eine Methode?](#was-ist-eine-methode)
2. [Methodensignatur](#methodensignatur)
3. [Methodendeklaration](#methodendeklaration)
4. [Zugriffsmodifikatoren](#zugriffsmodifikatoren)
5. [Rückgabetypen](#rückgabetypen)
6. [Parameter](#parameter)
7. [Methodenüberladung](#methodenüberladung)
8. [Beispiele](#beispiele)
9. [Zusammenfassung](#zusammenfassung)

---

## Was ist eine Methode?

Eine Methode ist ein **wiederverwendbarer Codeblock**, der nur ausgeführt wird, wenn er aufgerufen wird. Methoden helfen dabei, Code zu organisieren, Redundanz zu vermeiden und die Lesbarkeit zu verbessern.

---

## Methodensignatur

Die **Methodensignatur** ist die eindeutige Identifikation einer Methode. Sie besteht aus:

✅ **Methodenname**  
✅ **Parametertypen** (in der richtigen Reihenfolge)

❌ **Nicht** enthalten: Zugriffsmodifikator, Rückgabetyp, Parameternamen

### Beispiele für Methodensignaturen:

```java
// Signatur: berechneSumme(int, int)
public int berechneSumme(int a, int b){}

// Signatur: printMessage(String)
void printMessage(String text){}

// Signatur: getValue()
private double getValue(){}

// Erlaubt - unterschiedliche Signaturen
void print(int zahl){}

void print(String text){}

void print(int zahl, String text){}

// Nicht erlaubt - gleiche Signatur
// int print(int zahl)
// void print(int wert)  // ❌ Gleiche Signatur wie oben!
```
---
## Methodendeklaration
### Die vollständige Methodendeklaration besteht aus mehreren Teilen:

```Java
[Zugriffsmodifikator] [Rückgabetyp] [Methodenname]([Parameterliste]) {
    // Methodenkörper
    return [Wert]; // falls Rückgabetyp nicht void
}

public static int addiere(int a, int b) {
    return a + b;
}

Bestandteil	        Beispiel	Beschreibung
Zugriffsmodifikator	public	        Legt Sichtbarkeit fest
optionale               Modifikatoren	static	Weitere Eigenschaften
Rückgabetyp	        int	        Typ des Rückgabewerts
Methodenname	        addiere	        Name der Methode
Parameterliste	        (int a, int b)	Eingabewerte
Methodenkörper	        { ... }	        Auszuführender Code
```
---
## Zugriffsmodifikatoren
```Java
Modifikator	        Sichtbarkeit
public	                Überall
protected	        Innerhalb des Pakets + Unterklassen
(kein Modifikator)	Nur innerhalb des Pakets (package-private)
private	                Nur innerhalb derselben Klasse

public class Beispiel {
    public void oeffentlicheMethode() { }       // Überall sichtbar
    protected void geschuetzteMethode() { }     // Paket + Unterklassen
    void paketMethode() { }                     // Nur im selben Paket
    private void privateMethode() { }           // Nur in dieser Klasse
}
```
---
## Rückgabetypen

### primitive Datentypen:
```Java
int gibZahl() { 
    return 5; 
}

double gibKommazahl() { 
    return 3.14; 
}

boolean istWahr() { 
    return true; 
}

char gibBuchstabe() { 
    return 'A'; 
}
```
### Objekt-Typen:
```Java
String gibText() { 
    return "Hallo"; 
}

int[] gibArray() { 
    return new int[] {1, 2, 3}; 
}

Person gibPerson() { 
    return new Person("Max"); 
}
```
### void - kein Rückgabewert:
```Java
void druckeNachricht() {
    System.out.println("Keine Rückgabe");
    // kein 'return' notwendig
}
```
### Rückgabe mit return:
```Java
public int max(int a, int b) {
    if (a > b) {
        return a;  // Methode endet hier
    }
    
    return b;
}
```
---
## Parameter
### Arten von Parametern:
#### Pflichtparameter - müssen immer übergeben werden:
```Java
public void grueße(String name) {
    System.out.println("Hallo " + name);
}
// Aufruf: grueße("Anna");  ✅
// Aufruf: grueße();        ❌ Fehler

Optionale Parameter (mit Überladung):
public void grueße() {
    grueße("Gast");
}

public void grueße(String name) {
    System.out.println("Hallo " + name);
}
```
### Varargs (variable Anzahl):
```Java
public void summiere(int... zahlen) {
    int summe = 0;
    for (int zahl : zahlen) {
        summe += zahl;
    }
    System.out.println("Summe: " + summe);
}

// Aufruf:
summiere(1, 2);        // 2 Parameter
summiere(1, 2, 3, 4);  // 4 Parameter
summiere();            // 0 Parameter
```
### Parameterübergabe:
#### Call by Value - Java übergibt immer Kopien der Werte:
```Java
public void aendereWert(int x) {
    x = 10;  // Ändert nur die Kopie
}

public void aendereArray(int[] arr) {
    arr[0] = 10;  // Ändert das Original-Objekt!
}

// Hauptprogramm:
int zahl = 5;
aendereWert(zahl);
System.out.println(zahl);  // Immer noch 5!

int[] array = {1, 2, 3};
aendereArray(array);
System.out.println(array[0]);  // Jetzt 10!
```
---
## Methodenüberladung
### (Overloading)
### Mehrere Methoden mit gleichem Namen aber unterschiedlichen Parametern:
```Java
public class Rechner {
    // Zwei int Parameter
    public int addiere(int a, int b) {
        return a + b;
    }
    
    // Drei int Parameter
    public int addiere(int a, int b, int c) {
        return a + b + c;
    }
    
    // double Parameter
    public double addiere(double a, double b) {
        return a + b;
    }
    
    // Array Parameter
    public int addiere(int[] zahlen) {
        int summe = 0;
        
        for (int zahl : zahlen) {
            summe += zahl;
        }
        
        return summe;
    }
}
```
### Regeln für Überladung:
```Java
✅ Unterschiedliche Anzahl von Parametern
✅ Unterschiedliche Parametertypen
✅ Unterschiedliche Reihenfolge der Parametertypen

❌ Nicht ausreichend: Unterschiedlicher Rückgabetyp allein
❌ Nicht ausreichend: Unterschiedliche Parameternamen
```
## Beispiele
### Methoden in Aktion
### Beispiel 1: Einfache Methoden
```Java
public class MethodenBeispiel {
    
    // Methode ohne Parameter und ohne Rückgabe
    public void zeigeMenu() {
        System.out.println("1. Start");
        System.out.println("2. Stop");
        System.out.println("3. Exit");
    }
    
    // Methode mit Parameter und Rückgabe
    public boolean istGerade(int zahl) {
        return zahl % 2 == 0;
    }
    
    // Methode mit mehreren Parametern
    public double berechneDurchschnitt(double[] werte) {
        if (werte == null || werte.length == 0) {
            return 0;
        }
        
        double summe = 0;
        for (double wert : werte) {
            summe += wert;
        }
        return summe / werte.length;
    }
    
    public static void main(String[] args) {
        MethodenBeispiel mb = new MethodenBeispiel();
        
        mb.zeigeMenu();
        
        System.out.println("Ist 7 gerade? " + mb.istGerade(7));
        System.out.println("Ist 10 gerade? " + mb.istGerade(10));
        
        double[] zahlen = {1.5, 2.5, 3.5, 4.5};
        System.out.println("Durchschnitt: " + mb.berechneDurchschnitt(zahlen));
    }
}
```
### Beispiel 2: Rekursive Methode
```Java
public class Rekursion {
    
    // Berechnet die Fakultät einer Zahl (rekursiv)
    public long fakultaet(int n) {
        if (n <= 1) {
            return 1;  // Abbruchbedingung
        }
        return n * fakultaet(n - 1);  // Rekursiver Aufruf
    }
    
    public static void main(String[] args) {
        Rekursion r = new Rekursion();
        System.out.println("5! = " + r.fakultaet(5));  // 120
    }
}
```
### Beispiel 3: Getter und Setter
```Java
public class Person {
    private String name;  // Private Attribute
    private int alter;
    
    // Getter - lesender Zugriff
    public String getName() {
        return name;
    }
    
    // Setter - schreibender Zugriff (mit Validierung)
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }
    
    public int getAlter() {
        return alter;
    }
    
    public void setAlter(int alter) {
        if (alter >= 0 && alter <= 150) {
            this.alter = alter;
        }
    }
}
```
## Zusammenfassung
### Methodendeklaration auf einen Blick
```Java
[Zugriff] [optional] [Rückgabe] [name]([Parameter]) [throws Exception] {
    // Methodenkörper
}
```
```Java
public static final synchronized int berechne(int x) throws IOException {
    return x * 2;
}
```
### Häufige Fehler vermeiden:
```Java
Fehler	                                Richtig
void methode() { return 5; }	        Rückgabetyp und return müssen übereinstimmen
int methode() {}	                Fehlendes return Statement
methode(int a, int a)	                Doppelte Parameternamen
Zwei Methoden mit gleicher Signatur	Führt zu Compiler-Fehler
```
🔑 Merkpunkte
```Java
Signatur = Methodenname + Parametertypen

Deklaration = Zugriff + Rückgabetyp + Signatur + Methodenkörper;

Methoden können überladen werden (gleicher Name, unterschiedliche Parameter);

return beendet die Methode sofort;

void Methoden geben nichts zurück;

Parameter werden als Kopie übergeben (Call by Value);

Methoden machen Code modular, testbar und wiederverwendbar.
```