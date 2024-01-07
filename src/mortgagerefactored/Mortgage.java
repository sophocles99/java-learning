package mortgagerefactored;

import java.text.NumberFormat;
import java.util.Locale;

public class Mortgage {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    private final int principal;
    private final float annualInterest;
    private final byte years;

    public Mortgage(int principal, float annualInterest, byte years) {
        if (principal < 1000 || principal > 1000_000)
            throw new IllegalArgumentException("Principal must be between 1,000 and 1,000,000");
        if (annualInterest < 0 || annualInterest > 30)
            throw new IllegalArgumentException("Annual interest must be between 0% and 30%");
        if (years < 1 || years > 30)
            throw new IllegalArgumentException("Duration of mortgage must be between 1 and 30 years");
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    private double calculateMonthlyPayment() {
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        return principal
                * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    private double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public void displayMonthlyPayment() {
        double monthlyPayment = calculateMonthlyPayment();
        String monthlyPaymentString = NumberFormat.getCurrencyInstance(Locale.UK).format(monthlyPayment);
        System.out.println("Monthly payment");
        System.out.println("---------------");
        System.out.println(monthlyPaymentString + "\n");
    }

    public void displayPaymentSchedule() {
        System.out.println("Payment schedule");
        System.out.println("----------------");
        System.out.println("Month\tBalance");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(month);
            String formattedBalance = NumberFormat.getCurrencyInstance(Locale.UK).format(balance);
            System.out.println(String.format("%-4s", month + ".") +"\t" + formattedBalance);
        }
    }
}
