package inheritance;

public class TaxCalculator2024 extends AbstractTaxCalculator {
    private double taxableIncome;

    public TaxCalculator2024(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax() {
//        getTaxableIncome() method is available here because this implementation extends AbstractTaxCalculator
        return taxableIncome * 0.3;
    }
}
