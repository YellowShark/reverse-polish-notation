import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RPNTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        this.calculator = new RPN();
    }

    @Test
    public void test_simpleExpression() {
        String res = calculator.calculate("2 2 +");
        assertEquals("4.0", res);
    }

    @Test
    public void test_complexExpression() {
        // ((10 * (6 * ((9 + 3) * (-11)))) + 17) + 5
        String res = calculator.calculate("10 6 9 3 + 0 11 - * * * 17 + 5 +");
        assertEquals("-7898.0", res);
    }

    @Test
    public void test_divisionByZero() {
        String res = calculator.calculate("1 0 /");
        assertEquals("Infinity", res);
    }

    @Test
    public void test_wrongInput() {
        String res = calculator.calculate("d 0 *");
        assertEquals("Invalid input.", res);
    }
}