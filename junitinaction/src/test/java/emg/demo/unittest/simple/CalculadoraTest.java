package emg.demo.unittest.simple;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculadoraTest {

    @Test
    public void testSuma() {
        Calculadora calculadora = new Calculadora();
        assertEquals("should be the sum", 12.0, calculadora.suma(5.0, 7.0), 0);
    }

    @Test
    public void testResta() {
        CalculadoraService calculadoraService = mock(CalculadoraService.class);
        when(calculadoraService.resta(anyDouble(), anyDouble())).thenReturn(10.0);
        Calculadora calculadora = new Calculadora();
        calculadora.setCalculadoraService(calculadoraService);
        assertEquals("should be equal", 10.0, calculadora.resta(30.0, 20.0), 0.0);
    }
}