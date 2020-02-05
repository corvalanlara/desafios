/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import latam.decimoquinto.Calculadora;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 *
 * @author cheshire
 */
public class TestCalc {
    
    @Test
    public void testSumar() {
        int uno = 2;
        int dos = 4;
        assertEquals(Calculadora.sumar(uno, dos), 6);
    }
    
    @Test
    public void testRestar() {
        int uno = 2;
        int dos = 4;
        assertEquals(Calculadora.restar(uno, dos), -2);
    }
    
    @Test
    public void testDividir() {
        int uno = 2;
        int dos = 4;
        assertEquals(Calculadora.dividir(dos, uno), 2.0);
    }
    
    @Test
    public void testMultiplicar() {
        int uno = 2;
        int dos = 4;
        assertEquals(Calculadora.multiplicar(uno, dos), 8);
    }
}
