package classEx;

import java.util.Scanner;

public class B26 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number between 0 and 1000: ");
        int integer = scan.nextInt();

        if (integer >= 0 && integer <= 1000) {
            if (integer % 10 == 0) {
                integer = integer / 10;
                int newInt = integer % 10;
                int sum = newInt + (integer - newInt) / 10;
                System.out.println(sum);
            } else {
                int integer1 = integer % 10;
                int integer2 = integer / 10 % 10;
                int integer3 = integer / 10 / 10 % 10;

                int sum = integer1 + integer2 + integer3;
                System.out.println("The sum of the digits is: " + sum);
            }
        }
    }
}
