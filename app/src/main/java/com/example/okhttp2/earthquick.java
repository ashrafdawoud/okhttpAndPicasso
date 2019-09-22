package com.example.okhttp2;

public class earthquick {
    public  static String mag;

    public earthquick(String mag) {
        this.mag=mag;
    }

    public static String getMag() {
        return mag;
    }

    public static void setMag(String mag) {
        earthquick.mag = mag;
    }
}
