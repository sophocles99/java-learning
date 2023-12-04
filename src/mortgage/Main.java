package mortgage;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal;
        float monthlyInterest;
        int numberOfPayments;

        System.out.println("===========================");
        System.out.println("Mortgage Payment Calculator");
        System.out.println("===========================\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Loan amount (£1000 - £1000,000): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Please enter a number between 1,000 and 1000,000.");
        }

        while (true) {
            System.out.print("Annual interest rate (%): ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30) {
                monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
                break;
            }
            System.out.println("Please enter a number greater than 0 and less than or equal to 30.");
        }

        while (true) {
            System.out.print("Duration of mortgage (duration): ");
            byte duration = scanner.nextByte();
            if (duration >= 1 && duration <= 30) {
                numberOfPayments = duration * 12;
                break;
            }
            System.out.println("Please enter a number between 1 and 30.");
        }

        double monthlyPayment = principal
                * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);
        String monthlyPaymentString = currency.format(monthlyPayment);
        System.out.println("\nYour monthly payment will be " + monthlyPaymentString);
    }
}
