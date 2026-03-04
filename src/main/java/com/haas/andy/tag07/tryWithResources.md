## Try-with-resources in Java
### 📌 Was ist das?
### Try-with-resources ist ein Sprachkonstrukt, das mit Java 7 eingeführt wurde und Ressourcen nach der Verwendung automatisch schließt. Die Ressourcen müssen das Interface AutoCloseable oder Closeable implementieren.

### 🔧 Syntax
```java
try (RessourcenTyp resource = new RessourcenTyp()) {
// Verwendung der Ressource
} catch (ExceptionTyp e) {
// Ausnahmebehandlung
}
```
### 💡 Vorteile
#### Automatisches Schließen — kein manueller Aufruf von close() nötig

#### Saubererer Code — weniger Boilerplate-Code

#### Korrekte Ausnahmebehandlung — unterdrückte Ausnahmen gehen nicht verloren

### 📝 Beispiele
#### Einfaches Beispiel mit Datei
```java
// Vor Java 7 (alte Methode)
BufferedReader br = null;
try {
    br = new BufferedReader(new FileReader("datei.txt"));
    System.out.println(br.readLine());
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (br != null) {
        try {
            br.close();
} catch (IOException e) {
    e.printStackTrace();
        }
    }
}
```
```Java
// Mit try-with-resources (Java 7+)
try (BufferedReader br = new BufferedReader(new FileReader("datei.txt"))) {
    System.out.println(br.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
// br wird automatisch geschlossen
```
#### Mehrere Ressourcen
```java
try (FileInputStream fin = new FileInputStream("eingabe.txt");
FileOutputStream fout = new FileOutputStream("ausgabe.txt")) {
    byte[] buffer = new byte[1024];
    int length;
    while ((length = fin.read(buffer)) > 0) {
        fout.write(buffer, 0, length);
    }
} catch (IOException e) {
    e.printStackTrace();
}
// Beide Ressourcen werden automatisch geschlossen (in umgekehrter Reihenfolge)
```
#### Eigene Ressource
```java
public class MeineRessource implements AutoCloseable {

    public void machWas() {
        System.out.println("Mache etwas...");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("Ressource geschlossen");
    }
}
```
```java
// Verwendung
try (MeineRessource resource = new MeineRessource()) {
    resource.machWas();
} catch (Exception e) {
    e.printStackTrace();
}
// Ausgabe:
// Mache etwas...
// Ressource geschlossen
```
## 🎯 Besonderheiten
### 1. Reihenfolge des Schließens
#### Ressourcen werden in umgekehrter Reihenfolge ihrer Deklaration geschlossen:

```java
try (RessourceA a = new RessourceA();
RessourceB b = new RessourceB()) {
// ...
} // zuerst wird b geschlossen, dann a
```
### 2. Unterdrückte Ausnahmen
#### Wenn sowohl im try-Block als auch beim Schließen der Ressource eine Ausnahme auftritt, "gewinnt" die Ausnahme aus dem try-Block, und die Ausnahme beim Schließen wird unterdrückt:

```java
public class Ressource implements AutoCloseable {
    public void close() throws Exception {
        throw new Exception("Fehler beim Schließen");
    }
}

try (Ressource r = new Ressource()) {
    throw new Exception("Fehler im try-Block");
} catch (Exception e) {
    System.out.println(e.getMessage()); // "Fehler im try-Block"
    Throwable[] suppressed = e.getSuppressed();
    System.out.println(suppressed[0].getMessage()); // "Fehler beim Schließen"
}
```
### 3. Java 9+ Verbesserung
   Es können effectively final Variablen verwendet werden:
```java
// Java 9+
BufferedReader br = new BufferedReader(new FileReader("datei.txt"));
try (br) {  // Variable muss effectively final sein
    System.out.println(br.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
```
## 📊 Versionsvergleich
```
Java-Version	    Funktionen
Java 7	            Basis-Try-with-resources
Java 9	            Unterstützung für effectively final Variablen
```
### ✅ Best Practices
#### Verwenden Sie immer try-with-resources für Closeable/AutoCloseable Ressourcen
#### Nicht mit finally-Block mischen für das Schließen von Ressourcen
#### Reihenfolge beachten bei abhängigen Ressourcen

### Ausnahmen behandeln im catch-Block

#### 🚫 Was vermeiden
```java
// SCHLECHT: Manuelles Schließen in finally
Ressource r = null;
try {
    r = new Ressource();
} finally {
    if (r != null) {
    r.close(); // Risiko einer Ausnahme
    }
}
```
```java
// GUT: Automatisches Schließen
try (Ressource r = new Ressource()) {
    // Verwendung
}
```
### 📚 Ressourcen, die try-with-resources unterstützen
* InputStream, OutputStream
* Reader, Writer
* Scanner
* Connection, Statement, ResultSet (JDBC)
* Socket
* Alle Klassen, die AutoCloseable implementieren