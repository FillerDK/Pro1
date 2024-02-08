package classEx;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class B317 {
    public static void main(String[] args) {
        int scissor = 0;
        int rock = 1;
        int paper = 2;
        String choice;

        int computer = (int) (Math.random() * (3));

        Scanner input = new Scanner(System.in);

        System.out.println("scissor (0), rock (1), paper (2): ");
        int player = input.nextInt();

        if (player == 0) {
            choice = "scissor";
        }
    }

    public static String player (int player) {
        if (player == 0) {
            return "scissor";
        } else {
            return "you lost";
        }
    }
}
