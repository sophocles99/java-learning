package inheritance;

public class TaxReport {
    private TaxCalculator2024 calculator;

    public TaxReport() {
        calculator = new TaxCalculator2024(100_000);
    }

    public void show() {
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }
}
