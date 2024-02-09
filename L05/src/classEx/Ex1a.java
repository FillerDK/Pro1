package classEx;

public class Ex1a {
    public static void main(String[] args) {
        int i = 2;
        int sum = 0;

        while (i <= 100) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
            i++;
        }

        System.out.println("Sum is " + sum);
    }
}
