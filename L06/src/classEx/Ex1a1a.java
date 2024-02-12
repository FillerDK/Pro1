package classEx;

public class Ex1a1a {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 2; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.println("Sum is " + sum);
    }
}
