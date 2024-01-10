package mortgagerefactored;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    private final MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void displayMonthlyPayment() {
        double monthlyPayment = calculator.calculateMonthlyPayment();
        String monthlyPaymentString = NumberFormat.getCurrencyInstance(Locale.UK).format(monthlyPayment);
        System.out.println("Monthly payment");
        System.out.println("---------------");
        System.out.println(monthlyPaymentString + "\n");
    }

    public void displayPaymentSchedule() {
        System.out.println("Payment schedule");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).format(balance));
    }
}
