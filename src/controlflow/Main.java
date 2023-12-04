package controlflow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 1;
        int y = 1;
        System.out.println(x == y); // Other comparison operators: !=  >  <  >=  <=

        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;

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
    }
}
