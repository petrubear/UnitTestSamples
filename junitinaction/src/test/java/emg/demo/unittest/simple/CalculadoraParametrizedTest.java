package emg.demo.unittest.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculadoraParametrizedTest {

    double esperado;
    double valorA;
    double valorB;

    @Parameterized.Parameters
    public static Collection<Double[]> obtenerParametrosPrueba() {
        return Arrays.asList(new Double[][]{
                {2.0, 1.0, 1.0},
                {3.0, 2.0, 1.0},
                {4.0, 3.0, 1.0},
        });
    }

    public CalculadoraParametrizedTest(double esperado, double valorA, double valorB) {
        this.esperado = esperado;
        this.valorA = valorA;
        this.valorB = valorB;
    }

    @Test
    public void testSuma() {
        Calculadora calculadora = new Calculadora();
        assertEquals(esperado, calculadora.suma(valorA, valorB), 0);
    }
}
