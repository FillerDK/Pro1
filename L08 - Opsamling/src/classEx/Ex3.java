package classEx;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        // max = 40 stjerner
        // 1 = 40/max stjerner
        // tal = 40/max * tal stjerner

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5];
        int max = 0;

        System.out.print("Enter 5 numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            int starlength = (int)(40.0 * numbers[i] / max);
            for (int j = 0; j < starlength; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
