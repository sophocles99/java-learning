package controlflow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Comparison and logical operators
        int x = 1;
        int y = 1;
        System.out.println(x == y); // Other comparison operators: !=  >  <  >=  <=

        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;

        // Switch example
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your role: ");
        String role = scanner.next();

        switch (role) {
            case "admin":
                System.out.println("You are an admin");
                break;
            case "moderator":
                System.out.println("You are a moderator");
                break;
            default:
                System.out.println("You are a guest");
        }

        // for loop
        for (int i = 0; i < 10; i++)
            System.out.println((i + 1) + ". Java is the future..?");

        // while loop
        String input = "";
        while (true) {
            System.out.print("Enter something: ");
            input = scanner.next().toLowerCase();
            if (input.equals("quit")) break;
            System.out.println("You entered: " + input);
        }

        // for each loop
        String[] vehicles = {"car", "bus", "aeroplane", "ferry"};
        for (String vehicle : vehicles)
            System.out.println(vehicle);
    }
}
