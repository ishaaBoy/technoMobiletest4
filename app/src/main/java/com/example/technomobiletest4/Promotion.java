package com.example.technomobiletest4;

public class Promotion {

    String proName;
    String proAbout;
    String proType;

    public Promotion(String proName, String proAbout, String proType ) {
        this.proName = proName;
        this.proAbout = proAbout;
        this.proType = proType;
    }

    public String getProName() {
        return proName;
    }

    public String getProAbout() {
        return proAbout;
    }

    public String getProType() {
        return proType;
    }
}
