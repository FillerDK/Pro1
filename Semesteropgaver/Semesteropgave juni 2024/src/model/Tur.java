package model;

import java.time.LocalDate;

@SuppressWarnings("GrazieInspection")
public class Tur {
    // section S1
    private final LocalDate dato;
    private final int antalMinutter;
    private final int antalKm;

    /**
     * Forced association 0..* --- 1 Deltager
     */
    private final Deltager deltager;

    public Tur(LocalDate dato, int antalMinutter, int antalKm, Deltager deltager) {
        this.dato = dato;
        this.antalMinutter = antalMinutter;
        this.antalKm = antalKm;
        this.deltager = deltager;
    }

    // getters
    public Deltager getDeltager() {
        return deltager;
    }

    public int getAntalKm() {
        return antalKm;
    }

    public int getAntalMinutter() {
        return antalMinutter;
    }

    @Override
    public String toString() {
        return String.format("%s, %d min, %d km", dato, antalMinutter, antalKm);
    }
}
