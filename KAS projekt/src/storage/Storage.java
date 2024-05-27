package storage;

import model.Deltager;
import model.Hotel;
import model.Konference;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Deltager> deltagere = new ArrayList<>();
    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Hotel> hoteller = new ArrayList<>();

    public static ArrayList<Deltager> hentDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public static ArrayList<Konference> hentKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static ArrayList<Hotel> hentHoteller() {
        return new ArrayList<>(hoteller);
    }

    public static void storeDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public static void storeKonferencer(Konference konference) {
        konferencer.add(konference);
    }

    public static void storeHoteller(Hotel hotel) {
        hoteller.add(hotel);
    }
}