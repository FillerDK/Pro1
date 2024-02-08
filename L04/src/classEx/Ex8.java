package classEx;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write a month and a day: ");
        int month = scan.nextInt();
        int day = scan.nextInt();

        System.out.println(season(month, day));
    }

    public static String season (int month, int day) {
        String season;

        if (month <= 2 || month == 12) {
            if (month == 2 && day >= 21) {
                season = "Spring";
            } else {
                season = "Winter";
            }
        } else if (month <= 5) {
            if (month == 5 && day >= 21) {
                season = "Summer";
            } else {
                season = "Spring";
            }
        } else if (month <= 8) {
            if (month == 8 && day >= 21) {
                season = "Autumn";
            } else {
                season = "Summer";
            }
        } else {
            season = "Autumn";
        }

        return season = "winter";
    }
}
