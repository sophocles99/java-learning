package mortgage;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        displayTitle();

        int principal = (int) readNumberInput("Loan amount (£1000 - £1000,000): ", 1000, 1_000_000);
        float annualInterest = (float) readNumberInput("Annual interest rate (%): ", 0, 30);
        byte years = (byte) readNumberInput("Duration of mortgage (years): ", 1, 30);

        float monthlyInterest = calculateMonthlyInterest(annualInterest);
        short numberOfPayments = calculateNumberOfPayments(years);

        double monthlyPayment = calculateMonthlyPayment(principal, monthlyInterest, numberOfPayments);
        String monthlyPaymentString = NumberFormat.getCurrencyInstance(Locale.UK).format(monthlyPayment);
        System.out.println("\nYour monthly payment will be " + monthlyPaymentString);

        System.out.println("Balance after each payment:");
        for (short i = 1; i <= numberOfPayments; i++) {
            double balance = calculateBalance(principal, monthlyInterest, numberOfPayments, i);
            String formattedBalance = NumberFormat.getCurrencyInstance(Locale.UK).format(balance);
            System.out.println(String.format("%-5s", i + ".") + formattedBalance);
        }
    }

    public static void displayTitle() {
        System.out.println("===========================");
        System.out.println("Mortgage Payment Calculator");
        System.out.println("===========================\n");
    }

    public static double readNumberInput(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) return value;
            System.out.println("Please enter a value between " + min + " and " + max);
        }
    }

    public static float calculateMonthlyInterest(float annualInterest) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        return annualInterest / MONTHS_IN_YEAR / PERCENT;
    }

    public static short calculateNumberOfPayments(byte years) {
        final byte MONTHS_IN_YEAR = 12;
        return (short) (years * MONTHS_IN_YEAR);
    }

    public static double calculateMonthlyPayment(int principal, float monthlyInterest, short numberOfPayments) {
        return principal
                * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public static double calculateBalance(int principal, float monthlyInterest, short numberOfPayments, short paymentCount) {
        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, paymentCount))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}