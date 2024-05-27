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

        System.out.print("Write loan amount in $: ");
        double loanAmount = scan.nextDouble();

        System.out.print("Write number of years: ");
        int numberOfYears = scan.nextInt();

        System.out.print("Write annual interest rate in %: ");
        double annualInterestRate = scan.nextDouble() / 100;

        double monthlyPayment = calcMonthlyPayment(annualInterestRate, numberOfYears, loanAmount);

        System.out.println("Monthly payment: $" + (int)(monthlyPayment * 100) / 100.0);

        double totalPayment = monthlyPayment * (numberOfYears * 12);

        System.out.println("Total payment: $" + (int)(totalPayment * 100) / 100.0);
    }

    public static double calcMonthlyPayment (double annualInterestRate, int numberOfYears, double loanAmount) {
        double interestRatePrMonth = annualInterestRate / 12;
        double denumerator = 1-1 / Math.pow((1 + interestRatePrMonth), (numberOfYears * 12));
        double monthlyPayment = (loanAmount * interestRatePrMonth) / denumerator;
        return monthlyPayment;
    }
}
