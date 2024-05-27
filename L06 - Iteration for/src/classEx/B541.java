package classEx;

import java.util.Scanner;

public class B541 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int bigNum = 0, bigNumX = 0;

        int num = 0;
        do {
            if (num == bigNum) {
                bigNumX++;
            } else if (num > bigNum) {
                bigNum = num;
                bigNumX = 1;
            }
            num = input.nextInt();
        } while (num != 0);

        System.out.println("Biggest number is " + bigNum);
        System.out.println("Biggest number was typed " + bigNumX + " times");
    }
}
