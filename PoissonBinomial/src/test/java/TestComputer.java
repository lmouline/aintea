import duc.aintea.lib.poissonbinomial.Computer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestComputer {
    private static Computer COMPUTER = new Computer();


    @Test
    public void test1() {
        double[] actual = COMPUTER.compute(new double[]{0.3, 0.7, 0.9});
        Assertions.assertArrayEquals(new double[]{0.021, 0.247, 0.543, 0.189}, actual, 0.001);
    }

    @Test
    public void testNull() {
        double[] actual = COMPUTER.compute(null);
        Assertions.assertNull(actual);
    }

    @Test
    public void testEmpty() {
        double[] actual = COMPUTER.compute(new double[]{});
        Assertions.assertNull(actual);
    }

    @Test
    public void testMediumArray() {
        double[] actual = COMPUTER.compute(new double[]{0.83, 0.03, 0.23, 0.71, 0.4, 0.4, 0.25, 0.59, 0.81, 0.76});
        Assertions.assertArrayEquals(new double[]{1.858754e-04, 3.382146e-03, 2.508309e-02, 9.825909e-02, 2.211735e-01, 2.935284e-01, 2.290574e-01, 1.023399e-01, 2.435935e-02, 2.572063e-03, 5.907397e-05}, actual, 1e-04);
    }
}
