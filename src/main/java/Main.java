import domain.Calculator;
import service.RPN;

import java.util.Objects;
import java.util.Scanner;


public class Main {
    private static final String EXIT = "e";

    public static void main(String[] args) {
        String expression;
        var in = new Scanner(System.in);
        do {
            System.out.println("Input new expression here (" + EXIT + " - exit):");
            expression = in.nextLine();
            if (!Objects.equals(expression, EXIT)) {
                Calculator calculator = new RPN();
                try {
                    var result = calculator.calculate(expression);
                    System.out.println(result);
                } catch (ArithmeticException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } while (!expression.equals(EXIT));
        in.close();
    }
}