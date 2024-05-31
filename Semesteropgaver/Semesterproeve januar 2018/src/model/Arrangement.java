package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Arrangement {
    // section S1
    private final String titel;
    private final LocalDate dato;
    private final LocalTime startTid;
    private final LocalTime slutTid;
    private final double pris;

    public Arrangement(String titel, LocalDate dato, LocalTime startTid, LocalTime slutTid, double pris) {
        this.titel = titel;
        this.dato = dato;
        this.startTid = startTid;
        this.slutTid = slutTid;
        this.pris = pris;
    }

    // section getters
    public double getPris() {
        return pris;
    }

    public LocalDate getDato() {
        return dato;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", titel, dato, startTid, slutTid);
    }
}
