package ex2;

public class B110 {
    public static void main(String[] args) {
        int km = 15;
        int min = 50;
        int sec = 30;
        System.out.println(km * (3600.0 / (min * 60 + sec)) / 1.6);
    }
}
