package classEx;

import java.util.Scanner;

public class B541 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int bigNum = 0, bigNumX = 0;

        int num = 0;
        do {
            num = input.nextInt();
            if (num == bigNum) {
                bigNumX++;
            } else if (num > bigNum) {
                bigNum = num;
                bigNumX = 1;
            }
        } while (num != 0);

        System.out.println("Biggest number is " + bigNum);
        System.out.println("Biggest number was typed " + bigNumX + " times");
    }
}
