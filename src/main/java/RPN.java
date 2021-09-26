import java.util.Stack;

public class RPN implements Calculator {

    private final Stack<String> stack;

    public RPN() {
        stack = new Stack<>();
    }

    @Override
    public String calculate(String expression) {
        var tokens = expression.split(" ");
        if (isValidExpression(tokens)) {
            float x, y;
            double result;
            String choice;

            for (String token : tokens) {
                if (!Utils.isOperator(token)) {
                    stack.push(token);
                } else {
                    choice = token;

                    y = Float.parseFloat(stack.pop());
                    x = Float.parseFloat(stack.pop());
                    result = execute(choice, new Operands(x, y));

                    stack.push(Double.toString(result));
                }
            }
            return Float.toString(Float.parseFloat(stack.pop()));
        } else
            return "Invalid input!!";
    }

    private boolean isValidExpression(String[] tokens) {
        for (String token : tokens) {
            if (!Utils.isOperator(token) && !Utils.isNum(token))
                return false;
        }
        return true;
    }

    public double execute(String operator, Operands operands) {
        switch (operator) {
            case "+" -> {
                return operands.getFirst() + operands.getSecond();
            }
            case "-" -> {
                return operands.getFirst() - operands.getSecond();
            }
            case "*" -> {
                return operands.getFirst() * operands.getSecond();
            }
            case "/" -> {
                return operands.getFirst() / operands.getSecond();
            }
            case "^" -> {
                return Math.pow(operands.getFirst(), operands.getSecond());
            }
        }
        throw new ArithmeticException("Unexpected token");
    }
}



