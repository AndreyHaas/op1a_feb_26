package com.haas.andy.tag04;

public class MatheUtils {

    private MatheUtils() {}

    // Statische MEthode
    private static int berechneQuadrat(int zahl) {
        return zahl * zahl;
    }

    static void main(String[] args) {
        System.out.println(MatheUtils.berechneQuadrat(8));
    }
}
