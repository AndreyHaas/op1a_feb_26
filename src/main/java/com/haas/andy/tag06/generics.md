Generics in Java - Das vollständige Handbuch 📚
Inhaltsverzeichnis
Was sind Generics?

1. [Was sind Generics?](#Was-sind-Generics)
2. [Warum Generics?](#warum-generics)
3. [Generische Klassen](#generische-klassen)
4. [Generische Methoden](#generische-methoden)
5. [Generische Interfaces](#generische-interfaces)
6. [Wildcards](#wildcards-)
7. [Type Bounds (Einschränkungen)](#type-bounds-einschränkungen)
8. [Type Inference (Typinferenz)](#type-inference-typinferenz)
9. [Raw Types (Roh-Typen)](#raw-types-roh-typen)
10. [Best Practices](#best-practices)
11. [Zusammenfassung](#zusammenfassung-)

## Was sind Generics?
   Generics (Generika) sind ein Feature in Java, das es ermöglicht, Klassen, Interfaces und Methoden mit Typparametern zu definieren. Sie wurden mit Java 5 eingeführt und ermöglichen Typsicherheit zur Compile-Zeit. 
``` java
// Ohne Generics (vor Java 5)
List liste = new ArrayList();
liste.add("Hallo");
String text = (String) liste.get(0);  // Cast nötig!

// Mit Generics (ab Java 5)
List<String> liste = new ArrayList<>();
liste.add("Hallo");
String text = liste.get(0);  // Kein Cast nötig!
```
## Warum Generics?
### 2.1 Typsicherheit
``` java
List<String> strings = new ArrayList<>();
strings.add("Hallo");
// strings.add(123);  // Compiler-Fehler! Passt nicht
```
### 2.2 Kein Casting
``` java
// Ohne Generics
List list = new ArrayList();
list.add("Hallo");
String s = (String) list.get(0);  // Manueller Cast

// Mit Generics
List<String> list = new ArrayList<>();
list.add("Hallo");
String s = list.get(0);  // Automatisch
```
### 2.3 Wiederverwendbarkeit
``` java
// Eine Klasse für verschiedene Typen
class Box<T> {
    private T inhalt;
    public void setInhalt(T inhalt) { this.inhalt = inhalt; }
    public T getInhalt() { return inhalt; }
}

Box<String> stringBox = new Box<>();
Box<Integer> intBox = new Box<>();
Box<Double> doubleBox = new Box<>();
```
## Generische Klassen
### 3.1 Grundlegende Syntax
``` java
public class Box<T> {
private T inhalt;

    public void setInhalt(T inhalt) {
        this.inhalt = inhalt;
    }
    
    public T getInhalt() {
        return inhalt;
    }
}

// Verwendung
Box<String> stringBox = new Box<>();
stringBox.setInhalt("Buch");
String buch = stringBox.getInhalt();
```
### 3.2 Mehrere Typparameter
``` java
public class Paar<K, V> {
    private K key;
    private V value;
    
    public Paar(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() { return key; }
    public V getValue() { return value; }
}

// Verwendung
Paar<Integer, String> eintrag = new Paar<>(1, "Eins");
```
### 3.3 Konventionen für Typparameter
``` java
Buchstabe	Bedeutung
E	        Element (in Collections)
K	        Key (Schlüssel)
V	        Value (Wert)
N	        Number (Zahl)
T	        Type (beliebiger Typ)
S, U, V	weitere Typen
```
## Generische Methoden
### 4.1 Einfache generische Methode
``` java
public class Utils {
public static <T> T getLetztesElement(T[] array) {
if (array == null || array.length == 0) {
return null;
}
return array[array.length - 1];
}
}

// Verwendung
String[] namen = {"Anna", "Ben", "Clara"};
String letzter = Utils.getLetztesElement(namen);  // "Clara"

Integer[] zahlen = {1, 2, 3, 4};
Integer letzteZahl = Utils.getLetztesElement(zahlen);  // 4
```
### 4.2 Generische Methode mit zwei Parametern
``` java
public static <T, U> boolean vergleichePaare(T item1, U item2) {
return item1.equals(item2);
}

// Verwendung
boolean ergebnis = vergleichePaare("Hallo", "Hallo");  // true
```
## Generische Interfaces
``` java
public interface Container<T> {
void add(T item);
T get(int index);
int size();
}

// Implementierung
public class StringContainer implements Container<String> {
private List<String> items = new ArrayList<>();

    @Override
    public void add(String item) {
        items.add(item);
    }
    
    @Override
    public String get(int index) {
        return items.get(index);
    }
    
    @Override
    public int size() {
        return items.size();
    }
}
```
## Wildcards (?)
### 6.1 Unbounded Wildcard (?)
``` java
public static void printList(List<?> list) {
for (Object elem : list) {
System.out.println(elem);
}
}

// Kann mit jedem List-Typ verwendet werden
List<String> strings = Arrays.asList("a", "b");
List<Integer> ints = Arrays.asList(1, 2, 3);

printList(strings);  // OK
printList(ints);     // OK
```
### 6.2 Upper Bounded Wildcard (? extends Type)
``` java
public static double summe(List<? extends Number> numbers) {
double sum = 0;
for (Number n : numbers) {
sum += n.doubleValue();
}
return sum;
}

// Verwendung
List<Integer> ints = Arrays.asList(1, 2, 3);
List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);

System.out.println(summe(ints));     // 6.0
System.out.println(summe(doubles));  // 7.5
```
### 6.3 Lower Bounded Wildcard (? super Type)
``` java
public static void addNumbers(List<? super Integer> list) {
    for (int i = 1; i <= 5; i++) {
        list.add(i);  // Integer hinzufügen
    }
}

// Verwendung
List<Number> numbers = new ArrayList<>();
List<Object> objects = new ArrayList<>();
List<Integer> integers = new ArrayList<>();

addNumbers(numbers);   // OK (Number ist super von Integer)
addNumbers(objects);   // OK (Object ist super von Integer)
addNumbers(integers);  // OK (Integer ist super von Integer)
```
### 6.4 PECS - Producer Extends, Consumer Super
``` java
// Producer - liefert Werte (extends)
public void copy(List<? extends T> source, List<? super T> target) {
    for (T item : source) {  // source PRODUZIERT T's
        target.add(item);     // target KONSUMIERT T's
    }
}
```
## Type Bounds (Einschränkungen)
### 7.1 Single Bound
``` java
public class NumericBox<T extends Number> {
private T value;

    public NumericBox(T value) {
        this.value = value;
    }
    
    public double doubleValue() {
        return value.doubleValue();  // Number-Methode verfügbar
    }
}

// Verwendung
NumericBox<Integer> intBox = new NumericBox<>(10);
NumericBox<Double> doubleBox = new NumericBox<>(10.5);
// NumericBox<String> stringBox = ... // Compiler-Fehler!
```
### 7.2 Multiple Bounds
``` java
interface Comparable<T> { ... }
interface Serializable { ... }

public class MultiBound<T extends Number & Comparable<T> & Serializable> {
    private T value;
    
    public MultiBound(T value) {
        this.value = value;
    }
    
    public boolean isGreaterThan(T other) {
        return value.compareTo(other) > 0;  // Comparable-Methode
    }
}
```
## Type Inference (Typinferenz)
### 8.1 Diamond Operator (<>)
``` java
// Vor Java 7
List<String> list1 = new ArrayList<String>();

// Ab Java 7 (Diamond Operator)
List<String> list2 = new ArrayList<>();  // Typ wird inferiert
```
### 8.2 Bei Methodenaufrufen
``` java
public class Example {
    public static <T> T getValue(T value) {
        return value;
    }
}

// Explizit
String s1 = Example.<String>getValue("Hallo");

// Typinferenz (ab Java 8)
String s2 = Example.getValue("Hallo");  // String wird inferiert
```
## Raw Types (Roh-Typen)
# Achtung: Roh-Typen sollten vermieden werden!!!
``` java
// Generische Klasse
List<String> generischeListe = new ArrayList<>();

// Roh-Typ (schlecht!)
List roheListe = new ArrayList();  // Vermeiden!
roheListe.add("Text");
roheListe.add(123);  // Kein Compiler-Fehler!

// Gefahr bei Roh-Typen
List<String> strings = new ArrayList<>();
List raw = strings;  // Zuweisung erlaubt (aber gefährlich!)
raw.add(123);        // Kein Compiler-Fehler!
String s = strings.get(0);  // ClassCastException!
```
## Best Practices
### ✅ DO's
``` java
// 1. Typsicherheit nutzen
List<String> namen = new ArrayList<>();

// 2. Diamond Operator verwenden
Map<String, List<Integer>> map = new HashMap<>();

// 3. PECS-Regel beachten
public void addAll(List<? extends T> source, List<? super T> target)

// 4. Aussagekräftige Typparameter-Namen
public class Dictionary<K, V> { ... }
```
### ❌ DON'Ts
``` java
// 1. Roh-Typen vermeiden
List list = new ArrayList();  // Schlecht!

// 2. Keine Arrays mit generischen Typen
List<String>[] array = new List<String>[10];  // Compiler-Fehler!

// 3. Keine primitiven Typen als Typparameter
List<int> zahlen = new ArrayList<>();  // Geht nicht!
List<Integer> zahlen = new ArrayList<>();  // OK (Wrapper-Klasse)

// 4. Keine Instanziierung von Typparametern
public class MyClass<T> {
    private T obj = new T();  // Compiler-Fehler!
}
```
### Typlöschung (Type Erasure) verstehen
``` java
// Zur Compile-Zeit:
List<String> strings = new ArrayList<>();

// Zur Laufzeit (nach Typlöschung):
List strings = new ArrayList();  // Typ-Information verloren

// Deshalb kann man nicht zur Laufzeit prüfen:
if (strings instanceof List<String>)  // Compiler-Fehler!
if (strings instanceof List)          // OK (aber nur Roh-Typ)
```
### Häufige Anwendungen
``` java
// 1. Collections Framework
List<String> list = new ArrayList<>();
Set<Integer> set = new HashSet<>();
Map<String, Integer> map = new HashMap<>();

// 2. Comparable Interface
public class Person implements Comparable<Person> { ... }

// 3. Optional
Optional<String> optional = Optional.of("Wert");

// 4. Eigene generische Klassen
public class Resultat<T> {
    private T daten;
    private boolean erfolgreich;
    private String fehlerMeldung;
}
```
## Zusammenfassung 📝
``` java
Konzept	                Syntax	                Beispiel
Generische Klasse	class Name<T>	        class Box<T>
Generische Methode	<T> void methode(T t)	<T> T get(T t)
Unbounded Wildcard	?	                List<?>
Upper Bounded	        ? extends T	        List<? extends Number>
Lower Bounded	        ? super T	        List<? super Integer>
Single Bound	        <T extends Number>	<T extends Comparable>
Multiple Bounds	        <T extends A & B>	<T extends Number & Comparable>
```
Fazit
Generics sind ein mächtiges Werkzeug in Java, das:
``` java
✅ Typsicherheit zur Compile-Zeit bietet
✅ Casting überflüssig macht
✅ Wiederverwendbaren Code ermöglicht
✅ Lesbareren und wartbareren Code produziert
```
Die korrekte Anwendung von Generics ist essenziell für professionelle Java-Entwicklung! 🚀