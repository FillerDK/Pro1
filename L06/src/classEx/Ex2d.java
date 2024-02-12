package classEx;

import java.util.Scanner;

public class Ex2d {
    public static void main(String[] args) {
        System.out.print("Enter an integer for how many numbers you want to enter: ");
        Scanner input = new Scanner(System.in);
        int inputNumber = input.nextInt();

        int prevNum = 0;
        int printNum = 0;

        System.out.print("Enter " + inputNumber + " numbers: ");
        for (int i = 1; i <= inputNumber; i++) {
            int newNum = input.nextInt();
            if (newNum == prevNum) {
                if (newNum != printNum) {
                    System.out.print(newNum + " ");
                    printNum = prevNum;
                }
            }
            prevNum = newNum;
        }
    }
}
