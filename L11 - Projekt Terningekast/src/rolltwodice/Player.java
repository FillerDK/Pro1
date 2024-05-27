package rolltwodice;

import java.util.Scanner;

public class Player {
    private Die die;
    private Die die2;
    private int throwCount;
    private int sum;
    private int maxSum;
    private int sameFaceValue;
    private int[] faceValueCount = new int[7];

    public Player() {
        this.die = new Die();
        this.die2 = new Die();
    }

    public int getThrowCount() {
        return throwCount;
    }

    public void throwDice() {
        die.roll();
        die2.roll();
        throwCount++;
        setTotalSum();
        sameFaceValue();
        setMaxSum();
        setFaceValueCount();
    }

    public void setTotalSum() {
        sum += (die.getFaceValue() + die2.getFaceValue());
    }

    public int getTotalSum() {
        return sum;
    }

    public void sameFaceValue() {
        if (die.getFaceValue() == die2.getFaceValue()) sameFaceValue++;
    }

    public int getSameFaceValue() {
        return sameFaceValue;
    }

    public void setMaxSum() {
        if (die.getFaceValue() + die2.getFaceValue() > maxSum)
            maxSum = die.getFaceValue() + die2.getFaceValue();
    }

    public int getMaxSum() {
        return maxSum;
    }

    public void setFaceValueCount() {
        faceValueCount[die.getFaceValue()]++;
        faceValueCount[die2.getFaceValue()]++;
    }

    public void printFaceValueCount() {
        System.out.println("Face value:   1, 2, 3, 4, 5, 6");
        System.out.println("------------------------------");
        System.out.print("Times rolled:");
        for (int i = 1; i < faceValueCount.length - 1; i++) {
            System.out.printf("%2d,", faceValueCount[i]);
        }
        System.out.println(" " + faceValueCount[6]);
    }

    public double getAverageSumOfThrows() {
        double averageSumOfThrows = (double) sum / throwCount;
        return averageSumOfThrows;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll?");
        scanner.nextLine();
        boolean finished = false;
        while (!finished) {
            throwDice();
            System.out.printf("Rolling... die 1: %d\n", die.getFaceValue());
            System.out.printf("Rolling... die 2: %d\n", die2.getFaceValue());
            System.out.printf("The total sum of dice is: %d\n", sum);
            System.out.println("Roll again? (Y/n)");
            String again = scanner.nextLine();
            if (again.toLowerCase().equals("n")) {
                finished = true;
            }
        }
    }
}
