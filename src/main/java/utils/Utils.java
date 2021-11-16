package utils;

public class Utils {
    public static final String OPERATORS = "+-*/^";
    public static final String BRACKETS = "()";

    public static boolean isNum(String s) {
        try {
            var f = Float.parseFloat(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean isOperator(String s) {
        return OPERATORS.contains(s);
    }

    public static boolean isBracket(String s) {
        return BRACKETS.contains(s);
    }
}
