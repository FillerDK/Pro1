package classEx;

import java.util.Scanner;

public class Ex2b {
    public static void main(String[] args) {
        System.out.print("Enter an integer for how many numbers you want to enter: ");
        Scanner input = new Scanner(System.in);
        int inputNumber = input.nextInt();

        int sum = 0;
        System.out.print("Enter " + inputNumber + " numbers: ");
        for (int i = 0; i < inputNumber; i++) {
            int num = input.nextInt();
            System.out.print((sum = sum + num) + " ");
        }
    }
}
