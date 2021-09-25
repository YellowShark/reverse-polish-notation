import org.apache.commons.lang3.tuple.Pair;

import java.util.Stack;

public class RPN implements Calculator<Float> {

    Stack<String> stack;

    public RPN() {
        stack = new Stack<>();
    }

    public float calculate(String[] tokens) {
        // Initialize the stack and the variable
        float x, y;
        String result = "";
        String choice;

        // Iterating to the character
        // in the array of the string
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-")
                    && !token.equals("*") && !token.equals("/")) {
                stack.push(token);
                continue;
            } else {
                choice = token;
            }

            y = Float.parseFloat(stack.pop());
            x = Float.parseFloat(stack.pop());
            result = "" + execute(parseOperator(choice), Pair.of(x, y));

            stack.push(result);
        }
        // Method to convert the String to float
        return Float.parseFloat(stack.pop());
    }

    @Override
    public float execute(Operator operator, Pair<Float, Float> operands) {
        switch (operator) {
            case PLUS -> {
                return operands.getLeft() + operands.getRight();
            }
            case MINUS -> {
                return operands.getLeft() - operands.getRight();
            }
            case MULT -> {
                return operands.getLeft() * operands.getRight();
            }
            case DIV -> {
                return operands.getLeft() / operands.getRight();
            }
        }
        throw new ArithmeticException("Unexpected token");
    }

    private Operator parseOperator(String operator) {
        switch (operator) {
            case "+" -> {
                return Operator.PLUS;
            }
            case "-" -> {
                return Operator.MINUS;
            }
            case "*" -> {
                return Operator.MULT;
            }
            case "/" -> {
                return Operator.DIV;
            }
        }
        throw new ArithmeticException("Unexpected token");
    }
}



