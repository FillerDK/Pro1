package classEx;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();

        sign(number);

    }

    public static void sign(int number) {
        if (number < 0) {
            System.out.println("Negativ");
        } else if (number == 0) {
            System.out.println("0");
        } else {
            System.out.println("Positiv");
        }
    }
}
