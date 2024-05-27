package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    // section S1
    private final LocalDate dato;
    private final LocalTime tid;
    private final boolean single;

    /**
     * Forced association 0..* --> 1 Spiller
     */
    private final Spiller spiller;

    /**
     * Association 0..* --> 1 Bane
     */
    private Bane bane;

    public Booking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller, Bane bane) {
        this.dato = dato;
        this.tid = tid;
        this.single = single;
        this.spiller = spiller;
        this.bane = bane;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public Bane getBane() {
        return bane;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public boolean isSingle() {
        return single;
    }

    public int beregnPris() {
        int pris = 0;

        if (single)
            pris = bane.getKategori().getPrisKrSingle();
        else pris = bane.getKategori().getPrisKrDouble();

        return pris;
    }

    @Override
    public String toString() {
        String størrelse;
        if (isSingle())
            størrelse = "single";
        else størrelse = "double";
        return String.format("%s kl. %s, %s, bane nr. %d, %s",
                dato, tid, størrelse, bane.getNummer(), spiller.getNavn());
    }
}
