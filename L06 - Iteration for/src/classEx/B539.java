package classEx;

import java.util.Scanner;

public class B539 {
    public static void main(String[] args) {
        double salesAmount = 1000;

        // 1000, 2000, 3000,..., 20000 sales amount
        // commision rate 0.01-5000 = 6%, 5000-10000 = 8%, 10000.01 and above = 10%

        System.out.println("Sales Amount     Commission");

        int i = 1;

        do {
            System.out.printf("%-17.2f%.2f", salesAmount, computeCommission(salesAmount));
            System.out.println();
            salesAmount = salesAmount + 1000;
            i++;
        } while (i <= 25);
    }

    public static double computeCommission(double salesAmount) {
        double commission;
        if (salesAmount > 0.01 && salesAmount <= 5000) {
            return commission = salesAmount * 0.06;
        } else if (salesAmount <= 10000) {
            return commission = 5000 * 0.06 + (salesAmount - 5000) * 0.08;
        } else {
            return commission = 5000 * 0.06 + 5000 * 0.08 + (salesAmount - 10000) * 0.10;
        }
    }
}
