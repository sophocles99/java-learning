package mortgagerefactored;

import java.util.Scanner;

public class Console {
    private final static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }
    public static double readNumber(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            double value = scanner.nextDouble();
            if (value >= min && value <= max) return value;
            System.out.println("Please enter a value between " + min + " and " + max);
        }
    }
}