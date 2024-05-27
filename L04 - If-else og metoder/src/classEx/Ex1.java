package classEx;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();

        if (number < 0) {
            System.out.println("Negativ");
        } else if (number == 0) {
            System.out.println("0");
        } else {
            System.out.println("Positiv");
        }
    }
}
