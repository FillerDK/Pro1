package model;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Costumer {
    private String name;
    private String phone;
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public Costumer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void addReservation (Reservation reservation){
        reservations.add(reservation);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Seat> getBookedSeats(Show show, LocalDate date){
        ArrayList<Seat> seats = new ArrayList<>();
        for (Reservation e : reservations){
           if (e.getDate().equals(date)){
               for (Seat s: e.getSeats()){
                   seats.add(s);
               }
           }
        }
        return seats;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, phone);
    }

}
