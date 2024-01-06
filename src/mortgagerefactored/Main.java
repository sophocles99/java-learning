package mortgagerefactored;

public class Main {
    public static void main(String[] args){
        int principal = (int) NumberInput.getNumberInput("Please enter the principal of the loan", 1000, 1000_000);
        System.out.println(principal);
    }
}
