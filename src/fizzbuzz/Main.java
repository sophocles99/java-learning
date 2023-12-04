package fizzbuzz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        int number = scanner.nextInt();

        String result = (number % 3 == 0) ? "Fizz" : "";
        result += (number % 5 == 0) ? "Buzz" : "";
        result += result.isEmpty() ? Integer.toString(number) : "";

        System.out.println(result);
    }
}
