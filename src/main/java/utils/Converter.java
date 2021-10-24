package utils;

import java.util.Stack;

public class Converter {
    public static String infixToPostfix(String exp) {
        var expression = exp.trim();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (Utils.isNum(String.valueOf(c))) {
                if (result.length() > 0 && Utils.isOperator(String.valueOf(result.charAt(result.length() - 1))))
                    result.append(" ");
                result.append(c);
                if (i != expression.length() - 1 && Utils.isOperator(String.valueOf(expression.charAt(i + 1))))
                    result.append(" ");
            } else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(" ");
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(" ");
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(" ");
            result.append(stack.pop());
        }
        return result.toString().replace("  ", " ");
    }

    private static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
}