package utils;

import java.util.ArrayList;

public class Validator {
    public static boolean isValid(String expression) {
        return withoutInvalidSymbols(expression) && validExpression(expression);
    }

    private static boolean withoutInvalidSymbols(String expression) {
        for (String token : expression.split("")) {
            if (!Utils.isOperator(token) && !Utils.isNum(token) && !Utils.isBracket(token))
                return false;
        }
        return true;
    }

    private static boolean validExpression(String expression) {
        return validBrackets(expression) && validOtherOperators(expression);
    }

    private static boolean validOtherOperators(String expression) {
        var operatorsCount = 0;
        var operandsCount = 0;
        var newOperand = true;
        var exp = expression.replace("(", "").replace(")", "");
        for (String token : exp.split("")) {
            if (Utils.isOperator(token)) {
                operatorsCount++;
                newOperand = true;
            } else {
                if (newOperand) {
                    operandsCount++;
                    newOperand = false;
                }
            }
        }
        return operatorsCount == --operandsCount;
    }

    private static boolean validBrackets(String expression) {
        var brackets = new ArrayList<String>();
        for (String token : expression.split("")) {
            if (Utils.isBracket(token))
                brackets.add(token);
        }
        if (brackets.size() == 0) return true;
        if (brackets.size() % 2 == 1) return false;
        for (int i = 0; i < brackets.size() / 2; i++) {
            if (!(brackets.get(i).equals("(") && brackets.get(brackets.size() - 1 - i).equals(")"))) {
                return false;
            }
        }
        return true;
    }
}
