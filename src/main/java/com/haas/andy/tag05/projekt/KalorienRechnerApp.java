package com.haas.andy.tag05.projekt;

import java.util.Scanner;

public class KalorienRechnerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geben Sie seine Größe in Meter ein: ");
        int groese = Integer.parseInt(scanner.nextLine());

        System.out.println("Geben Sie sein Gewicht in kg ein: ");
        float gewicht = Float.parseFloat(scanner.nextLine());

        float bmi = KalorienRechner.getBmi(gewicht, groese);

        KalorienRechner.getMessage(bmi);
    }
}