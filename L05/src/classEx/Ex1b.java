package classEx;

import java.util.Scanner;

public class Ex1b {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        int limit = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Write an integer: ");
        limit = input.nextInt();

        while (i <= Math.sqrt(limit)) {
            if (i <= Math.sqrt(limit)) {
                sum = sum + (int)(Math.pow(i, 2));
            }
            i++;
        }

        System.out.println("Sum is " + sum);
    }
}
