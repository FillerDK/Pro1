package classEx;

import java.util.Scanner;

public class B317 {
    public static void main(String[] args) {
        int scissor = 0;
        int rock = 1;
        int paper = 2;
        String choice;
        String playAgain;

        doYouWantToPlay();

    }

    public static String computer (int computer) {
        if (computer == 0) {
            return "scissor";
        } else if (computer == 1) {
            return "rock";
        } else {
            return "paper";
        }
    }

    public static String player (int player) {
        if (player == 0) {
            return "scissor";
        } else if (player == 1) {
            return "rock";
        } else {
            return "paper";
        }
    }

    public static String result (int player, int computer) {
        if (player == computer) {
            return "It is a draw.";
        } else if (player > computer) {
            if (player == 2 && computer == 0) {
                return "You lost.";
            } else {
                return "You won.";
            }
        } else if (player == 0 && computer == 2) {
            return "You won.";
            } else {
            return "You lost";
        }
    }

    public static void doYouWantToPlay () {
        String answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to play? Y/N");
        answer = input.next();
        if (answer.equalsIgnoreCase("y")) {
            startGame();
        } else {
            endGame();
        }
    }

    public static void startGame () {
        Scanner input = new Scanner(System.in);
        int computer = (int) (Math.random() * (3));

        System.out.println("scissor (0), rock (1), paper (2): ");
        int player = input.nextInt();

        System.out.println("The computer is " + computer(computer) + ". You are " + player(player) + ". " + result(player, computer));
        System.out.println();

        wantToPlayAgain();
    }

    public static void wantToPlayAgain () {
        Scanner input = new Scanner(System.in);
        String playAgain;

        System.out.println("Do you want to play again? Y/N");
        playAgain = input.next();

        if (playAgain.equalsIgnoreCase("y")) {
            startGame();
        } else {
            endGame();
        }
    }

    public static void endGame () {
        System.out.println("See you soon.");
        System.out.println();
    }
}
