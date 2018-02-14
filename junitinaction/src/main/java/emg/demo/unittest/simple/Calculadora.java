package emg.demo.unittest.simple;

public class Calculadora {

    private CalculadoraService calculadoraService;

    public void setCalculadoraService(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    public double suma(double numero_a, double numero_b) {
        return numero_a + numero_b;
    }

    public double resta(double numero_a, double numero_b) {
        return calculadoraService.resta(numero_a, numero_b);
    }
}
