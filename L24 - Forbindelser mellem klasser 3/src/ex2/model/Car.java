package ex2.model;

import java.util.ArrayList;

public class Car {
    private final String no; // registration number
    private final String year; // year of first registration
    private int pricePerDay;

    private final ArrayList<Rental> rentals = new ArrayList<>();

    public Car(String no, String year) {
        this.no = no;
        this.year = year;
    }

    public void setPricePerDay(int price) {
        pricePerDay = price;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public String getNo() {
        return no;
    }

    public String getYear() {
        return year;
    }

    // --------------------------------------

    public ArrayList<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public void removeRental(Rental rental) {
        rentals.remove(rental);
    }

    public int getLongestRental() {
        int mostDays = 0;
        for (Rental rental : rentals) {
            if (rental.getDays() > mostDays)
                mostDays = rental.getDays();
        }
        return mostDays;
    }
}
