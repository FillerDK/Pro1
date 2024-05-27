package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {

    public static Show createShow(String name, LocalDate startDate, LocalDate endDate) {
        Show show = new Show(name, startDate, endDate);
        Storage.storeShow(show);
        return show;
    }

    public static Costumer createCostumer(String name, String phone) {
        Costumer costumer = new Costumer(name, phone);
        Storage.storeCostumer(costumer);
        return costumer;
    }

    public static Seat createSeat(int row, int nr, int price, SeatType seatType) {
        Seat seat = new Seat(row, nr, price, seatType);
        Storage.storeSeat(seat);
        return seat;
    }

    public static ArrayList<Show> getShows() {
        return Storage.getShows();
    }

    public static ArrayList<Costumer> getCostumers() {
        return Storage.getCostumers();
    }

    public static ArrayList<Seat> getSeats(){return Storage.getSeats();}



    public static Boolean isSeatAvailable(Show show, int row, int seat, LocalDate date){
        return show.isSeatAvaliable(row,seat,date);
    }

    public static void createSeats() {
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 20; j++) {
                int price = calculateSeatPrice(i,j);
                SeatType st = calculateSeatType(i,j);
                Controller.createSeat(i, j, price, st);
            }
        }
    }

    public static Reservation createReservationWithSeats(Show show, Costumer costumer, LocalDate date, ArrayList<Seat> seats){
        boolean reservationIsPossible = true;
        Reservation reservation = new Reservation(date, show, costumer);

        if (date.isBefore(show.getStartDate()) || date.isAfter(show.getEndDate())){
            reservationIsPossible = false;
        }

        for (Seat seat: seats){
            if (show.isSeatAvaliable(seat.getRow(),seat.getNum(),date)){
                reservation.addSeat(seat);
            } else{
               reservationIsPossible = false;
            }
        }

        if (reservationIsPossible) {
            costumer.addReservation(reservation);
            show.addReservation(reservation);
        }else{
            reservation = null;
        }
            return reservation;
    }


    private static SeatType calculateSeatType(int row, int seat){
        SeatType st = SeatType.STANDARD;
        if (seat > 7 && seat < 13) {
            if (row == 10) st = SeatType.WHEELCHAIR;
            if (row == 11) st = SeatType.EXTRALEGSPACE;
        }
        return st;

    }

    private static int calculateSeatPrice(int row, int seat){
        int price;
        if (seat < 3 || seat > 18) {
            // inner seats
            if (row < 6) price = 450;
            else price = 400;
        } else {
            //outer seats
            if (row < 6) price = 500;
            else if (seat < 11) price = 450;
            else price = 400;
        }
        return price;
    }
}

