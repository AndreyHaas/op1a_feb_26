package com.haas.andy.tag08.package1;

import package2.Auto2;

public class SportWagen extends Auto2 {

    protected String marke;
    String ersteller;          // default (kein Modifier)
    private String antrieb;
    public int anzahlSitze;

    

    public SportWagen() {
        this.marke = "BMW";
        this.ersteller = "BMW AG";
        this.antrieb = "Allrad";
        this.anzahlSitze = 2;
    }
    public String getAntrieb() {
        return antrieb;
    }

    public void setAntrieb(String antrieb) {
        this.antrieb = antrieb;
    }
}