package emg.demo.unittest.simple;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {CalculadoraTest.class, CalculadoraParametrizedTest.class})
public class CalculadoraTestSuite {
}
