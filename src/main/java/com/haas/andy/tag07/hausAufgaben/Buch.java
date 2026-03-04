package com.haas.andy.tag07.hausAufgaben;

import java.util.StringJoiner;

public class Buch {
    private String titel;
    private String autor;
    private String isbn;
    private double preis;

    public Buch() {
    }

    public Buch(String titel, String autor) {
        this.titel = titel;
        this.autor = autor;
    }

    public Buch(String titel, String autor, String isbn, double preis) {
        this.titel = titel;
        this.autor = autor;
        this.isbn = isbn;
        this.preis = preis;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    String zeigeDetails() {
        return  this.titel + " " + this.autor + " " + this.isbn + " " + this.preis;
    }

    boolean istGuenstig() {
        return this.preis < 20.00;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Buch.class.getSimpleName() + "[", "]")
                .add("titel='" + titel + "'")
                .add("autor='" + autor + "'")
                .add("isbn='" + isbn + "'")
                .add("preis=" + preis)
                .toString();
    }
}
