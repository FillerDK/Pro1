package classEx;

import com.sun.source.doctree.SummaryTree;

public class Ex2c {
    public static void main(String[] args) {
        System.out.println("Resultatet af sumOddDigits(1_234_567) er " + sumOddDigits(1234567));
    }

    public static int sumOddDigits (int number) {
        //while ( < ) {

        //}
        int sum = 1234567;
        int i = 1;
        int num = 0;

        while (i <= 1) {

            if (sum % 2 == 0) {
            }
            sum = sum / 10;
            i++;
        }

        return sum;
    }
}
