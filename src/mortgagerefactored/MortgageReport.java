package mortgagerefactored;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    private final MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void displayPaymentSchedule() {
        System.out.println("Payment schedule");
        System.out.println("----------------");
        System.out.println("Month\tBalance");
        for (short month = 1; month <= calculator.getYears() * MortgageCalculator.MONTHS_IN_YEAR; month++) {
            double balance = calculator.calculateBalance(month);
            String formattedBalance = NumberFormat.getCurrencyInstance(Locale.UK).format(balance);
            System.out.println(String.format("%-4s", month + ".") + "\t" + formattedBalance);
        }
    }

    public void displayMonthlyPayment() {
        double monthlyPayment = calculator.calculateMonthlyPayment();
        String monthlyPaymentString = NumberFormat.getCurrencyInstance(Locale.UK).format(monthlyPayment);
        System.out.println("Monthly payment");
        System.out.println("---------------");
        System.out.println(monthlyPaymentString + "\n");
    }

}
