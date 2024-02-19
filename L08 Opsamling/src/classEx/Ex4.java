package classEx;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        // max = 40 stjerner
        // 1 = 40/max stjerner
        // tal = 40/max * tal stjerner

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5];
        String[] countries = new String[5];
        int max = 0;

        System.out.print("Enter 5 countries: ");
        for (int i = 0; i < countries.length; i++) {
            countries[i] = input.next();
        }

        System.out.print("Enter 5 numbers: ");
        for (int i = 0; i < countries.length; i++) {
            numbers[i] = input.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            int starlength = (int)(40.0 * numbers[i] / max);
            printNames(countries[i], longestName(countries), i);
            for (int j = 0; j < starlength; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static int longestName (String[] name) {
        int longestName = 0;
        for (int i = 0; i < name.length; i++) {
            if (name[i].length() > longestName) {
                longestName = name[i].length();
            }
        }
        return longestName;
    }

    public static void printNames (String name, int longestName, int i) {
        int spaces = longestName - name.length();
        for (i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.print(name + " ");
    }
}
