package literatur.chapter3;

import java.util.Scanner;

public class B332 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double score = sc.nextDouble();
        double pay = 100;
        double payPercent = 1.03;

        if (score > 90) {
            pay = pay * payPercent;
        }
        System.out.println(pay);
    }
}
