package classEx;

public class Ex1a2a {
    public static void main(String[] args) {
        printPowersOfTwo();
    }

    public static void printPowersOfTwo() {
        int num1 = 1;
        int potensMax = 20;
        int sum = num1;

        for (int potensMin = 0; potensMin <= potensMax; potensMin++) {
            System.out.println("2^" + potensMin + " = " + sum);
            sum = sum * 2;
        }
    }
}
