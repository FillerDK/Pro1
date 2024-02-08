package classEx;

import java.util.Scanner;

public class SalesTax {
    public static void main(String[] args) {
        // Algorithm:
        // Write purchase amount
        // Read purchase amount
        // Read tax amount
        // Calculate sales tax (6%)
        // Print sales tax (6%)

        System.out.print("Write purchase amount: ");
        Scanner scan = new Scanner(System.in);

        double purchaseAmount = scan.nextDouble();

        System.out.print("Write tax amount: ");
        double tax = scan.nextDouble() / 100;
        double salesTax = purchaseAmount * tax;

        System.out.println("Tax: $" + (int)(salesTax * 100) / 100.0);
    }
}
