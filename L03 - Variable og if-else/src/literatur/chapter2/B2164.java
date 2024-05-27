package literatur.chapter2;

import java.util.Scanner;

public class B2164 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter pruchase amount: ");
        double purchaseAmount = input.nextDouble();
        //Input: 197,556

        double tax = purchaseAmount * 0.06;
        System.out.println("Sales tax is $" + (int)(tax * 100) / 100);
    }
}
