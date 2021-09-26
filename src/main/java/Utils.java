public class Utils {
    public static final String OPERATORS = "+-*/^";

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
}
