package ex2;

public class B112 {
    public static void main(String[] args) {
        int milesRan = 24;
        int hoursRan = 1;
        int minutesRan = hoursRan * 60 + 40;
        int secondsRan = minutesRan * 60 + 35;
        double mileToKm = 1.6;

        //(milesRan * mileToKm) / (secondsRan / 3600.0)
        System.out.println((milesRan * mileToKm) / (secondsRan / 3600.0));
    }
}
