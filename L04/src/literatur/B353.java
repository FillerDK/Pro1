package literatur;

import java.util.Scanner;

public class B353 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int score = scan.nextInt();

        // wrong code, anything aboe 60 = D, otherwise it is F
        if (score >= 60) {
            System.out.println("D");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 90) {
            System.out.println("A");
        } else {
            System.out.println("F");
        }

        // correct code, correct grades and scores from high to low
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
