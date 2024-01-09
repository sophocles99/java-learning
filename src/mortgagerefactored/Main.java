package mortgagerefactored;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Loan amount (£1000 - £1000,000): ", 1000, 1000_000);
        float annualInterest = (float) Console.readNumber("Annual interest rate (%): ", 0, 30);
        byte years = (byte) Console.readNumber("Duration of mortgage (years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);

        var report = new MortgageReport(calculator);

        Title.display();
        report.displayMonthlyPayment();
        report.displayPaymentSchedule();
    }
}
