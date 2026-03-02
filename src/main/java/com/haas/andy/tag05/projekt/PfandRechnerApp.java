package com.haas.andy.tag05.projekt;

import java.util.Scanner;

public class PfandRechnerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geben Sie Anzahl der Plastikflaschen ein: ");
        int plastikFlaschenStk = Integer.parseInt(scanner.nextLine());

        System.out.println("Geben Sie Anzahl der Glasflaschen ein: ");
        int glasFlaschenStk = Integer.parseInt(scanner.nextLine());

        PfandRechner pfandRechner = new PfandRechner();

        double pfandSumme = pfandRechner.pfandBerechnung(plastikFlaschenStk, glasFlaschenStk);

        pfandRechner.getMessage(pfandSumme);
    }
}
