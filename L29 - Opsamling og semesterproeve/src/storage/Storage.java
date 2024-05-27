package storage;

import model.Fag;
import model.Studerende;

import java.util.ArrayList;

public abstract class Storage {
    private static ArrayList<Fag> alleFag = new ArrayList<>();
    private static ArrayList<Studerende> alleStuderende = new ArrayList<>();

    public static void storeFag(Fag fag) {
        alleFag.add(fag);
    }

    public static ArrayList<Fag> getAlleFag() {
        return new ArrayList<>(alleFag);
    }

    public static void storeStuderende(Studerende studerende) {
        alleStuderende.add(studerende);
    }

    public static ArrayList<Studerende> getAlleStuderende() {
        return new ArrayList<>(alleStuderende);
    }
}
