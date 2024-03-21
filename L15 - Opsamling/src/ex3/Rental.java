package ex3;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Rental {
    private int number; // the number of rented units
    private int days; // the number of days of the rental
    private LocalDate startDate; // the start date of the rental
    private double price; // the price for one day of rental

    public Rental(int number, int days, LocalDate startDate, double price) {
        this.number = number;
        this.days = days;
        this.startDate = startDate;
        this.price = price;
    }

    public double getPricePrDay() {
        return price;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        LocalDate endDate = startDate.plusDays(days);
        return endDate;
    }

    public double getTotalPrice() {
        double totalPrice = price * days;
        return totalPrice;
    }

    //@Override
    public String toString() {
        return String.format("Rental (number of units: %d, rent days: %d, start date: %s, the price per day is: %.2f)", number, days, getStartDate(), price);
    }

    public boolean dateOrder(Rental rental) {
        return this.startDate.isBefore(rental.startDate);
    }

    public long getYearsBetween(Rental rental) {
        return (dateOrder(rental)) ? ChronoUnit.YEARS.between(this.startDate, rental.startDate) : ChronoUnit.YEARS.between(rental.startDate, this.startDate);
    }

    public long getMonthsBetween(Rental rental) {
        return (dateOrder(rental)) ? ChronoUnit.MONTHS.between(this.startDate, rental.startDate) : ChronoUnit.MONTHS.between(rental.startDate, this.startDate);
    }

    public long getDaysBetween(Rental rental) {
        return (dateOrder(rental)) ? ChronoUnit.DAYS.between(this.startDate, rental.startDate) : ChronoUnit.DAYS.between(rental.startDate, this.startDate);
    }

    public void printTimeBetweenRentals(Rental rental) {
        System.out.printf("Years between two rentals: %d\n", getYearsBetween(rental));
        System.out.printf("Months between two rentals: %d\n", getMonthsBetween(rental));
        System.out.printf("Days between two rentals: %d\n", getDaysBetween(rental));
    }

    public void printDaysBetweenEndAndStartDateOfTwoRentals(Rental rental) {
        long daysBetween = 0;
        if (dateOrder(rental))
            System.out.println("Days between end of rental 1 and start of rental 2: " + ChronoUnit.DAYS.between(this.getEndDate(), rental.startDate));
        else
            System.out.println("Days between end of rental 2 and start of rental 1: " + ChronoUnit.DAYS.between(rental.startDate, this.startDate));
    }

    public void printRental() {
        System.out.println(toString());
        System.out.println("-----------------------------");
        System.out.printf("Total price: %.2f\n", getTotalPrice());
        System.out.println("End date: " + getEndDate());
        System.out.println("The day before start date: " + getStartDate().minusDays(1));
        System.out.println("-----------------------------\n");
    }
}
