package ex2;

public class B14 {
    public static void main(String[] args) {
        int a = 1;
        System.out.println("aa^2a^3a^4a");
        for (int i = 1; i <= 4; i++) {
            System.out.println(a + " " + Math.pow(a, 2) + " " + Math.pow(a, 3) + " " + Math.pow(a, 4));
            a++;
        }
    }
}
