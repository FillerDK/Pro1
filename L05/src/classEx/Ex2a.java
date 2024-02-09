package classEx;

import java.util.Scanner;

public class Ex2a {
    public static void main(String[] args) {
        printPowersOfTwo();
    }
 // needs work !!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static void printPowersOfTwo() {
        Scanner input = new Scanner(System.in);

        System.out.println("Write two numbers you want to" +
                " put to the power of eachother: ");
        int num1 = input.nextInt();
        int potensMax = input.nextInt();
        int potens1 = 0;
        int sum = num1;

        while (potens1 <= potensMax) {
            System.out.println(sum);
            sum = sum * 2;
            potens1++;
        }

        System.out.println("The sum of " + num1 + " to the power of 0 to " + num1 + " to the power of " + potensMax + " is " + sum);
    }
}
