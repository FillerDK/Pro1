package ex2;

public class B111 {
    public static void main(String[] args) {
        int birth = 7;
        int death = 13;
        int immigrant = 45;
        int popu = 312_032_486;
        int yDays = 365;
        int secYear = 60 * 60 * 24 * 365;
        int birthYear = secYear / 7;
        System.out.println("year   population");
        for (int i = 1; i <= 5; i++) {
            popu = popu + birthYear;
            System.out.println(" " + i + "  " + popu);
        }
        System.out.println("Births per year: " + birthYear);
        System.out.println("Hi");
    }
}
