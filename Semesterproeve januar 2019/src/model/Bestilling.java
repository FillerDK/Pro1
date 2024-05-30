package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    // section S1
    private final LocalDate dato;

    /**
     * Association 1 --> 0..* Plads
     */
    private final ArrayList<Plads> pladser = new ArrayList<>();

    /**
     * Forced association 0..* --> 1 Kunde
     */
    private final Kunde kunde;

    /**
     * Forced association 0..* --> 1 Forestilling
     */
    private final Forestilling forestilling;

    public Bestilling(LocalDate dato, Kunde kunde, Forestilling forestilling) {
        this.dato = dato;
        this.kunde = kunde;
        this.forestilling = forestilling;
    }

    // section addere
    /**
     * Tilføjer en ny plads til denne bestilling.
     *
     * @param plads Plads, der skal tilføjes
     */
    public void addPlads(Plads plads) {
        pladser.add(plads);
    }

    public void addPladser(ArrayList<Plads> pladser) {
        for (Plads plads : pladser) {
            this.pladser.add(plads);
        }
    }

    // section gettere
    /**
     * Henter alle pladser for denne bestilling.
     *
     * Note: nullable
     */
    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    /**
     * Returnerer datoen for denne bestilling.
     *
     * @return
     */
    public LocalDate getDato() {
        return dato;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }

    // section S2
    /**
     * Returnerer den samlede pris for en bestilling.
     *
     * @return
     */
    public int samletPris() {
        int samletPris = 0;

        for (Plads plads : pladser) {
            samletPris += plads.getPris();
        }

        return samletPris;
    }
}
