package literatur;

import java.util.Scanner;

public class B370 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);

        if (number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }

        System.out.println("What is " + number1 + " - " + number2 + "?");
        int answer = scan.nextInt();

        if (answer == (number1 - number2)) {
            System.out.println("Yay, correct answer!");
        } else {
            System.out.println("Wrong answer! " + number1 + " - " + number2 + " is " + (number1 - number2));
        }
    }
}
