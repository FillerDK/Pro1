package gui;

import controller.Controller;
import javafx.application.Application;
import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);



    }

    public static void testPrint(){

        for (Show e : Storage.getShows()){
            System.out.println(e);
        }

        for (Costumer e : Storage.getCostumers()){
            System.out.println(e);
        }

        for (Seat e : Storage.getSeats()){
            System.out.println(e);
        }
    }

    public static void initStorage() {
        Show evita = Controller.createShow("Evita", LocalDate.of(2024, 4, 10), LocalDate.of(2024, 4, 20));
        Show lykkePer = Controller.createShow("Lykke Per", LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 10));
        Show chess = Controller.createShow("Chess", LocalDate.of(2024, 4, 21), LocalDate.of(2024, 4, 30));

        Costumer anders = Controller.createCostumer("Anders Hansen", "11223344");
        Costumer peter = Controller.createCostumer("Peter Jensen", "12345678");
        Costumer niels = Controller.createCostumer("Niels Madsen", "12341234");

        Controller.createSeats();


//        ArrayList<Seat> seatsOne  = new ArrayList<>();
//        seatsOne.add(new Seat(1,5,400,SeatType.STANDARD));
//        seatsOne.add(new Seat(1,5,400,SeatType.STANDARD));
//        Reservation reservationOne = Controller.createReservationWithSeats(lykkePer, anders, LocalDate.of(2024,4,10), seatsOne);
//        lykkePer.addReservation(reservationOne);
//        ArrayList<Seat> seatsTwo  = new ArrayList<>();
//        seatsTwo.add(new Seat(2,6,400,SeatType.STANDARD));
//       seatsTwo.add(new Seat(2,5,400,SeatType.STANDARD));
//        Reservation reservationTwo = Controller.createReservationWithSeats(lykkePer, niels, LocalDate.of(2024,4,10), seatsTwo);
//        System.out.println(lykkePer.getBookedSeatCount(LocalDate.of(2024,4,10)));
//        System.out.println(lykkePer.getSucessDate());
    }
}
