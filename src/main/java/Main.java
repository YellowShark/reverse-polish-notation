import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final String EXIT = "e";

    public static void main(String[] args) {
        String expression;
        do {
            System.out.println("Input new expression here (" + EXIT + " - exit):");

            var in = new Scanner(System.in);
            expression = in.nextLine();
            if (!Objects.equals(expression, EXIT)) {
                Calculator calculator = new RPN();
                var result = calculator.calculate(Converter.infixToPostfix(expression));
                System.out.println(result);
            }
        } while (!expression.equals(EXIT));
    }
}