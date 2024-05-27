package classEx;

import javax.print.attribute.SetOfIntegerSyntax;
import java.util.Arrays;
import java.util.Scanner;

public class B67 {
    public static void main(String[] args) {
        System.out.print("Enter investment amount: ");
        Scanner input = new Scanner(System.in);
        double investmentAmount = input.nextDouble();

        System.out.print("Enter annual interest rate in percentage: ");
        double annualInterestrate = input.nextDouble() / 100;
        double monthlyInterestrate = annualInterestrate / 12;

        System.out.print("Enter number of years: ");
        int years = input.nextInt();

        System.out.println();
        System.out.println("Years    Future Value($)");

        int i = 1;
        while (i <= years) {
            System.out.printf(" %-9d%11.2f\n", i, futureInvestmentValue(investmentAmount, monthlyInterestrate, years));
            investmentAmount = futureInvestmentValue(investmentAmount, monthlyInterestrate, years);
            i++;
        }
    }

    public static double futureInvestmentValue (double investmentAmount, double monthlyInterestrate,  int years) {
        years = 1;
        double newValue = investmentAmount * Math.pow(1 + monthlyInterestrate, years * 12);

        return newValue;
    }
}
