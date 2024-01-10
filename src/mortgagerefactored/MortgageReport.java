package mortgagerefactored;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    private final MortgageCalculator calculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance(Locale.UK);
    }

    public void displayMonthlyPayment() {
        double monthlyPayment = calculator.calculateMonthlyPayment();
        String monthlyPaymentString = currency.format(monthlyPayment);
        System.out.println("Monthly payment");
        System.out.println("---------------");
        System.out.println(monthlyPaymentString + "\n");
    }

    public void displayPaymentSchedule() {
        System.out.println("Payment schedule");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }
}
