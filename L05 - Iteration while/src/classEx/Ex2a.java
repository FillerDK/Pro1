package classEx;

import java.util.Scanner;

public class Ex2a {
    public static void main(String[] args) {
        printPowersOfTwo();
    }

    public static void printPowersOfTwo() {
        int num1 = 1;
        int potensMax = 20;
        int potensMin = 0;
        int sum = num1;

        while (potensMin <= potensMax) {
            System.out.println("The sum of " + num1 + " to the power of 0 to " + num1 + " to the power of " + potensMin + " is " + sum + "\n");
            sum = sum * 2;
            potensMin++;
        }

    }
}
