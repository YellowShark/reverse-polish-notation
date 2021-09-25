public class Main {
    public static void main(String[] args) {
        var expression = new String[]{"10", "6", "+", "2", "/"};
        var rpn = new RPN();
        float result = rpn.calculate(expression);
        System.out.println(result);
    }
}
