package mortgagerefactored;

public class Main {
    public static void main(String[] args){
        int principal = (int) NumberInput.getNumberInput("Loan amount (£1000 - £1000,000): ", 1000, 1000_000);
        float annualInterest = (float) NumberInput.getNumberInput("Annual interest rate (%): ", 0, 30);
        byte years = (byte) NumberInput.getNumberInput("Duration of mortgage (years): ", 1, 30);

        Mortgage mortgage = new Mortgage(principal, annualInterest, years);

        Title.display();
        mortgage.displayMonthlyPayment();
        mortgage.displayPaymentSchedule();
    }
}
