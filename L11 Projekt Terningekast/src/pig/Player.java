package pig;

import java.util.Scanner;
import pig.PigGame;

public class Player {
    private Die die;
    private String name;
    private int roundSum;
    private int totalSum;
    private boolean winnerFound;

    public Player() {
        this.die = new Die();
        this.name = name;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setPlayerName(int newName) {
        Scanner name = new Scanner(System.in);
        System.out.println("Enter name for player " + newName + ": ");
        String playerName = name.nextLine();
        this.name = playerName;
    }

    public String getPlayerName() {
        return name;
    }

    public boolean isWinnerFound() {
        return winnerFound;
    }

    public void throwDice() {
        die.roll();
        System.out.println("Rolling dice ʕ•́ᴥ•̀ʔっ ~ \uD83C\uDFB2");
        System.out.println("You rolled: " + die.getFaceValue());
        if (die.getFaceValue() != 1) {
            roundSum += die.getFaceValue();
            System.out.println("Your points for this round is: " + roundSum);
            System.out.println("Roll again? Press enter to roll, \"n\" to stop turn.");
        } else {
            roundSum = 0;
            System.out.printf("↳ Your current score is: %d/100", totalSum);
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ready to roll %s?\n", name);
        System.out.printf("↳ Your current score is: %d/100\n", totalSum);
        scanner.nextLine();
        boolean finished = false;
        while (!finished) {
            throwDice();
            String again = scanner.nextLine();
            if (again.toLowerCase().equals("n")) {
                totalSum += roundSum;
                roundSum = 0;
                if (totalSum >= 100) {
                    System.out.printf("↳ Your current score is: %d/100\n\n", totalSum);
                    winnerFound = true;
                } else {
                    System.out.printf("↳ Your current score is: %d/100\n\n", totalSum);
                }
                finished = true;
            } else if (die.getFaceValue() == 1) finished = true;
        }
    }
}