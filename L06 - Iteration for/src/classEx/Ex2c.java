package classEx;

import java.util.Scanner;

public class Ex2c {
    public static void main(String[] args) {
        System.out.print("Enter an integer for how many numbers you want to enter: ");
        Scanner input = new Scanner(System.in);
        int inputNumber = input.nextInt();

        int bigNum = 0, bigNumX = 0;

        System.out.print("Enter " + inputNumber + " numbers: ");
        for (int i = 0; i < inputNumber; i++) {
            int num = input.nextInt();
            if (num == bigNum) {
                bigNumX++;
            } else if (num > bigNum) {
                bigNum = num;
                bigNumX = 1;
            }
        }

        System.out.println("Biggest number is " + bigNum);
        System.out.println("Biggest number was typed " + bigNumX + " times");
    }
}
