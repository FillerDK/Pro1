package classEx;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int min = 10;
        int max = 99;
        int lotteryNumber = (int)(Math.random() * (max - min + 1) + min);
        int reverseLotteryNumber = (lotteryNumber % 10) * 10 + (lotteryNumber / 10);
        int lotteryNumber1 = lotteryNumber / 10;
        int lotteryNumber2 = lotteryNumber % 10;

        System.out.print("Guess the lottery number between 10 and 99: ");
        int guess = scan.nextInt();
        int guessDigit1 = guess / 10;
        int guessDigit2 = guess % 10;

        System.out.println(lotteryNumber);
        System.out.println(lotteryNumber1);
        System.out.println(lotteryNumber2);
        if (guess == lotteryNumber) {
            System.out.println("YOU WIN $10.000");
        } else if (guess == reverseLotteryNumber) {
            System.out.println("YOU WIN $3.000");
        } else if (guessDigit1 == lotteryNumber1 || guessDigit1 == lotteryNumber2) {
            System.out.println("YOU WIN $1.000");
        } else if (guessDigit2 == lotteryNumber1 || guessDigit2 == lotteryNumber2) {
            System.out.println("YOU WIN $ 1.000");
        } else {
            System.out.println("SORRY, YOU LOOSE");
        }
    }
}
