import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Welcome to the Reverse Polish Notation calculator!");
        System.out.println("https://en.wikipedia.org/wiki/Reverse_Polish_notation");
        System.out.println("With this program you can calculate your expressions.");
        System.out.println("Available operators: +, -, *, /, ^");
        System.out.println("Example:");
        System.out.println("Input: 2 3 +");
        System.out.println("Output: 5");
        System.out.println("Also, if you want to input negative number, you can write it like that:\n(-1) = 0 1 -");
        System.out.println("Input new expression here:");

        String expression = in.nextLine();

        Calculator calculator = new RPN();
        var result = calculator.calculate(expression);
        System.out.println(result);
    }
}