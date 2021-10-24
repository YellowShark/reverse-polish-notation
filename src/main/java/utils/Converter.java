package utils;

import java.util.Stack;

public class Converter {
    public static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Utils.isNum(String.valueOf(c))) {
                if (result.length() > 0 && Utils.isOperator(String.valueOf(result.charAt(result.length() - 1))))
                    result.append(" ");
                result.append(c);
                if (i != exp.length() - 1 && Utils.isOperator(String.valueOf(exp.charAt(i + 1))))
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