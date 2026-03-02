# Das ultimative Handbuch zu Java Collections (Java Collections Framework)

## 1. Einführung in das Java Collections Framework (JCF)

Das **Java Collections Framework (JCF)** ist eine einheitliche Architektur zur Verwaltung und Darstellung von Objektgruppen (Kollektionsobjekten). Es ist einer der wichtigsten Bestandteile der Java Standard Edition und bietet:

*   **Schnittstellen (Interfaces):** Abstrakte Datentypen, die den Typ der Kollektion definieren (z. B. `List`, `Set`, `Map`).
*   **Implementierungen (Klassen):** Konkrete Klassen, die diese Schnittstellen implementieren (z. B. `ArrayList`, `HashSet`, `HashMap`).
*   **Algorithmen:** Statische Methoden in der Hilfsklasse `Collections`, die nützliche Operationen wie Suchen oder Sortieren durchführen.

**Warum Kollektionen und nicht einfach Arrays?**
Vor Java 1.2 waren Entwickler hauptsächlich auf Arrays angewiesen. Arrays haben jedoch erhebliche Nachteile:
*   **Feste Größe:** Die Größe eines Arrays ist unveränderlich.
*   **Weniger Funktionalität:** Arrays bieten keine vorgefertigten Methoden für das Hinzufügen, Entfernen oder Suchen von Elementen.
*   **Typunsicherheit (vor Generics):** In Arrays ist der Typ festgelegt, aber bei älteren Kollektionen war das nicht immer der Fall.

Das JCF löst diese Probleme, indem es eine standardisierte, leistungsstarke und typsichere Möglichkeit bietet, mit Objektgruppen zu arbeiten.

## 2. Die Hierarchie der Kollektionen

Die Hierarchie besteht aus zwei Hauptästen: `Collection` und `Map`. Eine `Map` ist **kein** direkter Untertyp von `Collection`, gehört aber untrennbar zum Framework.
```Java 
Iterable (Interface)
└── Collection (Interface)
├── List (Interface) // z.B. ArrayList, LinkedList
├── Set (Interface) // z.B. HashSet, TreeSet
│ └── SortedSet (Interface) // z.B. TreeSet
└── Queue (Interface) // z.B. LinkedList, PriorityQueue
└── Deque (Interface) // z.B. ArrayDeque

Map (Interface) // z.B. HashMap, TreeMap
└── SortedMap (Interface) // z.B. TreeMap
```

## 3. Grundlegende Interfaces im Detail

### 3.1. Das `Collection`-Interface
Das Wurzel-Interface im Kollektionsbaum. Es definiert die grundlegenden Methoden, die alle Kollektionen gemeinsam haben:
*   `boolean add(E e)`
*   `boolean remove(Object o)`
*   `boolean contains(Object o)`
*   `int size()`
*   `boolean isEmpty()`
*   `void clear()`
*   `Iterator<E> iterator()`

### 3.2. Das `List`-Interface
*   **Eigenschaften:** Geordnete Kollektion (Index-basiert). **Duplikate sind erlaubt**. Der Benutzer hat die Kontrolle darüber, wo in der Liste jedes Element eingefügt wird, und kann auf Elemente über ihren Index zugreifen.
*   **Hauptimplementierungen:**
    *   `ArrayList`: Basiert auf einem dynamischen Array. Bietet schnellen wahlfreien Zugriff (`O(1)`), ist aber langsam beim Einfügen/Entfernen in der Mitte (`O(n)`).
    *   `LinkedList`: Basiert auf einer doppelt verketteten Liste. Bietet schnelles Einfügen/Entfernen am Anfang/Ende (`O(1)`), ist aber langsam beim wahlfreien Zugriff (`O(n)`).

### 3.3. Das `Set`-Interface
*   **Eigenschaften:** Eine Kollektion, die **keine Duplikate** enthält. Es gibt keine Positionsangabe (kein Index). Die Gleichheit wird mit der `equals()`-Methode bestimmt.
*   **Hauptimplementierungen:**
    *   `HashSet`: Nutzt eine Hashtabelle. Bietet konstante Zeit (`O(1)`) für die Grundoperationen. Die Reihenfolge der Elemente ist nicht vorhersagbar.
    *   `LinkedHashSet`: Merkt sich die Einfügereihenfolge (doppelt verkettete Liste zwischen den Einträgen).
    *   `TreeSet`: Implementiert `SortedSet`. Die Elemente werden in sortierter Reihenfolge aufbewahrt (entweder natürlich oder über einen `Comparator`). Operationen sind `O(log n)`.

### 3.4. Das `Queue`-Interface
*   **Eigenschaften:** Eine Kollektion zur Aufbewahrung von Elementen vor der Verarbeitung (FIFO-Prinzip: First-In-First-Out). Bietet spezielle Methoden zum Hinzufügen, Entfernen und Abfragen von Elementen.
*   **Hauptimplementierungen:**
    *   `PriorityQueue`: Eine Warteschlange, in der die Elemente nach ihrer natürlichen Ordnung oder einem `Comparator` sortiert werden (kein reines FIFO).
    *   `ArrayDeque`: Ein doppelseitige Warteschlange (Deque), die als Queue oder Stack verwendet werden kann. Oft schneller als `LinkedList` und `Stack`.

