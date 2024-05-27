package classEx;

public class Ex2b {
    public static void main(String[] args) {
        System.out.println("Resultatet af sumEvenints(7, 25) er " + sumEvenints(7, 25));
    }

    public static int sumEvenints (int lower, int upper) {
        int sum = 0;
        while (lower < upper) {
            if (lower % 2 == 0) {
                sum = sum + lower;
            }
            lower++;
        }
        return sum;
    }
}
