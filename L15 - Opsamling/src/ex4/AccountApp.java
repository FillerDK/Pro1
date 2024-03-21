package ex4;

import java.util.Scanner;

public class AccountApp {
    public static void main(String[] args) {
        Account[] accounts = new Account[10];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }

        boolean finished = false;
        while (!finished) {
            System.out.print("Enter a user id (0-9): ");
            Scanner input = new Scanner(System.in);
            int id = input.nextInt();
            input.nextLine();
            if (0 > id || id > 9) {
                System.out.print("id out of bound, enter a new id: ");
            } else {
                boolean running = true;
                while (running) {
                    System.out.println("\n         *** Main menu ***");
                    System.out.println("----------------------------------");
                    System.out.println("1) View balance");
                    System.out.println("2) Withdraw money");
                    System.out.println("3) Deposit money");
                    System.out.println("4) Exit main menu");
                    System.out.println("----------------------------------");
                    System.out.print("Enter number to select an action: ");
                    int option = input.nextInt();
                    if (option < 1 || option > 4) {
                        System.out.print("Enter a valid number (1-4): ");
                        option = input.nextInt();
                        input.nextLine();
                    } else if (option == 1) {
                        System.out.println("Your balance is: " + accounts[id].getBalance());
                    } else if (option == 2) {
                        System.out.print("Enter amount you want to withdraw: ");
                        int amount = input.nextInt();
                        accounts[id].withdraw(amount);
                    } else if (option == 3) {
                        System.out.print("Enter amount you want to deposit: ");
                        int amount = input.nextInt();
                        accounts[id].deposit(amount);
                    } else {
                        System.out.println("Exiting main menu...\n");
                        running = false;
                    }
                }
            }
        }
    }
}
