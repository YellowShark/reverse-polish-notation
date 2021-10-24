package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {
    @Test
    public void test_simpleExpression() {
        var exp = "2+2";
        assertEquals("2 2 +", Converter.infixToPostfix(exp));
    }

    @Test
    public void test_brackets() {
        var exp1 = "(2+2)";
        var exp2 = "(2+(2+2))+(2+2)";
        assertEquals("2 2 +", Converter.infixToPostfix(exp1));
        assertEquals("2 2 2 + + 2 2 + +", Converter.infixToPostfix(exp2));
    }

    @Test
    public void test_precedence() {
        var exp = "2^2+2*2";
        assertEquals("2 2 ^ 2 2 * +", Converter.infixToPostfix(exp));
    }

    @Test
    public void test_complexExpression() {
        var exp = "((10*(6*((9+3)*11)))+17)+5";
        assertEquals("10 6 9 3 + 11 * * * 17 + 5 +", Converter.infixToPostfix(exp));
    }
}