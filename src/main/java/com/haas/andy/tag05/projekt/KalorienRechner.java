package com.haas.andy.tag05.projekt;

public class KalorienRechner {
    static float getBmi(float gewicht, int groese) {
        return gewicht / (groese * groese);
    }

    static void getMessage(float bmi) {
        if (bmi < 18.5) {
            System.out.println("Untergewicht. Empfehlung 2500 kcal täglich");
        } else if (bmi >=18.5 && bmi <= 24.9) {
            System.out.println("Normalgewicht. Empfehlung 2000 kcal täglich");
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            System.out.println("Übergewicht. Empfehlung 1800 kcal täglich");
        } else {
            System.out.println("Adipositas. Empfehlung 1500 kcal täglich");
        }
    }
}
