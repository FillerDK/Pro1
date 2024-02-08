package classEx;

import java.sql.SQLOutput;
import java.util.Scanner;

public class B31 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a, b, c: ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        printSolution(a, b, c);
    }

    public static void printSolution (double a, double b, double c) {
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        double r1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double r2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        if (discriminant < 0) {
            System.out.println("The equation has no real roots.");
        } else if (discriminant == 0) {
            System.out.println("The equation has one root: " + r1);
        } else if (discriminant > 0) {
            System.out.println("The equation has two roots: " + r1 + " and " + r2);
        }
    }
}
