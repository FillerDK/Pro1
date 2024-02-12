package classEx;

import java.util.Scanner;

public class Ex2a {
    public static void main(String[] args) {
        System.out.print("Enter an integer for how many numbers you want to enter: ");
        Scanner input = new Scanner(System.in);
        int inputNumber = input.nextInt();

        int bigNum = 0, even = 0, odd = 0;
        int smallNum = 999;

        System.out.print("Enter " + inputNumber + " numbers: ");
        for (int i = 0; i < inputNumber; i++) {
            int num = input.nextInt();
            if (num < smallNum) smallNum = num;
            if (num > bigNum) bigNum = num;
            if (num % 2 == 0) even++;
            if (num % 2 != 0) odd++;
        }

        System.out.println("Min er " + smallNum);
        System.out.println("Max er " + bigNum);
        System.out.println("Lige er " + even);
        System.out.println("Ulige er " + odd);
    }
}
