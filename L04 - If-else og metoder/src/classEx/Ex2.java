package classEx;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        if (num1 < num2 && num2 < num3) {
            System.out.println(num1 + " " + num2 + " " + num3 + " er voksende");
        } else if (num1 > num2 && num2 > num3) {
            System.out.println(num1 +  " " + num2 + " " + num3 + " er aftagende");
        } else if (num1 < num2 && num2 > num3) {
            System.out.println(num1 + " " + num2 + " " + num3 + " er hverken-eller");
        }
    }
}
