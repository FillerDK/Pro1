package craps;

import java.util.Scanner;

public class Player {
    private Die die;
    private Die die2;
    private int sum;
    private int points;
    private boolean finished;
    private boolean firstThrow = true;

    public Player() {
        this.die = new Die();
        this.die2 = new Die();
    }

    public void throwDice() {
        die.roll();
        die2.roll();
        sum = die.getFaceValue() + die2.getFaceValue();
    }

    public int getSum() {
        return sum;
    }

    public void didIWin() {
        if (firstThrow) {
            if (sum == 7 || sum == 11) {
                System.out.println("YOU WON AT FIRST TRY!");
                finished = true;
            } else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("YOU LOST AT FIRST TRY!");
                finished = true;
            } else {
                points = sum;
                firstThrow = false;
                System.out.println("Your points are now set to: " + points);
                System.out.println("\nTry again!");
            }
        } else if (points == sum) {
            System.out.println("YOU WIN!");
            finished = true;
        } else if (sum == 7) {
            System.out.println("YOU LOST!");
            finished = true;
        } else System.out.println("\nTry again!");
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ready to roll?");
        scanner.nextLine();
        finished = false;
        while (!finished) {
            throwDice();
            System.out.println("Rolling dice ʕ•́ᴥ•̀ʔっ ~ \uD83C\uDFB2\uD83C\uDFB2");
            System.out.printf("The sum of dice is: %d\n", sum);
            didIWin();
            if (!finished) {
                String again = scanner.nextLine();
            }
        }
    }
}
