package com.example.passwordstrength.models;

public class Verifier {

    public static final int MIN_LENGTH = 5;
    public static final int SUPERSTRONG = 4;
    public static final int STRONG = 3;
    public static final int MEDIUM = 2;
    public static final int WEAK = 1;

    private static boolean tieneLongitudRequerida(String pass) {
        return pass.length() > MIN_LENGTH;
    }

    private static boolean tieneMayuscula(String pass) {
        return pass.matches(".*[A-Z].*");
    }

    private static boolean tieneNumero(String pass) {
        return pass.matches(".*\\d+.*");
    }

    public static int howStrength(String pass) {
        if(tieneLongitudRequerida(pass) && tieneMayuscula(pass) && tieneNumero(pass))
            return SUPERSTRONG;
        else if (tieneLongitudRequerida(pass) && tieneMayuscula(pass) && !tieneNumero(pass))
            return STRONG;
        else if (tieneLongitudRequerida(pass) && !tieneMayuscula(pass))
            return MEDIUM;
        else if(!tieneLongitudRequerida(pass))
            return WEAK;
        else
            return 0;
    }
}
