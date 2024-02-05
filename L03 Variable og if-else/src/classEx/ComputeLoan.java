package classEx;

import java.util.Scanner;

public class ComputeLoan {
    public static void main(String[] args) {
        // Algorithm:
        // Prompt user for loan amount
        // Read loan amount
        // Prompt user for annual interest rate
        // Read annual interest rate
        // Calculate interest rate per month
        // Prompt user for number of years
        // Read number of years
        // Calculate denumerator
        // Calculate monthly payment
        // Calculate total payment
        // Print monthly payment
        // Print total payment

        Scanner scan = new Scanner(System.in);

        System.out.print("Write loan amount: ");
        double loanAmount = scan.nextDouble();
        System.out.print("Write interest rate: ");
        double annualInterestRate = scan.nextDouble() / 100;
        double interestRatePrMonth = annualInterestRate / 12;
        System.out.print("Write number of years: ");
        double numberOfYears = scan.nextDouble();
        double denumerator = 1-1 / Math.pow((1 + interestRatePrMonth), (numberOfYears * 12));

        double monthlyPayment = (loanAmount * interestRatePrMonth) / denumerator;
        double totalPayment = monthlyPayment * (numberOfYears * 12);

        System.out.println("Monthly payment: " + monthlyPayment);
        System.out.println("Total payment: " + totalPayment);
    }
}
