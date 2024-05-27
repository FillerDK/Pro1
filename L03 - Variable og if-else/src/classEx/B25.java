package classEx;

import java.util.Scanner;

public class B25 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the subtotal and a gratuity rate: ");
        double subTotal = scan.nextDouble();
        double gratuityRate = scan.nextDouble();
        double gratuity = subTotal * (gratuityRate / 100);
        double total = subTotal + gratuity;

        // System.out.printf("The gratuity is %10d and total is %10d", gratuityRate, subTotal);
        System.out.println("The gratuity is $" + gratuity + " and total is $" + total);
    }
}
