package storage;

import model.Salg;
import model.Sælger;
import model.Vare;

import java.util.ArrayList;

public abstract class Storage {
    // section S5
    private static final ArrayList<Sælger> sælgere = new ArrayList<>();
    private static final ArrayList<Vare> varer = new ArrayList<>();
    private static final ArrayList<Salg> alleSalg = new ArrayList<>();

    // section store
    public static void storeSælger(Sælger sælger) {
        sælgere.add(sælger);
    }

    public static void storeVare(Vare vare) {
        varer.add(vare);
    }

    public static void storeSalg(Salg salg) {
        alleSalg.add(salg);
    }

    // section getters
    public static ArrayList<Sælger> getSælgere() {
        return new ArrayList<>(sælgere);
    }

    public static ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public static ArrayList<Salg> getSalg() {
        return new ArrayList<>(alleSalg);
    }
}