### 3.5. Das `Map`-Interface
*   **Eigenschaften:** Ein Objekt, das Schlüssel auf Werte abbildet. Eine Map kann **keine duplizierten Schlüssel** enthalten; jeder Schlüssel kann maximal einen Wert abbilden. Gehört nicht zur `Collection`-Hierarchie.
*   **Hauptimplementierungen:**
    *   `HashMap`: Basiert auf einer Hashtabelle. Bietet konstante Zeit (`O(1)`) für `get` und `put`. Reihenfolge nicht garantiert.
    *   `LinkedHashMap`: Merkt sich die Einfügereihenfolge oder Zugriffsreihenfolge.
    *   `TreeMap`: Implementiert `SortedMap`. Sortiert nach Schlüsseln. Operationen sind `O(log n)`.
    *   `Hashtable`: Ältere, synchronisierte Version. Sollte vermieden werden (heute `ConcurrentHashMap` verwenden).

## 4. Generics und Typsicherheit

Seit Java 5 sind Kollektionen generisch. Das bedeutet, dass man zur Kompilierzeit den Typ der Objekte angeben kann, die in der Kollektion gespeichert werden.

**Vorteile:**
*   **Typsicherheit:** Der Compiler verhindert, dass man Objekte vom falschen Typ hinzufügt.
*   **Kein Casting nötig:** Man muss das Element nicht mehr manuell von `Object` in den gewünschten Typ konvertieren.

**Beispiel:**
```java
// Ohne Generics (Alt)
List meineListe = new ArrayList();
meineListe.add("Hallo");
String text = (String) meineListe.get(0); // Cast nötig!

// Mit Generics (Modern)
List<String> meineListe = new ArrayList<>();
meineListe.add("Hallo");
String text = meineListe.get(0); // Kein Cast nötig!
```

### 5. Wichtige Algorithmen: Die Collections-Klasse
Die Klasse java.util.Collections bietet eine Reihe von statischen Hilfsmethoden, die auf Kollektionen arbeiten.

#### Sortieren:
```java 
Collections.sort(List<T> list) 
```

#### Suchen: 
```java 
int index = Collections.binarySearch(List<T> list, T key) (Liste muss sortiert sein)
```

#### Umkehren: 
```java
Collections.reverse(List<?> list)
```

#### Mischen: 
```java
Collections.shuffle(List<?> list)
```

#### Unveränderliche Kollektionen: 
```java
Collections.unmodifiableList(list)
```

#### Synchronisierte Kollektionen: 
```java
Collections.synchronizedList(list) (für Thread-Sicherheit)
```

### 6. Moderne Features (Java 8+)
Mit Java 8 kamen Streams und Lambdas hinzu, die die Arbeit mit Kollektionen revolutioniert haben.

Beispiel: Deklarative Verarbeitung mit Streams
```java
List<String> namen = Arrays.asList("Anna", "Bob", "Charlie", "David");

// Alle Namen filtern, die mit 'A' oder 'B' anfangen, in Großbuchstaben umwandeln, sortieren und sammeln
List<String> ergebnis = namen.stream()
.filter(name -> name.startsWith("A") || name.startsWith("B"))
.map(String::toUpperCase)
.sorted()
.collect(Collectors.toList());

System.out.println(ergebnis); // [ANNA, BOB]
```
### 7. Zusammenfassung: Welche Kollektion nehme ich wann?
```java
   Interface	        Implementierung	        Stärken / Verwendung
   List	                ArrayList	            Standardwahl für eine Liste. Schneller Zugriff über Index.
   List	                LinkedList	            Häufiges Einfügen/Löschen am Anfang/Ende. Zusätzlich als Queue/Deque nutzbar.
   Set	                HashSet	                Standardwahl für eine Menge ohne Duplikate. Reihenfolge egal.
   Set	                LinkedHashSet	        Wie HashSet, aber Einfügereihenfolge soll erhalten bleiben.
   Set	                TreeSet	                Ein Set, das sortiert sein muss.
   Queue	            ArrayDeque	            Standardwahl für Queue/Stack (FIFO/LIFO).
   Queue	            PriorityQueue	        Elemente sollen in einer bestimmten Reihenfolge verarbeitet werden.
   Map	                HashMap	                Standardwahl für Schlüssel-Wert-Paare.
   Map	                LinkedHashMap	        Wie HashMap, aber Einfügereihenfolge erhalten.
   Map	                TreeMap	                Eine Map, deren Schlüssel sortiert sein müssen.
```
### Dieses Framework ist essentiell für jeden Java-Entwickler. Das Verständnis der Unterschiede zwischen den Schnittstellen und Implementierungen hilft dabei, effizienten und sauberen Code zu schreiben.