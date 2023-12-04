package mortgage;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        System.out.println("===========================");
        System.out.println("Mortgage Payment Calculator");
        System.out.println("===========================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Loan amount (£): ");
        int principal = scanner.nextInt();

        System.out.print("Annual interest rate (%): ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;

        System.out.print("Duration of mortgage (duration): ");
        int duration = scanner.nextInt();
        int numberOfPayments = duration * 12;

        double monthlyPayment = principal
                * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);
        String monthlyPaymentString = currency.format(monthlyPayment);
        System.out.println("\nYour monthly payment will be " + monthlyPaymentString);
    }
}
