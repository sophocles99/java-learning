package mortgage;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        displayTitle();

        int principal = (int) readNumberInput("Loan amount (£1000 - £1000,000): ", 1000, 1_000_000);
        float annualInterest = (float) readNumberInput("Annual interest rate (%): ", 0, 30);
        byte years = (byte) readNumberInput("Duration of mortgage (years): ", 1, 30);

        displayMonthlyPayment(principal, annualInterest, years);
        displayPaymentSchedule(principal, annualInterest, years);
    }

    public static void displayTitle() {
        System.out.println("===========================");
        System.out.println("Mortgage Payment Calculator");
        System.out.println("===========================\n");
    }

    public static void displayMonthlyPayment(int principal, float annualInterest, byte years) {
        double monthlyPayment = calculateMonthlyPayment(principal, annualInterest, years);
        String monthlyPaymentString = NumberFormat.getCurrencyInstance(Locale.UK).format(monthlyPayment);
        System.out.println("Monthly payment");
        System.out.println("---------------");
        System.out.println(monthlyPaymentString + "\n");
    }

    public static void displayPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println("Payment schedule");
        System.out.println("----------------");
        System.out.println("Month\tBalance");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            String formattedBalance = NumberFormat.getCurrencyInstance(Locale.UK).format(balance);
            System.out.println(String.format("%-4s", month + ".") +"\t" + formattedBalance);
        }
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

    public static double calculateMonthlyPayment(int principal, float annualInterest, byte years) {
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        return principal
                * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}