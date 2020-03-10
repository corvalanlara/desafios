package com.example.passwordstrength;

import com.example.passwordstrength.models.Verifier;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void noTieneMasDeCincoCaracteres() {
        String contraseña = "asdf";
        assertEquals(Verifier.howStrength(contraseña), Verifier.WEAK);
    }

    @Test
    public void TieneMasDeCincoCaracteres() {
        String contraseña = "asdfgh";
        assertEquals(Verifier.howStrength(contraseña), Verifier.MEDIUM);
    }

    @Test
    public void TieneMayusculaYMasDeCincoCaracteres() {
        String contraseña = "asdfgH";
        assertEquals(Verifier.howStrength(contraseña), Verifier.STRONG);
    }

    @Test
    public void TieneMayusculaTieneNumeroYMasDeCincoCaracteres() {
        String contraseña = "asdfgH1";
        assertEquals(Verifier.howStrength(contraseña), Verifier.SUPERSTRONG);
    }
}