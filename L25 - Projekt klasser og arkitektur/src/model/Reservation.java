package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reservation {
    private LocalDate date;
    private final Show show;
    private Costumer costumer;
    private final ArrayList<Seat> seats = new ArrayList<>();

    public Reservation(LocalDate date, Show show, Costumer costumer){
        this.date = date;
        this.show = show;
        this.costumer = costumer;
    }


    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public void addSeat(Seat seat){
        seats.add(seat);
    }

    public ArrayList<Seat> getSeats(){
        return new ArrayList<>(seats);
    }

    public LocalDate getDate() {
        return date;
    }

    public int calcTotalPrice(){
        int totalPrice = 0;
        for (Seat e : seats){
           totalPrice += e.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s has a reservation for %s(%s), with %s", costumer, show, date, seats);
    }
}
