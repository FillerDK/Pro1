package ex2;

public class B16 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i < 10) {
                System.out.print(i + " + ");
            } else {
                System.out.println(i);
            }
            sum = sum + i;
        }
        System.out.println("Sum is equal to: " + sum);
    }
}
