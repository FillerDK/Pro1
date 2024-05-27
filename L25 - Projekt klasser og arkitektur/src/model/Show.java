package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Show {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private final ArrayList<Reservation> reservations = new ArrayList<>();

    public Show(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public boolean isSeatAvaliable(int row, int seat, LocalDate date) {
        boolean isSeatAvaliable = true;
        for (Reservation e : reservations) {
            if (date.equals(e.getDate())) {
                for (Seat s : e.getSeats()) {
                    if (seat == s.getNum() && row == s.getRow()) {
                        isSeatAvaliable = false;
                    }
                }
            }
        }
        return isSeatAvaliable;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    public int getBookedSeatCount(LocalDate date) {
        int count = 0;
        for (Reservation e : reservations) {
            if (e.getDate().equals(date)) {
                for (Seat s : e.getSeats()) {
                    count++;
                }
            }
        }
        return count;
    }

    public LocalDate getSucessDate() {
        int bestCount = 0;
        LocalDate bestDate = null;
        LocalDate date = startDate;
        Period period = Period.between(startDate, endDate);

        for (int i = 0; i < period.getDays(); i++) {
            if (getBookedSeatCount(date) > bestCount) {
                bestCount = getBookedSeatCount(date);
                bestDate = date;
            }
            date = date.plusDays(1);
        }
        return bestDate;
    }

    @Override
    public String toString() {
        return String.format("%s (From %s to %s)", name, startDate, endDate);
    }


}
