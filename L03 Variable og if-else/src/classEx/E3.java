package classEx;

import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        // Algorithm:
        // Prompt user for 3 integers
        // Read 3 integers
        // ???
        // Print 3 integers in ascending order

        Scanner scan = new Scanner(System.in);

        System.out.print("Write 3 integers: ");
        int integer1 = scan.nextInt();
        int integer2 = scan.nextInt();
        int integer3 = scan.nextInt();

        if (integer1 < integer2 && integer2 < integer3) {
            System.out.println(integer1 + " " + integer2 + " " + integer3);
        } else if (integer1 < integer3 && integer3 < integer2) {
            System.out.println(integer1 + " " + integer3 + " " + integer2);
        } else if (integer2 < integer1 && integer1 < integer3) {
            System.out.println(integer2 + " " + integer1 + " " + integer3);
        } else if (integer2 < integer3 && integer3 < integer1) {
            System.out.println(integer2 + " " + integer3 + " " + integer1);
        } else if (integer3 < integer1 && integer1 < integer2) {
            System.out.println(integer3 + " " + integer1 + " " + integer2);
        } else if (integer3 < integer2 && integer2 < integer1) {
            System.out.println(integer3 + " " + integer2 + " " + integer1);
        }
    }
}
