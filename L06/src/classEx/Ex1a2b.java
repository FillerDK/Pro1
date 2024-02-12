package classEx;

public class Ex1a2b {
    public static void main(String[] args) {
        System.out.println("Resultatet af sumEvenints(7, 25) er " + sumEvenints(7, 25));
    }

    public static int sumEvenints (int lower, int upper) {
        int sum;
        for (sum = 0; lower < upper; lower++) {
            if (lower % 2 == 0) {
                sum += lower;
            }
        }
        return sum;
    }
}
