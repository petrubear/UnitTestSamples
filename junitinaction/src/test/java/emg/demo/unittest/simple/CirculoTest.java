package emg.demo.unittest.simple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CirculoTest {

    @Test
    public void testAreaCirculo() {
        Circulo circulo = new Circulo();
        assertEquals(Math.PI, circulo.area(1.0), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValoresIncorrectos() {
        Circulo circulo = new Circulo();
        assertEquals(Math.PI, circulo.area(-1.0), 0.001);
    }
}
