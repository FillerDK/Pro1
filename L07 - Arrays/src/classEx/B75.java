package classEx;

import java.util.Scanner;

public class B75 {
    public static void main(String[] args) {
        System.out.print("Enter numbers: ");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
        int evenNums = 0;
        int oddNums = 0;

        while (userInput != 0) {
            if (userInput % 2 == 0) evenNums++;
            else oddNums++;
            userInput = input.nextInt();
        }

        System.out.println("The number of odd numbers: " + oddNums);
        System.out.println("The number of even numbers: " + evenNums);
    }
}
