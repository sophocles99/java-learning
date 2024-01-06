package mortgagerefactored;

import java.util.Scanner;

public class NumberInput {
    private final String prompt;
    private final double min;
    private final double max;

    private NumberInput(String prompt, double min, double max) {
        this.prompt = prompt;
        this.min = min;
        this.max = max;
    }

    private double getInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            double value = scanner.nextDouble();
            if (value >= min && value <= max) return value;
            System.out.println("Please enter a value between " + min + " and " + max);
        }
    }

    public static double getNumberInput(String prompt, double min, double max) {
        NumberInput input = new NumberInput(prompt, min, max);
        return input.getInput();
    }
}