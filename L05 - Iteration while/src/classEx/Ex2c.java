package classEx;

import com.sun.source.doctree.SummaryTree;

public class Ex2c {
    public static void main(String[] args) {
        System.out.println("Resultatet af sumOddDigits(1_234_567) er " + sumOddDigits(1234567));
    }

    public static int sumOddDigits (int number) {
        int i = 1;
        int sum = 0;
        while (i <= 7) {
            int digit = number % 10;
            if (digit % 2 == 1) {
                sum = sum + digit;
            }
            number /= 10;
            i++;
        }
        return sum;
    }
}
