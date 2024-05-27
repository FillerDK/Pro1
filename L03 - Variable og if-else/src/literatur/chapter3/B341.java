package literatur.chapter3;

import java.util.Scanner;

public class B341 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double score = sc.nextDouble();
        double pay = 100;

        if (score > 90) {
            pay = pay * 1.03;
        } else {
            pay = pay * 1.01;
        }
        System.out.println(pay);
    }
}
