package classes;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        var employee = new Employee(50_000, 20);
        int wage = employee.calculateWage();
        System.out.println(wage);
    }
}
