package utils;

public class Validator {
    public static boolean isValid(String expression) {
        return withoutInvalidSymbols(expression) && validExpression(expression);
    }

    private static boolean withoutInvalidSymbols(String expression) {
        for (String token : expression.split("")) {
            if (!Utils.isOperator(token) && !Utils.isNum(token))
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
        var leftBracketsCount = 0;
        var rightBracketsCount = 0;
        for (String token : expression.split("")) {
            if (token.equals("("))
                leftBracketsCount++;
            else if(token.equals(")"))
                rightBracketsCount++;
        }
        return leftBracketsCount == rightBracketsCount;
    }
}
