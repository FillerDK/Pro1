package storage;

import model.Costumer;
import model.Seat;
import model.Show;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Show> shows = new ArrayList<>();
    private static final ArrayList<Costumer> costumers = new ArrayList<>();
    private static final ArrayList<Seat> seats = new ArrayList<>();

    public static void storeShow(Show show){
        shows.add(show);
    }

    public static void storeCostumer(Costumer costumer){
        costumers.add(costumer);
    }

    public static void storeSeat(Seat seat){
        seats.add(seat);
    }

    public static ArrayList<Show> getShows(){
        return new ArrayList<>(shows);
    }

    public static ArrayList<Costumer> getCostumers(){
        return new ArrayList<>(costumers);
    }

    public static ArrayList<Seat> getSeats(){
        return new ArrayList<>(seats);
    }
}
