package classEx;

import java.util.Scanner;

public class B73 {
    public static void main(String[] args) {
        System.out.print("Enter a number from 1 to 49: ");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        int[] occurs = new int[50];

        while (userInput != 0) {
            if (userInput < 1 || userInput > 49) {
                System.out.println("The input is not valid.");
            }
            occurs[userInput] += 1;
            userInput = input.nextInt();
        }
        for (int i = 0; i < occurs.length; i++) {
            if (occurs[i] != 0) {
                System.out.println(i + " occurs " + occurs[i] + " times");
            }
        }
    }
}
