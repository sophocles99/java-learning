package mortgagerefactored;

import java.text.NumberFormat;
import java.util.Locale;

public class Mortgage {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

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
