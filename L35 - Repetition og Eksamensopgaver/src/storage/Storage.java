package storage;

import model.Forestilling;
import model.Kunde;

import java.util.ArrayList;

public abstract class Storage {
    // section S6
    private static final ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private static final ArrayList<Kunde> kunder = new ArrayList<>();

    // section adders
    /**
     * Tilføjer en forestilling til listen af forestillinger.
     *
     * @param forestilling Forestilling, der bliver tilføjet til listen.
     */
    public static void addForestilling(Forestilling forestilling) {
        forestillinger.add(forestilling);
    }

    /**
     * Tilføjer en kunde til listen af kunder.
     *
     * @param kunde Kunde, der bliver tilføjet til listen.
     */
    public static void addKunde(Kunde kunde) {
        kunder.add(kunde);
    }

    // section getters

    /**
     * Returnerer en liste over alle forestillinger i systemet.
     *
     * @return
     */
    public static ArrayList<Forestilling> getForestillinger() {
        return new ArrayList<>(forestillinger);
    }

    /**
     * Returnrer en liste over alle kunder i systemet.
     * @return
     */
    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }
}
