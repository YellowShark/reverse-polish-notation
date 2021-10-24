package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {
    @Test
    public void test_simpleValidExpression() {
        var expression = "2+2";
        assertTrue(Validator.isValid(expression));
    }

    @Test
    public void test_complexValidExpression() {
        var expression = "((10*(6*((9+3)*11)))+17)+5";
        assertTrue(Validator.isValid(expression));
    }

    @Test
    public void test_invalidBrackets() {
        var expression = "((10*(6*((9+3)*11)))+17)+5)";
        assertFalse(Validator.isValid(expression));
    }

    @Test
    public void test_invalidCharacters() {
        var expression = "((10*(a*((9+3)*11)))+17)+5)";
        assertFalse(Validator.isValid(expression));
    }

    @Test
    public void test_invalidExpression1() {
        var expression = "(10++10)*5";
        assertFalse(Validator.isValid(expression));
    }

    @Test
    public void test_invalidExpression2() {
        var expression = "(10+10)*5*";
        assertFalse(Validator.isValid(expression));
    }

    @Test
    public void test_invalidExpression3() {
        var expression = "(10+10-)*5";
        assertFalse(Validator.isValid(expression));
    }

    @Test
    public void test_invalidExpression4() {
        var expression = "(10 +10)  *5";
        assertFalse(Validator.isValid(expression));
    }
}