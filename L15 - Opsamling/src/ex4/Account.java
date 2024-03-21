package ex4;

import java.time.LocalDate;

public class Account {
    private int id;
    private double balance;
    private static double annualInterestRate = 0;
    private LocalDate dateCreated;

    public Account() {
        id = 0;
        balance = 0;
        dateCreated = LocalDate.now();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterest() {
        double monthlyInterest = balance * getMonthlyInterestRate();
        return monthlyInterest;
    }

    public double getMonthlyInterestRate() {
        double monthlyInterestRate = (annualInterestRate / 12) / 100;
        return monthlyInterestRate;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " have been withdrawn from your account.");
            System.out.println("Your balance is now: " + balance);
        } else System.out.println("Error, are you out of your mind, that is too much money!");
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.printf("%.2f have been deposited, you now have %.2f in your account.\n", amount, balance);
    }
}
