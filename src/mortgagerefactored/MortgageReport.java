package mortgagerefactored;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    final static byte MONTHS_IN_YEAR = 12;

    public static void displayMonthlyPayment(int principal, float annualInterest, byte years) {
        double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(principal, annualInterest, years);
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
            double balance = MortgageCalculator.calculateBalance(principal, annualInterest, years, month);
            String formattedBalance = NumberFormat.getCurrencyInstance(Locale.UK).format(balance);
            System.out.println(String.format("%-4s", month + ".") +"\t" + formattedBalance);
        }
    }
}
