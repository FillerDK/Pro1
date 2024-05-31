package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
    // section S1
    private final String navn;
    private final String mobil;

    /**
     * Association 1 --> 0..* Bestilling
     */
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    // section addere
    public void addBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    // section gettere
    /**
     * Henter alle bestillinger for denne kunde
     *
     * Note: nullable
     */
    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    @Override
    public String toString() {
        return String.format("%s %s", navn, mobil);
    }

    // section S5
    /**
     * Returnerer alle bestilte pladser til en
     * forestilling på en given dato.
     *
     * Note: nullable
     *
     * @param forestilling Forestilling, som der skal tjekkes for.
     * @param dato Dato, som der skal tjekkes for.
     * @return
     */
    public ArrayList<Plads> bestiltePladserTilForestillingPåDag(Forestilling forestilling,
                                                                LocalDate dato) {
        ArrayList<Plads> bestiltePladser = new ArrayList<>();

        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getForestilling() == forestilling && bestilling.getDato().equals(dato))
                for (Plads plads : bestilling.getPladser()) {
                    bestiltePladser.add(plads);
                }
        }

        return bestiltePladser;
    }

}
