package emg.demo.unittest.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculadoraTest {

    @Test
    public void testSuma() {
        Calculadora calculadora = new Calculadora();
        assertEquals(12.0, calculadora.suma(5.0, 7.0), 0);
    }
}