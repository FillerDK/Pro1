package model;

import java.util.ArrayList;

public class Salg {
    // section S4
    private final String købersNavn;
    private final int aftaltSamletPris;

    /**
     * Association 0..1 --> 0..* Vare
     */
    private final ArrayList<Vare> varer;

    public Salg(String købersNavn, int aftaltSamletPris, ArrayList<Vare> varer) {
        this.købersNavn = købersNavn;
        this.aftaltSamletPris = aftaltSamletPris;
        this.varer = varer;
        sætAlleVarerTilSolgt();
        opdaterVare();
    }

    // section getters
    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public String getKøbersNavn() {
        return købersNavn;
    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    // section setters
    /**
     * Sætter alle varer i salget til solgt.
     */
    public void sætAlleVarerTilSolgt() {
        for (Vare vare : varer) {
            vare.setSolgt(true);
        }
    }

    // section S7
    /**
     * Kører igennem alle varer og finder deres salgsannoncer,
     * hvori metoden opdaterAnnonce() køres.
     */
    public void opdaterVare() {
        for (Vare vare : varer) {
            Salgsannonce salgsannonce = vare.getSalgsannonce();
            vare.getSalgsannonce().opdaterAnnonce();
        }
    }
}
