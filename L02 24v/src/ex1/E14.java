package ex1;

public class E14 {
    public static void main(String[] args) {
        double bal = 1000;
        double pipy = 1.05;
        int year = 0;
        System.out.println("year  balance");
        System.out.println(" " + year + "    " + bal);
        for (int i = 1; i <= 3; i++) {
            System.out.println(" " + i + "    " + bal * pipy);
            bal = bal * pipy;
        }
    }
}
