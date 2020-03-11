package com.example.passwordstrength.models;

public class Verifier {

    private static boolean tieneLongitudRequerida(String pass) {
        if (pass.length() > 5)
                return true;
        return false;
    }

    private static boolean tieneMayuscula(String pass) {
        return pass.matches(".*[A-Z].*");
    }

    private static boolean tieneNumero(String pass) {
        return pass.matches(".*\\d+.*");
    }

    public static int howStrength(String pass) {
        if(tieneLongitudRequerida(pass) && tieneMayuscula(pass) && tieneNumero(pass))
            return 4;
        else if (tieneLongitudRequerida(pass) && tieneMayuscula(pass) && !tieneNumero(pass))
            return 3;
        else if (tieneLongitudRequerida(pass) && !tieneMayuscula(pass))
            return 2;
        else if(!tieneLongitudRequerida(pass))
            return 1;
        else
            return 0;
    }
}
