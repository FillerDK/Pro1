package classEx;

import java.util.Scanner;

public class B35 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an integer for today's day of the week (Sunday = 0, Monday = 1...): ");
        int day = scan.nextInt();

        System.out.println("Enter the number of days elapsed since today: ");
        int daysElapsed = scan.nextInt();

        System.out.println("Today is " + day(day) + " and the future day is " + daysElapsed(day, daysElapsed));
    }

    public static String day (int day) {
        if (day == 0) {
            return "Sunday";
        } else if (day == 1) {
            return "Monday";
        } else if (day == 2) {
            return "Tuesday";
        } else if (day == 3) {
            return "Wednesday";
        } else if (day == 4) {
            return "Thursday";
        } else if (day == 5) {
            return "Friday";
        } else {
            return "Saturday";
        }
    }

    public static String daysElapsed (int day, int daysElapsed) {
        int dayInNumber = (day + daysElapsed) % 7;

        if (dayInNumber == 0) {
            return "Sunday";
        } else if (dayInNumber == 1) {
            return "Monday";
        } else if (dayInNumber == 2) {
            return "Tuesday";
        } else if (dayInNumber == 3) {
            return "Wednesday";
        } else if (dayInNumber == 4) {
            return "Thursday";
        } else if (dayInNumber == 5) {
            return "Friday";
        } else {
            return "Saturday";
        }
    }
}
