package emg.demo.unittest.simple;

public class Circulo {

    public double area(double radio) throws IllegalArgumentException {
        if (radio < 0) {
            throw new IllegalArgumentException("El radio no puede ser menor que 0");
        }
        return Math.PI * (radio * radio);
    }
}
