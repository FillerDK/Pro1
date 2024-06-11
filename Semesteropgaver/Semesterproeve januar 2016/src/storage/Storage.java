package storage;

import model.Bane;
import model.Medlem;

import java.util.ArrayList;

public abstract class Storage {
    // section S4
    private static final ArrayList<Bane> baner = new ArrayList<>();
    private static final ArrayList<Medlem> medlemmer = new ArrayList<>();

    // store
    public static void storeBane(Bane bane) {
        baner.add(bane);
    }

    public static void storeMedlem(Medlem medlem) {
        medlemmer.add(medlem);
    }

    // getters
    public static ArrayList<Bane> getBaner() {
        return new ArrayList<>(baner);
    }

    public static ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<>(medlemmer);
    }
}
