package literatur.chapter3;

import java.util.Scanner;

public class B331 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = 0;
        int y = sc.nextInt();

        if (y > 0) {
            x = 1;
        }
        System.out.println(x);
    }
}
