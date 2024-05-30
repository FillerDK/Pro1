package storage;

import model.Bane;
import model.Kategori;
import model.Spiller;

import java.util.ArrayList;

public abstract class Storage {
    // section S5
    private static final ArrayList<Spiller> spillere = new ArrayList<>();
    private static final ArrayList<Bane> baner = new ArrayList<>();
    private static final ArrayList<Kategori> kategorier = new ArrayList<>();

    public static void storeSpiller(Spiller spiller) {
        spillere.add(spiller);
    }

    public static void storeBane(Bane bane) {
        baner.add(bane);
    }

    public static void storeKategori(Kategori kategori) {
        kategorier.add(kategori);
    }

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<>(spillere);
    }

    public static ArrayList<Bane> getBaner() {
        return new ArrayList<>(baner);
    }

    public static ArrayList<Kategori> getKategorier() {
        return new ArrayList<>(kategorier);
    }
}
