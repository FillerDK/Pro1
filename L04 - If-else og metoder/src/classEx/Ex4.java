package classEx;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write 3 numbers: ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        order(num1, num2, num3);

    }

    public static void order(int num1, int num2, int num3) {
        if (num1 < num2 && num2 < num3) {
            System.out.println(num1 + " " + num2 + " " + num3 + " er voksende");
        } else if (num1 > num2 && num2 > num3) {
            System.out.println(num1 +  " " + num2 + " " + num3 + " er aftagende");
        } else if (num1 < num2 && num2 > num3) {
            System.out.println(num1 + " " + num2 + " " + num3 + " er hverken-eller");
        }
    }
}
