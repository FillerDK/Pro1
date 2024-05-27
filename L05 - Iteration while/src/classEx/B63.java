package classEx;

import java.util.Scanner;

public class B63 {
    public static void main(String[] args) {
        System.out.print("Write a number between 10 and 999: ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int length = String.valueOf(number).length();
        String str2 = String.format("%02d", reverse(number));
        String str3 = String.format("%03d", reverse(number));

        if (number >= 10 && number <= 999) {
            if (length == 2) {
                if (isPalindrome(number)) {
                    System.out.printf("The reverse of %d is: %s and is a palindrome.", number, str2);
                } else {
                    System.out.printf("The reverse of %d is: %s.", number, str2);
                }
            } else {
                if (isPalindrome(number)) {
                    System.out.printf("The reverse of %d is: %s and is a palindrome.", number, str3);
                } else {
                    System.out.printf("The reverse of %d is: %s.", number, str3);
                }
            }
        } else {
            System.out.println("Number not legal, try again.");
        }
    }

    // Return the reversal of an integer, e.g., reverse(456) returns 654
    public static int reverse(int number) {

        int digit1 = number % 10;
        int digit2 = number / 10 % 10;
        int digit3 = number / 100 % 10;
        int reverse = 0;
        int length = String.valueOf(number).length();

        if (length == 2) {
            return reverse = digit1 * 10 + digit2;
        } else {
            return reverse = (digit1 * 10 + digit2) * 10 + digit3;
        }
    }

    // Return true if number is a palindrome
    public static boolean isPalindrome(int number) {
        if (number == reverse(number)) {
            return true;
        } else {
            return false;
        }
    }
}
