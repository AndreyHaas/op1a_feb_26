package com.haas.andy.tag05.projekt;

public class PfandRechner {

    public static final double PLASTIK_PFAND_GEBUER = 0.25;
    public static final double GLAS_PFAND_GEBUER = 0.15;

    double pfandBerechnung(int plastikFlaschenStk, int glasFlaschenStk) {
        return glasFlaschenStk * GLAS_PFAND_GEBUER + plastikFlaschenStk * PLASTIK_PFAND_GEBUER;
    }

    void getMessage(double pfandSumme) {
        if (pfandSumme < 1) {
            System.out.println("Sie haben nur wenige Flaschen abgegeben.");
        } else if (pfandSumme <= 5) {
            System.out.println("Eine gute Menge an Flaschen zurückgegeben!");
        } else {
            System.out.println("Wow, das sind viele Flaschen!");
        }
    }
}